package com.tanay.cars;

import com.tanay.Engine;
import com.tanay.interfaces.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("corolla")
public class Corolla implements Car
{
     /*Autowiring feature of spring framework enables
    you to inject the object dependency implicitly.
    It internally uses setter or constructor injection.
    Autowiring can't be used to inject primitive and string values.
    It works with reference only.*/

    @Autowired
    Engine engine;
    public String specs()
    {
        return "Sedan from Toyota with engine type as " + engine.getType();
    }
}
