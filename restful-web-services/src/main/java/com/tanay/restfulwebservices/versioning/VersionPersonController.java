package com.tanay.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController //Twitter
{
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson()
    {
        return new PersonV1("Tanay Pandey");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson()
    {
        return new PersonV2(new Name("Tanay", "Pandey"));
    }

    @GetMapping(path="/person", params = "version=1")   // Amazon
    public PersonV1 getFirstVersionOfPersonWithParams()
    {
        return new PersonV1("Tanay Pandey");
    }

    @GetMapping(value="/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonWithParams()
    {
        return new PersonV2(new Name("Tanay", "Pandey"));
    }

    @GetMapping(path="/person/header", headers = "X-API-VERSION=1")   // Microsoft
    public PersonV1 getFirstVersionOfPersonWithHeader()
    {
        return new PersonV1("Tanay Pandey");
    }

    @GetMapping(value="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithHeader()
    {
        return new PersonV2(new Name("Tanay", "Pandey"));
    }

    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")  // Github
    public PersonV1 getFirstVersionOfPersonWithAcceptHeader()
    {
        return new PersonV1("Tanay Pandey");
    }

    @GetMapping(value="/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeader()
    {
        return new PersonV2(new Name("Tanay", "Pandey"));
    }
}
