package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderRecord(
        @NotNull(message = "User information is mandatory.")
        UserRecord user,
        @Min(value = 1, message = "Quantity not be less than 1.")
        @NotNull(message = "Quantity is mandatory")
        int quantity,
        @NotNull(message = "Item informarion is mandatory.")
        ItemRecord item
) {}
