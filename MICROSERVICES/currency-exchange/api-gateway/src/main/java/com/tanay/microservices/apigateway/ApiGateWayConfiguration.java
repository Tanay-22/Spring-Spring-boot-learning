package com.tanay.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

public class ApiGateWayConfiguration
{
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
    {
//        Function<PredicateSpec, Buildable<Route>> routeFunction =
//                p -> p.path("/get")
//                        .uri("http://httpbin.org:80");

        return builder.routes()
                .route(p -> p.path("/currency-exchange-service/**")
                        .uri("lb://currency-exchange-service"))
                .build();
    }
}
