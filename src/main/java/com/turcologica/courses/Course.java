package com.turcologica.courses;

import com.turcologica.users.turcologica.TurcologicaUser;
import com.turcologica.users.turcologica.TurcologicaUserRepository;
import com.turcologica.users.turcologica.TurcologicaUserService;
import jakarta.persistence.*;

import java.util.Set;

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

    @ManyToMany(mappedBy = "attendedCourseSet")
    private Set<TurcologicaUser> studentSet;

    @ManyToMany(mappedBy = "taughtCourseSet")
    private Set<TurcologicaUser> lecturerSet;

    public Course(String courseName, String coursePrefix, String lecturer, String nameAttendingUser) {
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
