package br.com.runa.api_biblioteca.services;

import br.com.runa.api_biblioteca.DTO.DTOLivroInfo;
import br.com.runa.api_biblioteca.entitys.Livro;
import br.com.runa.api_biblioteca.repositorys.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroService {
    private final LivroRepository lr;
    public LivroService(LivroRepository lr){
        this.lr = lr;
    }

    public List<DTOLivroInfo> getAll() {

        return lr.findAll().stream().map(DTOLivroInfo::new).toList();
    }
}