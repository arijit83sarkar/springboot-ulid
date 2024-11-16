package com.raven.springboot_ulid.core.model.dto;

import java.math.BigDecimal;

public record OrderDetailsInput(
        String itemId,
        Integer quantity,
        BigDecimal unitPrice
) {
}
