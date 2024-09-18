package com.tanay.reactivespring2.config;

import com.tanay.reactivespring2.handler.ProductHandler;
import com.tanay.reactivespring2.model.Product;
import com.tanay.reactivespring2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfig
{
    private final ProductService productService;

    public RoutesConfig(ProductService productService)
    {
        this.productService = productService;
    }

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler)
    {
//        both products appear after 6 sec
        /*return route().GET("/products", req -> ok().body(productService.getAll(), Product.class))
                .build();*/

        /*return route().GET("/products", req -> ok().contentType(MediaType.TEXT_EVENT_STREAM)
                        .body(productService.getAll(), Product.class))
                        .build();*/

        return route().GET("/products", productHandler::getAll)
                .build();
//        interval of 3 sec between each product
    }
}
