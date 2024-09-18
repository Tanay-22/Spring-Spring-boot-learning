package com.tanay.proxyforproject2.service;

import com.tanay.proxyforproject2.model.Product;
import com.tanay.proxyforproject2.proxy.ProductProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService
{
    private final ProductProxy proxy;

    public ProductService(ProductProxy proxy)
    {
        this.proxy = proxy;
    }

    public Flux<Product> getAll()
    {
        return proxy.getAll();
    }
}
