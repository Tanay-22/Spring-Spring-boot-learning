package com.tanay.reactivespring.repository;

import com.tanay.reactivespring.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer>
{

}
