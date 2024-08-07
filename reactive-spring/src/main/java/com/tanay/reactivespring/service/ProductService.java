package com.tanay.reactivespring.service;

import com.tanay.reactivespring.model.Product;
import com.tanay.reactivespring.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;


@Service
public class ProductService
{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    // Flux<> -> A Reactive Streams Publisher with rx operators that emits 0 to N elements,
    // and then completes (successfully or with an error).

    public Flux<Product> getProducts()
    {
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(5));   //  for any element adds a sleep duration\
        // n products -> a little more than 5n sec
    }
}
