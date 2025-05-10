package com.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotNull
    private Long Id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String username;
}
