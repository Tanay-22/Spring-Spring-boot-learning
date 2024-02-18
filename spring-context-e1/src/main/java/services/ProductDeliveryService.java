package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductRepo;

@Service
public class ProductDeliveryService
{
    private final ProductRepo productRepo;

    @Autowired  //to automatically wire beans by type
    public ProductDeliveryService(ProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }

    public void addSomeProducts()
    {
        productRepo.add();
        productRepo.add();
        productRepo.add();
    }
}
