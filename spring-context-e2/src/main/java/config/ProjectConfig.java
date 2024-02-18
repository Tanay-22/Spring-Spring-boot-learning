package config;

import beans.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import beans.Cat;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig
{
    /*@Bean
    public Cat cat()
    {
        Cat cat = new Cat();
        cat.setName("Oggy");
        return cat;
    }

    @Bean
    public Owner owner()
    {
        Owner owner = new Owner();
        owner.setCat(cat());    // here it appears to call() & make a copy of call() but it doesn't happen
        // spring links cat with its owner
        return owner;
    }*/

    @Bean @Qualifier("cat1")
    public Cat cat1()
    {
        Cat c = new Cat();
        c.setName("Oggy");
        return c;
    }

    @Bean @Qualifier("cat2")
    public Cat cat2()
    {
        Cat c = new Cat();
        c.setName("Tom");
        return c;
    }
}
