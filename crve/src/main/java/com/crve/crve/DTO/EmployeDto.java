package com.crve.crve.DTO;

import jakarta.validation.constraints.NotBlank;


public record EmployeDto() {

    public record employedto(@NotBlank String id, @NotBlank String Nome, @NotBlank String email, NotBlank String password) {

    }
}
