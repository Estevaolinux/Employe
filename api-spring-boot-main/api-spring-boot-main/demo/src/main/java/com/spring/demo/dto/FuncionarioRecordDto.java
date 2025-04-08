package com.spring.demo.dto;

import jakarta.validation.constraints.*;

public record FuncionarioRecordDto(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100)
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String senha,

        @NotNull(message = "Status de ativo é obrigatório")
        Boolean ativo
) {}

