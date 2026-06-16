package com.novabite.backend.service;

import com.novabite.backend.domain.dto.response.ProductResponse;
import com.novabite.backend.domain.dto.response.SummaryResponse;
import com.novabite.backend.domain.dto.response.TrendResponse;

import java.util.List;

public interface SaleService {
    SummaryResponse getSummary();

    List<ProductResponse> getProducts();

    List<TrendResponse> getMonthlyTrends();
}
