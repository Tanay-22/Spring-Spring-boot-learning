package com.tanay.springmvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome()
    {
        return "hello";
    }

    /*@RequestMapping("displayName")
    public String displayName(HttpServletRequest request)
    {
        String firstName = request.getParameter("firstName");
        request.setAttribute("firstName", firstName);
        return "displayName";
    }*/

    // Spring way
    /*@RequestMapping("displayName")
    public String displayName(@RequestParam("firstName") String firstName, Model model)
    {
        model.addAttribute("name", firstName);
        return "displayName";
    }*/

    // Better version
    @GetMapping("displayName")      // only handles "get" req
    public ModelAndView displayName(@RequestParam("firstName") String firstName)
    {
        ModelAndView modelAndView = new ModelAndView("displayName");
        Date date = new Date();
        List<String> list = new ArrayList<>();

        list.add("John");
        list.add("Alice");
        list.add("Bob");
        list.add("Emily");

        modelAndView.addObject("date", date);
        modelAndView.addObject("name", firstName);
        modelAndView.addObject("list", list);

        return modelAndView;
    }
}
