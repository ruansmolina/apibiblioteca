package br.com.runa.api_biblioteca.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
}
