package com.novabite.backend.service;

import com.novabite.backend.domain.dto.response.ProductResponse;
import com.novabite.backend.domain.dto.response.SummaryResponse;
import com.novabite.backend.domain.dto.response.TrendResponse;
import com.novabite.backend.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SaleService{

    private final SaleRepository saleRepository;

    @Override
    public SummaryResponse getSummary() {

        BigDecimal totalRevenue = saleRepository.getTotalNetRevenue();
        BigDecimal totalGrossProfit = saleRepository.getTotalGrossProfit();
        Long totalUnits = saleRepository.getTotalUnitsSold();

        if (totalRevenue == null) {
            totalRevenue = BigDecimal.ZERO;
        }

        if (totalGrossProfit == null) {
            totalGrossProfit = BigDecimal.ZERO;
        }

        if (totalUnits == null) {
            totalUnits = 0L;
        }

        BigDecimal margin = BigDecimal.ZERO;

        if (totalRevenue.compareTo(BigDecimal.ZERO) > 0) {
            margin = totalGrossProfit
                    .multiply(BigDecimal.valueOf(100))
                    .divide(totalRevenue, 2, RoundingMode.HALF_UP);
        }

        PageRequest first = PageRequest.of(0, 1);

        String topRegion = saleRepository.findTopRegions(first)
                .stream()
                .findFirst()
                .orElse(null);

        String topChannel = saleRepository.findTopChannels(first)
                .stream()
                .findFirst()
                .orElse(null);

        String topProduct = saleRepository.findTopProducts(first)
                .stream()
                .findFirst()
                .orElse(null);

        return new SummaryResponse(
                totalRevenue,
                totalUnits,
                margin,
                topRegion,
                topChannel,
                topProduct
        );
    }

    @Override
    public List<ProductResponse> getProducts() {
        return saleRepository.getProducts();
    }

    @Override
    public List<TrendResponse> getMonthlyTrends() {
        return saleRepository.getMonthlyTrends();
    }
}
