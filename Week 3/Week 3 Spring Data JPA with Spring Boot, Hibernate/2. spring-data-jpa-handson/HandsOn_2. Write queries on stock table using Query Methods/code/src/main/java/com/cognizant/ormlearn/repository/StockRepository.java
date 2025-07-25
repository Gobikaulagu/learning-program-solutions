package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.ormlearn.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Facebook stocks in Sep 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // 2. Google stocks where price > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // 3. Top 3 volumes
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Netflix lowest 3 close prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
