package com.tanay.cars;


import com.tanay.interfaces.Car;
import com.tanay.interfaces.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*@Component("corolla")*/
public class Corolla implements Car
{
     /*Autowiring feature of spring framework enables
    you to inject the object dependency implicitly.
    It internally uses setter or constructor injection.
    Autowiring can't be used to inject primitive and string values.
    It works with reference only.*/
    // uses default constructor (not parameterized)
    @Autowired(required = false)    // if 'engine' is not required, spring will skip the creation of object 'engine'
    @Qualifier("V8Engine")  //The @Autowired annotation is a great way of making the need to inject a dependency in Spring explicit.
     Engine engine;

    /*@Autowired
    public void setEngine(Engine engine)
    {
        engine.type = "New V8 Engine";
        this.engine = engine;
    }*/

    public String specs()
    {
        return "Sedan from Toyota with engine type as " + engine.type();
    }
}
