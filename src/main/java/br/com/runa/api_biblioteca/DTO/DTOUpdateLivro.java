package br.com.runa.api_biblioteca.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOUpdateLivro(
        String titulo,
        Integer autorId,
        Integer anoPublicacao,
        Integer categoriaId,
        Integer quantidadeTotal,
        Integer quantidadeDisponivel,
        String isbn) {
}

