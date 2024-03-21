package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto implements Serializable {


    private long id;

    @NotEmpty(message = "Name cannot be empty.")
    @NotNull(message = "Item name is mandatory.")
    private String name;
}
