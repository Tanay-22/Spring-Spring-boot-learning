package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = {"repositories", "services"})
public class ProjectConfig
{
    /*@Bean
    @Primary
    public MyBean myBean1()
    {
        MyBean bean =  new MyBean();
        bean.setText("Hemlo DogRaj");
        return bean;
    }

    @Bean
    public MyBean myBean2()
    {
        MyBean bean =  new MyBean();
        bean.setText("Huihui DogRaj");
        return bean;
    }

    @Bean("dogeBean")
    public MyBean myBean3()
    {
        MyBean bean =  new MyBean();
        bean.setText("Maharaj DogRaj");
        return bean;
    }*/


}
