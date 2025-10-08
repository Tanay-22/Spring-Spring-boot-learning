package com.tanay.stocktradingserver.service;

import com.tanay.stocktrading.StockRequest;
import com.tanay.stocktrading.StockResponse;
import com.tanay.stocktrading.StockTradingServiceGrpc;
import com.tanay.stocktradingserver.entity.Stock;
import com.tanay.stocktradingserver.repository.StockRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;


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
}
