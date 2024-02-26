package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect
{
    /*@Before("execution(* services.HelloService.hello(..))")
    public void before()
    {
        System.out.println("Before");
    }

    @After("execution(* services.HelloService.hello(..))")
    public void after()
    {
        System.out.println("After");
    }

    @AfterReturning("execution(* services.HelloService.hello(..))")
    public void afterReturning()
    {
        System.out.println("After Returning");
    }*/

    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)
    {
        System.out.println("Around");   // 1st execution
        Object result = null;
        try
        {
            result = proceedingJoinPoint.proceed(new Object[]{"DogRaj"});
            // hello() executes with new Object "DogRaj"
            System.out.println("In proceeding Joint");  // 3rd execution
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @AfterThrowing("execution(* services.HelloService.hello(..))")
    public void afterThrowing()
    {
        System.out.println("After Throwing");
    }
}
