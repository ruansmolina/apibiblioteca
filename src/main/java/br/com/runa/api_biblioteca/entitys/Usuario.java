package br.com.runa.api_biblioteca.entitys;

import br.com.runa.api_biblioteca.DTO.DTOCreateUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Emprestimo> emprestimos;

    public Usuario(DTOCreateUsuario data) {
        setNome(data.nome());
        setEmail(data.email());
        setSenha(data.senha());
        setTipo("leitor");
    }

    public Usuario( Long id) {
        this.setId(id);
    }
}
