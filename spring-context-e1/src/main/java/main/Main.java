package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductDeliveryService;

public class Main
{
    public static void main(String[] args)
    {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class))
        {
            /*// by name
            MyBean b1 = context.getBean("myBean1", MyBean.class);
            MyBean b2 = context.getBean("myBean2", MyBean.class);
            MyBean b3 = context.getBean("dogeBean", MyBean.class);

            System.out.println(b1.getText());
            System.out.println(b2.getText());
            System.out.println(b3.getText());*/

            ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
            service.addSomeProducts();
        }
    }
}
