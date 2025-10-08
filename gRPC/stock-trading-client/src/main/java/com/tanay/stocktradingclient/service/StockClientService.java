package com.tanay.stocktradingclient.service;

import com.tanay.stocktrading.StockRequest;
import com.tanay.stocktrading.StockResponse;
import com.tanay.stocktrading.StockTradingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class StockClientService
{
    @GrpcClient("stockService")
    private StockTradingServiceGrpc.StockTradingServiceBlockingStub serviceBlockingStub;
    /*
     * Blocking stubs are synchronous (block the currently running thread) and ensure that the rpc call
     * invoked on it doesn't return until it returns a response or raises an exception.
     * Care should be taken not to invoke an rpc on a blocking stub from the UI thread as this will
     * result in an unresponsive/janky UI.
     */

    @GrpcClient("stockService")
    private StockTradingServiceGrpc.StockTradingServiceStub serviceStub;
    /*
     * Asynchronous stubs make non-blocking rpc calls where the response is
     * returned asynchronously via a StreamObserver callback object.
    */

    public StockResponse getStockPrice(String stockSymbol)
    {
        StockRequest request = StockRequest.newBuilder()
                .setStockSymbol(stockSymbol)
                .build();

        return serviceBlockingStub.getStockPrice(request);
    }

    public void subscribeStockPrice(String stockSymbol)
    {
        StockRequest request = StockRequest.newBuilder()
                .setStockSymbol(stockSymbol)
                .build();

        serviceStub.subscribeStockPrice(request, new StreamObserver<StockResponse>()
        {

            @Override
            public void onNext(StockResponse stockResponse)
            {
                System.out.println(stockResponse.toString());
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                System.out.printf("Successfully Subscribed Stock Price Successfully");
            }
        });
    }
}
