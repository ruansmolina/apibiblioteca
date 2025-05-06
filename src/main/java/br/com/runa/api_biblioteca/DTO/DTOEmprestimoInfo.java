package br.com.runa.api_biblioteca.DTO;

import br.com.runa.api_biblioteca.entitys.Emprestimo;

import java.time.LocalDate;

public record DTOEmprestimoInfo(
        String livro,
        String usuario,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao
) {
    public DTOEmprestimoInfo(Emprestimo emprestimo){
        this(emprestimo.getLivro().getTitulo(),
                emprestimo.getUsuario().getNome(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao());
    }
}
