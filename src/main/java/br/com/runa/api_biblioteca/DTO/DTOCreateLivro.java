package br.com.runa.api_biblioteca.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOCreateLivro(

        @NotBlank
        String titulo,
        @NotNull
        Integer autorId,
        Integer anoPublicacao,
        @NotNull
        Integer categoriaId,
        @NotNull
        Integer quantidadeTotal,
        @NotBlank
        String isbn) {
}
