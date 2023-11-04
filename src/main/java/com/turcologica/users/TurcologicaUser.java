package com.turcologica.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
public class TurcologicaUser {

    @Id
    @GeneratedValue
    private long turcologicaUserID;
    private String userDetailsUsername = null;
    private String fullName;

    public TurcologicaUser(UserDetails userDetails, String fullName) {
        this.userDetailsUsername = userDetails.getUsername();
        this.fullName = fullName;
    }

    public TurcologicaUser() {

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
