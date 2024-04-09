package com.tanay.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    public boolean authenticate(String username, String password)
    {
        boolean isValidUsername =  username.equalsIgnoreCase("DogRaj");
        boolean isValidPassword = password.equals("Mr. India@1402");

        return isValidPassword && isValidUsername;
    }
}
