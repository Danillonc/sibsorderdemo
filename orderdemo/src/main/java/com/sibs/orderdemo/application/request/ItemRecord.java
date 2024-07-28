package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ItemRecord(
        long id,
        @NotEmpty(message = "Name cannot be empty.")
        @NotNull(message = "Item name is mandatory.")
        String name) {}
