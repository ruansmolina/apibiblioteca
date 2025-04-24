package br.com.runa.api_biblioteca.controllers;

import br.com.runa.api_biblioteca.DTO.DTOCreateLivro;
import br.com.runa.api_biblioteca.DTO.DTOLivroInfo;
import br.com.runa.api_biblioteca.DTO.DTOUpdateLivro;
import br.com.runa.api_biblioteca.entitys.Livro;
import br.com.runa.api_biblioteca.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService ls;
    public LivroController(LivroService ls){
        this.ls = ls;
    }

    @GetMapping
    public ResponseEntity<List<DTOLivroInfo>> getAll(){
        return ResponseEntity.ok(ls.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DTOLivroInfo> getById(@PathVariable Long id){
        return ResponseEntity.ok(ls.getById(id));
    }
    @PostMapping
    public ResponseEntity<Long> createLivro(@RequestBody @Valid DTOCreateLivro data){
        var id = ls.saveLivro(data);
        return ResponseEntity.ok(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DTOLivroInfo> updateLivro(@PathVariable Long id, @RequestBody DTOUpdateLivro data){
       return ResponseEntity.ok( ls.updateLivro(data,id));
    }

}
