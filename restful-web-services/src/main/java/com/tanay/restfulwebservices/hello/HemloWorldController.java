package com.tanay.restfulwebservices.hello;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Rest api
@RestController
public class HemloWorldController
{
    // GET - Retrieve detials of a resource
    // POST - Create a new resource
    // PUT - Update an existing resource
    // PATCH - Update part of a resource
    // DELETE - Delete a resource

    private MessageSource messageSource;

    public HemloWorldController(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld()
    {
        return "Hemlo World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HemloWorldBean helloWorldBean()
    {
        return new HemloWorldBean("Hemlo World Beamm");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HemloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HemloWorldBean("Hemlo World to " + name);
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized()
    {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null,
                "Default Message", locale);

    }
}
