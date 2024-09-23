package com.tanay.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//  name and url of the service to be called
//@FeignClient(name="currency-exchange-service", url ="localhost:8000")

// for multiple instances running on different ports
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy
{
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
