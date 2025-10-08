package com.tanay.stocktradingserver.repository;

import com.tanay.stocktradingserver.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long>
{
    Optional<Stock> findByStockSymbol(String stockSymbol);
}
