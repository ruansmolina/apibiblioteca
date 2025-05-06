package br.com.runa.api_biblioteca.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOCreateEmprestimo(
        @NotNull Long livro_id,
        @NotNull Long usuario_id) {
}
