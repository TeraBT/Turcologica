package com.turcologica.login;

import com.turcologica.users.turcologica.TurcologicaUser;
import com.turcologica.users.turcologica.TurcologicaUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    private TurcologicaUserService turcologicaUserService;

    public LoginController(TurcologicaUserService turcologicaUserService) {
        this.turcologicaUserService = turcologicaUserService;
    }

//    public LoginController() {
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToHome(ModelMap modelMap) {
        modelMap.put("name", turcologicaUserService.getFullNameOfCurrentTurcologicaUser());
        return "home";
    }
}