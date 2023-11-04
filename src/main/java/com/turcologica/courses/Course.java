package com.turcologica.courses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Entity
@Table(name="COURSE")
public class Course {

    @Id
    @GeneratedValue
    private Long courseID;
    private String courseName;
    private String coursePrefix;
    private String lecturer;
    private String nameAttendingUser;
//    private List<User> users; //TODO: ManyToOne from User's view


    public Course(String courseName, String coursePrefix, String lecturer, String nameAttendingUser) {
//        this.courseID = courseID;
        this.courseName = courseName;
        this.coursePrefix = coursePrefix;
        this.lecturer = lecturer;
        this.nameAttendingUser = nameAttendingUser;
    }

    public Course() {
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrefix() {
        return coursePrefix;
    }

    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getNameAttendingUser() {
        return nameAttendingUser;
    }

    public void setNameAttendingUser(String nameAttendingUser) {
        this.nameAttendingUser = nameAttendingUser;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", coursePrefix='" + coursePrefix + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", nameAttendingUser='" + nameAttendingUser + '\'' +
                '}';
    }
}
