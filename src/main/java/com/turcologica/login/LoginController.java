package com.turcologica.login;

import com.turcologica.users.TurcologicaUser;
import com.turcologica.users.TurcologicaUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToHome(ModelMap modelMap) {
        modelMap.put("name", TurcologicaUserService.getFullNameOfCurrentUser());
        return "home";
    }
}