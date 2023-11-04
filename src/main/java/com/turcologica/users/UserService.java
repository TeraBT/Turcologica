package com.turcologica.users;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class UserService {
    public static String getNameOfCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
