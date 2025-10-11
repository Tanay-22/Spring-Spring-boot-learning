package com.tanay.stocktradingclient.service;

import com.tanay.stocktrading.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class StockClientService
{
    @GrpcClient("stockService")
    private StockTradingServiceGrpc.StockTradingServiceBlockingStub stockTradingServiceBlockingStub;
    /*
     * Blocking stubs are synchronous (block the currently running thread) and ensure that the rpc call
     * invoked on it doesn't return until it returns a response or raises an exception.
     * Care should be taken not to invoke an rpc on a blocking stub from the UI thread as this will
     * result in an unresponsive/janky UI.
     */

    @GrpcClient("stockService")
    private StockTradingServiceGrpc.StockTradingServiceStub stockTradingServiceStub;
    /*
     * Asynchronous stubs make non-blocking rpc calls where the response is
     * returned asynchronously via a StreamObserver callback object.
     */

    public StockResponse getStockPrice(String stockSymbol)
    {
        StockRequest request = StockRequest.newBuilder()
                .setStockSymbol(stockSymbol)
                .build();

        return stockTradingServiceBlockingStub.getStockPrice(request);
    }

    public void subscribeStockPrice(String stockSymbol)
    {
        StockRequest request = StockRequest.newBuilder()
                .setStockSymbol(stockSymbol)
                .build();

        stockTradingServiceStub.subscribeStockPrice(request, new StreamObserver<StockResponse>()
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

    public void placeBulkOrders()
    {
        StreamObserver<OrderSummary> responseObserver = new StreamObserver<OrderSummary>()
        {
            @Override
            public void onNext(OrderSummary summary)
            {
                System.out.println("Order Summary Received from Server:");
                System.out.println("Total Orders: " + summary.getTotalOrders());
                System.out.println("Successful Orders: " + summary.getSuccessCount());
                System.out.println("Total Amount: $" + summary.getTotalAmount());
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Order Summary Received error from Server:" + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                System.out.println("Stream completed , server is done sending summary !");
            }
        };

        StreamObserver<StockOrder> requestObserver = stockTradingServiceStub.bulkStockOrder(responseObserver);

        // send multiple steam of stock order message/request

        try
        {
            requestObserver.onNext(StockOrder.newBuilder()
                    .setOrderId("1")
                    .setStockSymbol("AAPL")
                    .setOrderType("BUY")
                    .setPrice(150.5)
                    .setQuantity(10)
                    .build());

            requestObserver.onNext(StockOrder.newBuilder()
                    .setOrderId("2")
                    .setStockSymbol("GOOGL")
                    .setOrderType("SELL")
                    .setPrice(2700.0)
                    .setQuantity(5)
                    .build());

            requestObserver.onNext(StockOrder.newBuilder()
                    .setOrderId("3")
                    .setStockSymbol("TSLA")
                    .setOrderType("BUY")
                    .setPrice(700.0)
                    .setQuantity(8)
                    .build());

            //done sending orders
            requestObserver.onCompleted();
        }
        catch (Exception ex)
        {
            requestObserver.onError(ex);
        }

    }
}
