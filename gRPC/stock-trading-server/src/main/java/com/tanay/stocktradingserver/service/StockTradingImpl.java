package com.tanay.stocktradingserver.service;

import com.tanay.stocktrading.*;
import com.tanay.stocktradingserver.entity.Stock;
import com.tanay.stocktradingserver.repository.StockRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@GrpcService
@RequiredArgsConstructor
public class StockTradingImpl extends StockTradingServiceGrpc.StockTradingServiceImplBase
{
    private final StockRepository stockRepository;

    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver)
    {
        // stockName -> DB -> map response -> return

        String stockSymbol = request.getStockSymbol();
        Stock stockEntity = stockRepository.findByStockSymbol(stockSymbol)
                .orElseThrow(RuntimeException::new);

        StockResponse stockResponse = StockResponse.newBuilder()
                .setStockSymbol(stockEntity.getStockSymbol())
                .setPrice(stockEntity.getPrice())
                .setTimestamp(stockEntity.getLastUpdated().toString())
                .build();

        responseObserver.onNext(stockResponse);
        responseObserver.onCompleted();

    }

    @Override
    public void subscribeStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver)
    {
        String stockSymbol = request.getStockSymbol();
        try
        {
            for (int i = 0; i < 10; i++)
            {
                StockResponse stockResponse = StockResponse.newBuilder()
                        .setStockSymbol(stockSymbol)
                        .setPrice(new Random().nextDouble(200))
                        .setTimestamp(Instant.now().toString())
                        .build();

                responseObserver.onNext(stockResponse);
                TimeUnit.SECONDS.sleep(1); // same as Thread.sleep(1000)
            }
        }
        catch(InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StockOrder> bulkStockOrder(StreamObserver<OrderSummary> responseObserver)
    {
        return new StreamObserver<>()
        {
            private int totalOrders = 0;
            private double totalAmount = 0;
            private int successCount = 0;

            @Override
            public void onNext(StockOrder stockOrder)
            {
                totalOrders++;
                totalAmount += stockOrder.getPrice() * stockOrder.getQuantity();
                successCount++;
                System.out.println("Received Order : " + stockOrder);
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.println("Server unable to process the request : " + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                OrderSummary summary = OrderSummary.newBuilder()
                        .setTotalOrders(totalOrders)
                        .setTotalAmount(totalAmount)
                        .setSuccessCount(successCount)
                        .build();

                responseObserver.onNext(summary);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StockOrder> liveTrading(StreamObserver<TradeStatus> responseObserver)
    {
        return new StreamObserver<>()
        {
            @Override
            public void onNext(StockOrder stockOrder)
            {
                System.out.println("Received Order : " + stockOrder);

                String status = "EXECUTED";
                String message = "Order placed successfully";

                if (stockOrder.getQuantity() <= 0)
                {
                    status = "FAILED";
                    message = "Invalid Quantity";
                }
                TradeStatus tradeStatus = TradeStatus.newBuilder()
                        .setOrderId(stockOrder.getOrderId())
                        .setStatus(status)
                        .setMessage(message)
                        .setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE))
                        .build();

                responseObserver.onNext(tradeStatus);
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.err.println("ERROR : " + throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                responseObserver.onCompleted();
            }
        };
    }
}
