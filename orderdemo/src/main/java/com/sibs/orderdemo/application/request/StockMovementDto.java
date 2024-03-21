package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class StockMovementDto implements Serializable {

    @Min(value = 1, message = "Quantity should not be less than 1")
    private int quantity;
    @NotNull(message = "Item id is mandatory.")
    private long itemId;
}
