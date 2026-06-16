package com.novabite.backend.domain.dto.response;

import java.math.BigDecimal;

public record TrendResponse(
        String month,
        BigDecimal netRevenue
) {
}
