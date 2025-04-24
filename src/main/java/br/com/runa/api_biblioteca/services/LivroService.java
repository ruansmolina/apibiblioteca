package br.com.runa.api_biblioteca.services;

import br.com.runa.api_biblioteca.DTO.DTOCreateLivro;
import br.com.runa.api_biblioteca.DTO.DTOLivroInfo;
import br.com.runa.api_biblioteca.DTO.DTOUpdateLivro;
import br.com.runa.api_biblioteca.entitys.Livro;
import br.com.runa.api_biblioteca.repositorys.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public DTOLivroInfo getById(Long id){
        return new DTOLivroInfo(lr.findById(id).orElseThrow(()-> new RuntimeException("Livro não Encontrando")));
    }
    public Long saveLivro(DTOCreateLivro data){
        var result = lr.save(new Livro(data));
        return result.getId();
    }
    @Transactional
    public DTOLivroInfo updateLivro(DTOUpdateLivro data, Long id){
        Livro result = lr.findById(id).orElseThrow(()-> new RuntimeException("livro não encontrado"));
        result.update(data);
        return new DTOLivroInfo(result);
    }

    public void deleteById(Long id) {
        if(lr.existsById(id)) throw new RuntimeException("Livro não encontrado");
        lr.deleteById(id);
    }
}