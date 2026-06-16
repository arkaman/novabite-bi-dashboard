package com.novabite.backend.repository;

import com.novabite.backend.domain.dto.response.ProductResponse;
import com.novabite.backend.domain.dto.response.TrendResponse;
import com.novabite.backend.domain.entity.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, String> {

    @Query("""
        SELECT SUM(s.netRevenueUsd)
        FROM Sale s
    """)
    BigDecimal getTotalNetRevenue();

    @Query("""
        SELECT SUM(s.grossProfitUsd)
        FROM Sale s
    """)
    BigDecimal getTotalGrossProfit();

    @Query("""
        SELECT SUM(s.unitsSold)
        FROM Sale s
    """)
    Long getTotalUnitsSold();

    @Query("""
        SELECT s.region
        FROM Sale s
        GROUP BY s.region
        ORDER BY SUM(s.netRevenueUsd) DESC
    """)
    List<String> findTopRegions(Pageable pageable);

    @Query("""
        SELECT s.channel
        FROM Sale s
        GROUP BY s.channel
        ORDER BY SUM(s.netRevenueUsd) DESC
    """)
    List<String> findTopChannels(Pageable pageable);

    @Query("""
        SELECT s.productName
        FROM Sale s
        GROUP BY s.productName
        ORDER BY SUM(s.netRevenueUsd) DESC
    """)
    List<String> findTopProducts(Pageable pageable);

    @Query("""
        SELECT new com.novabite.backend.domain.dto.response.ProductResponse(
            s.productName,
            SUM(s.netRevenueUsd),
            SUM(s.unitsSold)
        )
        FROM Sale s
        GROUP BY s.productName
        ORDER BY SUM(s.netRevenueUsd) DESC
    """)
    List<ProductResponse> getProducts();

    @Query("""
        SELECT new com.novabite.backend.domain.dto.response.TrendResponse(
            s.month,
            SUM(s.netRevenueUsd)
        )
        FROM Sale s
        GROUP BY s.month
        ORDER BY s.month
    """)
    List<TrendResponse> getMonthlyTrends();
}