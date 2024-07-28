package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecord(
        long id,
        @NotBlank(message = "Name cannot be empty.")
        @NotNull(message = "Name cannot be null.")
        String name,
        @Email(message = "Email should be valid.")
        @NotNull(message = "Email cannot be null.")
        String email) {}
