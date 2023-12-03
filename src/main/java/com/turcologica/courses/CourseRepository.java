package com.turcologica.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public List<Course> findByCourseName(String username);

    public List<Course> findByLecturer(String lecturer);

    public List<Course> findByNameAttendingUser(String nameAttendingUser);
}
