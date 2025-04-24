package br.com.runa.api_biblioteca.controllers;

import br.com.runa.api_biblioteca.DTO.DTOCreateAutor;
import br.com.runa.api_biblioteca.entitys.Autor;
import br.com.runa.api_biblioteca.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/autor")
public class AutorController {
    private final AutorService as;
    public AutorController(AutorService as){
        this.as = as;
    }


    @GetMapping
    public ResponseEntity<List<Autor>> getAll(){
        return ResponseEntity.ok(as.getAll());
    }
    @PostMapping// APENAS ADM
    public ResponseEntity<Integer> createAutor(@RequestBody @Valid DTOCreateAutor data){
        var id = as.save(data);
        return ResponseEntity.ok(id);
    }
}
