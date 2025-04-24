package br.com.runa.api_biblioteca.entitys;

import br.com.runa.api_biblioteca.DTO.DTOCreateCategoria;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Categoria(Integer id){
        this.id = id;
    }
    public Categoria(DTOCreateCategoria data) {
        setNome(data.nome());
    }

}
