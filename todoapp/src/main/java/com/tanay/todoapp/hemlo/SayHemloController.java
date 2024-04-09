package com.tanay.todoapp.hemlo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHemloController
{
    @RequestMapping("/say-hemlo")
    public String sayHemloJsp()
    {
        return "sayHello";
    }
}
