package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class Main
{
    public static void main(String[] args)
    {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class))
        {
            HelloService service = context.getBean(HelloService.class);
            String msg = service.hello("Knull");
            System.out.println("Result is " + msg);
        }
    }
}
