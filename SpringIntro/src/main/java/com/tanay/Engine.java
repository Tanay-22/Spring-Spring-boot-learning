package com.tanay;

import org.springframework.stereotype.Component;

@Component
public class Engine
{
    public String type;

    public Engine()
    {
        this.type = "V8";
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
