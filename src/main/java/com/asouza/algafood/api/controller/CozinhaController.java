package com.asouza.algafood.api.controller;

import com.asouza.algafood.domain.model.Cozinha;
import com.asouza.algafood.domain.model.Restaurante;
import com.asouza.algafood.domain.services.CozinhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cozinha")
public class CozinhaController {
    private final CozinhaService cozinhaService;

    public CozinhaController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @PostMapping
    public ResponseEntity<Cozinha> cadastrar(@RequestBody Cozinha cozinha){
        return ResponseEntity.ok(cozinhaService.cadastrar(cozinha));
    }

    @GetMapping
    public ResponseEntity<List<Cozinha>> listarTodos(){
        return ResponseEntity.ok(cozinhaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(cozinhaService.buscarPorId(id));
    }

    @GetMapping("buscarPorNome")
    public ResponseEntity<List<Cozinha>> buscarPorNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(cozinhaService.buscarPorNome(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha){
        return ResponseEntity.ok(cozinhaService.atualizarPorId(id, cozinha));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
