package com.turcologica.courses;

import com.turcologica.users.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping("my-courses")
    public String listAllPersonalCourses(ModelMap modelMap) {
        String username = UserService.getNameOfCurrentUser();
        List<Course> courseList = courseRepository.findByNameAttendingUser(username);
        modelMap.addAttribute("courseList", courseList);
        return "my-courses";
    }

    @RequestMapping("all-courses")
    public String listAllCourses(ModelMap modelMap) {
        List<Course> courseList = courseRepository.findAll();
        modelMap.addAttribute("courseList", courseList);
        return "all-courses";
    }

    @RequestMapping(value="create-course", method = RequestMethod.GET)
    public String initCreateCoursePage(ModelMap modelMap) {
        String username = UserService.getNameOfCurrentUser();
        modelMap.put("course", new Course("", "", "", username));
        return "create-course";
    }

    @RequestMapping(value="create-course", method = RequestMethod.POST)
    public String createCourse(@Valid Course course, BindingResult result) {

        if(result.hasErrors()) {
            return "create-todo";
        }
        courseRepository.save(course);
        return "redirect:all-courses";
    }
}
