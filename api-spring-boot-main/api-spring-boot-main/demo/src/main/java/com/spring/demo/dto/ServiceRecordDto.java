package com.spring.demo.dto;

import jakarta.validation.constraints.*;

public record ServiceRecordDto (

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    String nome,

    @NotBlank(message = "O descricao é obrigatório")
    @Email(message = "descricao inválido")
    String email,

    @NotBlank(message = "A funcionario é obrigatória")
    @Size(min = 6, max = 20, message = "A funcionario deve ter entre 6 e 20 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "O funcionario deve conter ao menos uma letra maiúscula, uma minúscula e um número"
    )
    String funcionario,

    @Pattern(regexp = "^\\d{11}$", message = "data deve conter exatamente 11 dígitos")
    String cpf,

    @Min(value = 18, message = "data mínima é 18 anos")
    @Max(value = 65, message = "data máxima é 65 anos")
    int data,

    @NotNull(message = "O campo valor é obrigatório")
    Boolean valor

){}
