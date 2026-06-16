package com.novabite.backend.domain.dto.response;

import java.math.BigDecimal;

public record ProductResponse(
        String productName,
        BigDecimal totalNetRevenue,
        Long totalUnitsSold
) {
}
