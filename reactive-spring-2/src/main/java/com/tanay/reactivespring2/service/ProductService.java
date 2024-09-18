package com.tanay.reactivespring2.service;

import com.tanay.reactivespring2.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService
{
    public Flux<Product> getAll()
    {
        Product p1 = new Product();
        p1.setName("Beer");

        Product p2 = new Product();
        p2.setName("Chocolate");

        Flux<Product> products = Flux.fromStream(List.of(p1, p2).stream())
                .delayElements(Duration.ofSeconds(3));

        return products;
    }
}
