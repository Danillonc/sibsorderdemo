package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record StockMovementRecord(
        @Min(value = 1, message = "Quantity should not be less than 1")
        int quantity,
        @NotNull(message = "Item id is mandatory.")
        long itemId) {}
