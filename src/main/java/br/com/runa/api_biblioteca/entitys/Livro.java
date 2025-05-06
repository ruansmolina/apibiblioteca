package br.com.runa.api_biblioteca.entitys;

import br.com.runa.api_biblioteca.DTO.DTOCreateLivro;
import br.com.runa.api_biblioteca.DTO.DTOUpdateLivro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
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

    @OneToMany(mappedBy = "livro")
    @JsonIgnore
    private Set<Emprestimo> emprestimos;

    public Livro(DTOCreateLivro data) {
        setAutor(new Autor(data.autorId()));
        setCategoria(new Categoria(data.categoriaId()));
        setTitulo(data.titulo());
        setIsbn(data.isbn());
        if(data.anoPublicacao()!=null) setAnoPublicacao(data.anoPublicacao());
        setQuantidadeTotal(data.quantidadeTotal());
        setQuantidadeDisponivel(data.quantidadeTotal());
    }

    public Livro( Long id) {
        this.setId(id);
    }

    public String getAutorFullname(){
        return this.autor.getNome() +' '+this.autor.getSobrenome();
    }

    public void update(DTOUpdateLivro data) {
        if(data.autorId()!= null) setAutor(new Autor(data.autorId()));
        if(data.categoriaId() != null) setCategoria(new Categoria(data.categoriaId()));
        if(data.titulo() != null && !data.titulo().trim().isEmpty()) setTitulo(data.titulo());
        if(data.isbn() != null && data.isbn().trim().isEmpty()) setIsbn(data.isbn());
        if(data.anoPublicacao()!=null) setAnoPublicacao(data.anoPublicacao());
        if(data.quantidadeTotal()!=null) setQuantidadeTotal(data.quantidadeTotal());
        if(data.quantidadeDisponivel()!=null) setQuantidadeDisponivel(data.quantidadeDisponivel());
    }
}
