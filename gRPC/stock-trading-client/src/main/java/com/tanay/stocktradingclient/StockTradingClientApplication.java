package com.tanay.stocktradingclient;

import com.tanay.stocktradingclient.service.StockClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StockTradingClientApplication implements CommandLineRunner
{
    private final StockClientService stockClientService;

    public static void main(String[] args)
    {
        SpringApplication.run(StockTradingClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
//        System.out.println("Grpc client response : "+ stockClientService.getStockPrice("AMZN"));

//        stockClientService.subscribeStockPrice("AMZN");

//        stockClientService.placeBulkOrders();
        stockClientService.startLiveTrading();
    }
}
