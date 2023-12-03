package com.turcologica.courses;

import com.turcologica.users.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping("my-courses")
    public String listAllPersonalCourses(ModelMap modelMap) {
        String username = UserService.getUsernameOfCurrentUser();
        List<Course> courseList = courseRepository.findByNameAttendingUser(username);
        modelMap.addAttribute("courseList", courseList);
        return "my-courses";
    }

    @RequestMapping("admin-course-view")
    public String listAllCourses(ModelMap modelMap) {
        List<Course> courseList = courseRepository.findAll();
        modelMap.addAttribute("courseList", courseList);
        return "admin-course-view";
    }

    @RequestMapping(value="create-course", method = RequestMethod.GET)
    public String initCreateCoursePage(ModelMap modelMap) {
        String username = UserService.getUsernameOfCurrentUser();
        modelMap.put("course", new Course("", "", "", username));
        return "create-modify-course";
    }

    @RequestMapping(value="create-course", method = RequestMethod.POST)
    public String createCourse(@Valid Course course, BindingResult result) {

        if(result.hasErrors()) {
            return "create-modify-course";
        }
        courseRepository.save(course);
        return "redirect:admin-course-view";
    }

    @RequestMapping("delete-course")
    public String deleteCourse(@RequestParam long id) {
        courseRepository.deleteById(id);
        return "redirect:admin-course-view";
    }

    @RequestMapping(value="modify-course", method = RequestMethod.GET)
    public String initModifyCoursePage(@RequestParam long id, ModelMap modelMap) {
        Optional<Course> course = courseRepository.findById(id);
        course.ifPresentOrElse(value -> modelMap.addAttribute("course", value), () -> {throw new NullPointerException();});
        return "create-modify-course";
    }

    @RequestMapping(value="modify-course", method = RequestMethod.POST)
    public String modifyCourse(@Valid Course course, BindingResult result) {

        if(result.hasErrors()) {
            return "create-modify-course";
        }
        courseRepository.save(course);
        return "redirect:admin-course-view";
    }
}
