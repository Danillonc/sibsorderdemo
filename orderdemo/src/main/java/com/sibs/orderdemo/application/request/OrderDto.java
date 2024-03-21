package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class OrderDto implements Serializable {

    @NotNull(message = "User information is mandatory.")
    private UserDto user;
    @Min(value = 1, message = "Quantity not be less than 1.")
    @NotNull(message = "Quantity is mandatory")
    private int quantity;
    @NotNull(message = "Item informarion is mandatory.")
    private ItemDto item;
}
