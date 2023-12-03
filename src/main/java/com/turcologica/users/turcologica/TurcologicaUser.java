package com.turcologica.users.turcologica;

import com.turcologica.courses.Course;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Entity
@Table(name = "TURCOLOGICA_USER")
public class TurcologicaUser {

    @Id
    @GeneratedValue
    private long turcologicaUserID;
//    private UserDetails userDetails;
    private String username;
    private String firstname;
    private String lastname;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "turcologica_user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> attendedCourseSet;

    @ManyToMany
    @JoinTable(name = "lecturer_course",
            joinColumns = @JoinColumn(name = "turcologica_user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> taughtCourseSet;

    public TurcologicaUser(UserDetails userDetails, String firstname, String lastname) {
//        this.userDetails = userDetails;
        this.username = userDetails.getUsername();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public TurcologicaUser() {}


    public String getFullName() {
        return firstname + ' ' + lastname;
    }

    public long getTurcologicaUserID() {
        return turcologicaUserID;
    }

    public void setTurcologicaUserID(long turcologicaUserID) {
        this.turcologicaUserID = turcologicaUserID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void addAttendedCourse(Course course) {
        attendedCourseSet.add(course);
    }

    public void removeAttendedCourse(Course course) {
        attendedCourseSet.remove(course);
    }
}
