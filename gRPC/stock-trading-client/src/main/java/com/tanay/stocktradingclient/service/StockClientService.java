package com.tanay.stocktradingclient.service;

import com.tanay.stocktrading.StockRequest;
import com.tanay.stocktrading.StockResponse;
import com.tanay.stocktrading.StockTradingServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class StockClientService
{
    @GrpcClient("stockService")
    private StockTradingServiceGrpc.StockTradingServiceBlockingStub serviceBlockingStub;

    public StockResponse getStockPrice(String stockSymbol)
    {
        StockRequest request = StockRequest.newBuilder()
                .setStockSymbol(stockSymbol)
                .build();

        return serviceBlockingStub.getStockPrice(request);
    }
}
