package com.sibs.orderdemo.application.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class UserDto implements Serializable {

    private long id;

    @NotEmpty(message = "Name cannot be empty.")
    @NotNull(message = "Name cannot be null.")
    private String name;

    @Email(message = "Email should be valid.")
    @NotNull(message = "Email cannot be null.")
    private String email;
}
