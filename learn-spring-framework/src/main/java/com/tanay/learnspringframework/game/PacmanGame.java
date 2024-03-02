package com.tanay.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pacman")
public class PacmanGame implements GamingConsole
{

    public void up()
    {
        System.out.println("up");
    }

    public void down()
    {
        System.out.println("down");
    }

    public void left()
    {
        System.out.println("left");
    }

    public void right()
    {
        System.out.println("right");
    }

}
