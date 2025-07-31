package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 1. Facebook in Sep 2019
        System.out.println("Facebook stock in Sep 2019");
        List<Stock> fbList = stockRepository.findByCodeAndDateBetween("FB", sdf.parse("2019-09-01"), sdf.parse("2019-09-30"));
        fbList.forEach(System.out::println);

        // 2. Google stock > 1250
        System.out.println("\nGoogle stock > 1250");
        List<Stock> googleList = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        googleList.forEach(System.out::println);

        // 3. Top 3 volume
        System.out.println("\nTop 3 by volume");
        stockRepository.findTop3ByOrderByVolumeDesc().forEach(System.out::println);

        // 4. Netflix lowest close
        System.out.println("\nNetflix lowest 3");
        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX").forEach(System.out::println);
    }
}
