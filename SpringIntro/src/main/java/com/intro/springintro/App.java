package com.intro.springintro;

import com.tanay.cars.Corolla;
import com.tanay.cars.Swift;
import com.tanay.interfaces.Car;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main(String[] args)
    {
        Car swift = new Swift();
        Car corolla = new Corolla();

        /*System.out.println(swift.specs());
        System.out.println(corolla.specs());*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // initializes the Spring application context using the configuration specified in the AppConfig class
        Car myCar = context.getBean("corolla", Car.class);
        System.out.println(myCar.specs());;
        context.close();
    }
}
