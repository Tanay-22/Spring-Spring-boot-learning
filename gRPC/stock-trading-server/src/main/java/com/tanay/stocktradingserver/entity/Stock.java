package com.tanay.stocktradingserver.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
@Data
public class Stock
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_symbol", unique = true, nullable = false)
    private String stockSymbol;

    private Double price;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
}
