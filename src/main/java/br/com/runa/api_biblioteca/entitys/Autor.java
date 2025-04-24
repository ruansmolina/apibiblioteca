package br.com.runa.api_biblioteca.entitys;

import br.com.runa.api_biblioteca.DTO.DTOCreateAutor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    public Autor(Integer id){
        this.id = id;
    }
    public Autor(DTOCreateAutor data){
        setNome(data.nome());
        setSobrenome(data.sobrenome());
    }

}
