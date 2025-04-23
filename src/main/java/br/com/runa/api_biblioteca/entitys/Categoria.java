package br.com.runa.api_biblioteca.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
}
