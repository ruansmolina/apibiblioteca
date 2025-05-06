package br.com.runa.api_biblioteca.controllers;

import br.com.runa.api_biblioteca.DTO.DTOCreateEmprestimo;
import br.com.runa.api_biblioteca.DTO.DTOEmprestimoInfo;
import br.com.runa.api_biblioteca.entitys.Emprestimo;
import br.com.runa.api_biblioteca.services.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;
    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public ResponseEntity<DTOEmprestimoInfo> createEmprestimo(@RequestBody DTOCreateEmprestimo data){
        var saved = emprestimoService.save(data);
        var result = emprestimoService.getById(saved.getId());
        return ResponseEntity.ok(new DTOEmprestimoInfo(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEmprestimoInfo> getEmprestimo(@PathVariable Long id){

        var result = emprestimoService.getById(id);
        return ResponseEntity.ok(new DTOEmprestimoInfo(result));
    }
}
// CRIAR O DTO DE EMPRESTIMO