package com.tanay.reactivespring.controller;

import com.tanay.reactivespring.model.Product;
import com.tanay.reactivespring.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ProductController
{
    private final ProductService productService;


    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    //  returns a stream of events
    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProducts()
    {
        return productService.getProducts();
    }
}
