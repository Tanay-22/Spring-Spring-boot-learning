package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class))
        {
            Owner owner = context.getBean(Owner.class);
            Cat cat = context.getBean(Cat.class);


            cat.setName("Jack");
            System.out.println(cat);
            System.out.println(owner);
        }
    }
}
