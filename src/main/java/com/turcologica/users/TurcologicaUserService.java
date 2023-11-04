package com.turcologica.users;

import org.springframework.stereotype.Service;

@Service
public class TurcologicaUserService extends UserService {


    private static TurcologicaUserRepository turcologicaUserRepository = null;

    public TurcologicaUserService(TurcologicaUserRepository turcologicaUserRepository) {
        TurcologicaUserService.turcologicaUserRepository = turcologicaUserRepository;
    }

    public static String getFullNameOfCurrentUser() {
        return turcologicaUserRepository.findByUserDetailsUsername(UserService.getNameOfCurrentUser()).getFullName();
    }
}
