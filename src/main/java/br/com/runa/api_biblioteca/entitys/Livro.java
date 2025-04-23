package br.com.runa.api_biblioteca.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    private int anoPublicacao;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

    private int quantidadeTotal;
    private int quantidadeDisponivel;

    public String getAutorFullname(){
        return this.autor.getNome() +' '+this.autor.getSobrenome();
    }

}
