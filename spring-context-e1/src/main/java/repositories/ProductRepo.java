package repositories;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo
{
    public void add()
    {
        System.out.println("A new Product was added");
    }
}
