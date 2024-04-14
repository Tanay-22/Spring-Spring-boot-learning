package com.tanay.restfulwebservices.hello;

public class HemloWorldBean
{
    private String message;
    public HemloWorldBean(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "HemloWorldBean{" +
                "str='" + message + '\'' +
                '}';
    }
}
