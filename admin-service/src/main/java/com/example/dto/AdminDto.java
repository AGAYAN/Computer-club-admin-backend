package com.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {

    @NotNull
    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String password;
}
