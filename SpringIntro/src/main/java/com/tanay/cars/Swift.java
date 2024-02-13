package com.tanay.cars;

import com.tanay.interfaces.Car;
import org.springframework.stereotype.Component;

@Component("swift") // then only spring will consider this as a bean (Dependencies injection)
public class Swift implements Car
{
    public String specs()
    {
        return "Hatchback from Suzuki";
    }
}
