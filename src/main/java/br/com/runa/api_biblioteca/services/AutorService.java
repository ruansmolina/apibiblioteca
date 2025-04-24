package br.com.runa.api_biblioteca.services;

import br.com.runa.api_biblioteca.DTO.DTOCreateAutor;
import br.com.runa.api_biblioteca.entitys.Autor;
import br.com.runa.api_biblioteca.repositorys.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorService {
    private final AutorRepository ar;
    public AutorService(AutorRepository ar){
        this.ar = ar;
    }
    public Integer save(DTOCreateAutor data){

        Autor result = ar.save(new Autor(data));
       return result.getId();
    }
    public List<Autor> getAll(){
        return ar.findAll();
    }

}
