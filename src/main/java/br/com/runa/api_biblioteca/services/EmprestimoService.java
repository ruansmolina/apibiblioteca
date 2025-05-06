package br.com.runa.api_biblioteca.services;

import br.com.runa.api_biblioteca.DTO.DTOCreateEmprestimo;
import br.com.runa.api_biblioteca.entitys.Emprestimo;
import br.com.runa.api_biblioteca.entitys.Livro;
import br.com.runa.api_biblioteca.entitys.Usuario;
import br.com.runa.api_biblioteca.repositorys.EmprestimoRepository;
import br.com.runa.api_biblioteca.repositorys.LivroRepository;
import br.com.runa.api_biblioteca.repositorys.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    public EmprestimoService(EmprestimoRepository emprestimoRepository,UsuarioRepository usuarioRepository, LivroRepository livroRepository){
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Emprestimo save(DTOCreateEmprestimo data) {
        Livro livro = livroRepository.findById(data.livro_id())
                        .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        Usuario usuario = usuarioRepository.findById(data.usuario_id()).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        if (livro.getQuantidadeDisponivel() == 0) {
            throw new RuntimeException("Livro Indisponivel");
        }

        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);
        
        Emprestimo result = new Emprestimo(data);
        result.setLivro(livro);
        result.setUsuario(usuario);
        result = emprestimoRepository.saveAndFlush(result);
        return result;
    }

    public Emprestimo getById(Long id){
        var result = emprestimoRepository.findById(id).orElseThrow(()-> new RuntimeException("Emprestimo não encontrado"));
        return result;

    }




}
