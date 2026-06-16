package com.novabite.backend.domain.dto.response;

import java.math.BigDecimal;

public record SummaryResponse(
        BigDecimal totalNetRevenue,
        Long totalNetRevenue,
        BigDecimal grossProfitMargin,
        String topRegion,
        String topChannel,
        String topProduct
) {
}
