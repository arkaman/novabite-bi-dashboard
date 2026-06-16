package com.novabite.backend.domain.dto.response;

import java.math.BigDecimal;

public record SummaryResponse(
        BigDecimal totalNetRevenue,
        Long totalUnitsSold,
        BigDecimal grossProfitMargin,
        String topRegion,
        String topChannel,
        String topProduct
) {
}
