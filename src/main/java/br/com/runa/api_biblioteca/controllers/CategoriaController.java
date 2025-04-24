package br.com.runa.api_biblioteca.controllers;

import br.com.runa.api_biblioteca.DTO.DTOCreateCategoria;
import br.com.runa.api_biblioteca.entitys.Categoria;
import br.com.runa.api_biblioteca.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private CategoriaService cs;

    public CategoriaController(CategoriaService cs){
        this.cs = cs;
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        return ResponseEntity.ok(cs.getAll());
    }
    @PostMapping// APENAS ADM
    public ResponseEntity<Categoria> createCategoria(@RequestBody @Valid DTOCreateCategoria data){
        var id = cs.save(data);
        return ResponseEntity.ok(id);
    }
}
