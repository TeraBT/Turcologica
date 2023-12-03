package com.turcologica.users;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static String getUsernameOfCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
