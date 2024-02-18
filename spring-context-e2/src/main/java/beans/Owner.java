package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Owner
{
    @Autowired @Qualifier("cat2")
    private Cat cat;


    /*public Owner(Cat cat)
    {
        this.cat = cat;
    }*/

    public Cat getCat()
    {
        return cat;
    }

    public void setCat(Cat cat)
    {
        this.cat = cat;
    }

    @Override
    public String toString()
    {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
