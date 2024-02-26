package services;

import org.springframework.stereotype.Service;

@Service
public class HelloService
{
    public String hello(String name)
    {
        String result = "Hello, " + name + "!";
        System.out.println(result); // 2nd execution with name = "DogRaj"
//        throw new RuntimeException("Runtime Exception!!");
        return result;
    }
}
