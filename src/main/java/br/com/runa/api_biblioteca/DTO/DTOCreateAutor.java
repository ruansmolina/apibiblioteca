package br.com.runa.api_biblioteca.DTO;

import jakarta.validation.constraints.NotBlank;

public record DTOCreateAutor(
        @NotBlank String nome, String sobrenome) {
}
