package br.com.runa.api_biblioteca.services;

import br.com.runa.api_biblioteca.DTO.DTOCreateUsuario;
import br.com.runa.api_biblioteca.entitys.Usuario;
import br.com.runa.api_biblioteca.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario save(DTOCreateUsuario data){
        return usuarioRepository.save(new Usuario(data));
    }

}
