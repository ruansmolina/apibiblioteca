package br.com.runa.api_biblioteca.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record DTOCreateUsuario(

        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank @Min(6) @Max(12) String senha) {
}
