package com.novabite.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    private String transactionId;

    private LocalDate date;

    @Column(name = "sales_month")
    private String month;
    @Column(name = "sales_quarter")
    private String quarter;

    private String sku;
    private String productName;

    private String category;
    private String subcategory;

    private String region;
    private String channel;
    private String salesRep;

    private Integer unitsSold;

    private Double unitPriceUsd;

    private Double grossRevenueUsd;

    private Double discountPct;

    private Double netRevenueUsd;

    private Double cogsUsd;

    private Double grossProfitUsd;
}