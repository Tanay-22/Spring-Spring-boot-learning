package com.tanay.learnspringframework;

import com.tanay.learnspringframework.config.GamingConfiguration;
import com.tanay.learnspringframework.game.GameRunner;
import com.tanay.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GamingApp
{
    public static void main(String[] args)
    {

        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
        {

            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();

        }
    }
}
