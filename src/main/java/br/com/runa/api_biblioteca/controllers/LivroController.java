package br.com.runa.api_biblioteca.controllers;

import br.com.runa.api_biblioteca.DTO.DTOLivroInfo;
import br.com.runa.api_biblioteca.entitys.Livro;
import br.com.runa.api_biblioteca.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
