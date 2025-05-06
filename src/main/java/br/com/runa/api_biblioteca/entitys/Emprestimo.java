package br.com.runa.api_biblioteca.entitys;

import br.com.runa.api_biblioteca.DTO.DTOCreateEmprestimo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table
@NoArgsConstructor
@Data

public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    @JsonIgnore
    private Livro livro;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    private String status;

    public Emprestimo(DTOCreateEmprestimo data){
        this.setLivro(new Livro(data.livro_id()));
        this.setUsuario(new Usuario(data.usuario_id()));
        this.setDataEmprestimo(LocalDate.now());
        this.setDataDevolucao(LocalDate.now().plusDays(14));
        this.setStatus("Emprestado");
    }


}
