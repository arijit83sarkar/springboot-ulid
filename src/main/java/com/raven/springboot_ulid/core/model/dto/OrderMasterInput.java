package com.raven.springboot_ulid.core.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record OrderMasterInput(
        LocalDate orderDate,
        String customerId,
        Optional<List<OrderDetailsInput>> detailsInputs
) {
}
