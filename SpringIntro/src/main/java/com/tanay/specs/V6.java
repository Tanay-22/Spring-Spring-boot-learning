package com.tanay.specs;

import com.tanay.interfaces.Engine;
import org.springframework.stereotype.Component;

/*@Component("V6Engine")*/
public class V6 implements Engine
{
    @Override
    public String type()
    {
        return "V6 engine";
    }
}
