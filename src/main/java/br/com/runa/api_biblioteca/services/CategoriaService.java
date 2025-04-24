package br.com.runa.api_biblioteca.services;

import br.com.runa.api_biblioteca.DTO.DTOCreateCategoria;
import br.com.runa.api_biblioteca.entitys.Categoria;
import br.com.runa.api_biblioteca.repositorys.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaService {
    private CategoriaRepository cr;
    public CategoriaService(CategoriaRepository cr){
        this.cr = cr;
    }

    public Categoria save(DTOCreateCategoria data) {
        return cr.save(new Categoria(data));
    }
    public List<Categoria> getAll(){
        return cr.findAll();
    }
}
