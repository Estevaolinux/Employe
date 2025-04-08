package com.spring.demo.dto;

import jakarta.validation.constraints.*;

public record ClientRecordDto(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
                message = "A senha deve conter ao menos uma letra maiúscula, uma minúscula e um número"
        )
        String senha,

        @Pattern(regexp = "^\\d{11}$", message = "CPF deve conter exatamente 11 dígitos")
        String cpf,

        @Min(value = 18, message = "Idade mínima é 18 anos")
        @Max(value = 65, message = "Idade máxima é 65 anos")
        int idade,

        @NotNull(message = "O campo ativo é obrigatório")
        Boolean ativo

) {}
