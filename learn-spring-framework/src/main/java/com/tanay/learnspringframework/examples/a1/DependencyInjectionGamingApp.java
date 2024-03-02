package com.tanay.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass
{
    Dependency1 dependency1;
    Dependency2 dependency2;

    /*@Autowired          // field injection is automatically done
    public void setDependency1(Dependency1 dependency1)
    {
        this.dependency1 = dependency1;
    }

    public void setDependency2(Dependency2 dependency2)
    {
        this.dependency2 = dependency2;
    }*/

    @Autowired          // field injection is automatically done
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2)
    {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    @Override
    public String toString()
    {
        return "YourBusinessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}

@Component
class Dependency1
{

}

@Component
class Dependency2
{

}
@Configuration
@ComponentScan
public class DependencyInjectionGamingApp
{
    public static void main(String[] args)
    {

        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionGamingApp.class))
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
