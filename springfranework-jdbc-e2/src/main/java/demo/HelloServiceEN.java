package demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("en")
public class HelloServiceEN implements HelloService
{
    @Override
    public String sayHello(String name)
    {
        return "Hello, " + name + "!";
    }
}
