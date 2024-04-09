package com.tanay.todoapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController
{
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap modelMap)
    {
        modelMap.put("name", "DogRaj");
        return "welcome";
    }

    /*@RequestMapping(value = "/", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name,
                                  @RequestParam String password, ModelMap modelMap)
    {
        if(authenticationService.authenticate(name, password))
        {
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "welcome";
        }
        modelMap.put("errorMsg", "Wrong Credentials");
        return "login";
    }*/
}
