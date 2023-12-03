package com.turcologica.users.turcologica;

import com.turcologica.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurcologicaUserService extends UserService {

    private TurcologicaUserRepository turcologicaUserRepository;

    public TurcologicaUserService(TurcologicaUserRepository turcologicaUserRepository) {
        this.turcologicaUserRepository = turcologicaUserRepository;
    }

    public String getFullNameOfCurrentTurcologicaUser() {
        return turcologicaUserRepository.findByUsername(UserService.getUsernameOfCurrentUser()).getFullName();
    }
}
