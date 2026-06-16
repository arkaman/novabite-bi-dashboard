package com.novabite.backend.controller;

import com.novabite.backend.domain.dto.response.ProductResponse;
import com.novabite.backend.domain.dto.response.SummaryResponse;
import com.novabite.backend.domain.dto.response.TrendResponse;
import com.novabite.backend.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SalesController {
    private final SaleService saleService;

    @GetMapping("/summary")
    public SummaryResponse getSummary() {
        return saleService.getSummary();
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return saleService.getProducts();
    }

    @GetMapping("/trends")
    public List<TrendResponse> getMonthlyTrends() {
        return saleService.getMonthlyTrends();
    }
}
