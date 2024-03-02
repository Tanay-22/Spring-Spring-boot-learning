package com.tanay.learnspringframework;

import com.tanay.learnspringframework.game.GameRunner;
import com.tanay.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tanay.learnspringframework.game")
public class GamingApp
{
    public static void main(String[] args)
    {

        try (var context = new AnnotationConfigApplicationContext(GamingApp.class))
        {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
