package com.example.beans;

public class User
{
    private String firstName, lastName;

    public User()
    {
        this.firstName = "DogRaj";
        this.lastName = "Pandey";
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
