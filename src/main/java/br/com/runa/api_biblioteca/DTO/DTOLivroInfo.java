package br.com.runa.api_biblioteca.DTO;

import br.com.runa.api_biblioteca.entitys.Livro;

public record DTOLivroInfo(
        String titulo,
        String autor,
        Integer anoPublicacao,
        String categoria,
        Integer quantidadeDisponivel
) {
     public DTOLivroInfo(Livro livro){
        this(livro.getTitulo(),
                livro.getAutorFullname(),
                livro.getAnoPublicacao(),
                livro.getCategoria().getNome(),
                livro.getQuantidadeDisponivel());
    }
}
