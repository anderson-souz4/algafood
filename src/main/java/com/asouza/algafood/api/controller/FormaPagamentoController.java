package com.asouza.algafood.api.controller;

import com.asouza.algafood.domain.model.Cozinha;
import com.asouza.algafood.domain.model.FormaPagamento;
import com.asouza.algafood.domain.services.FormaPagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formas-pagamento")
public class FormaPagamentoController {
    private final FormaPagamentoService formaPagamentoService;

    public FormaPagamentoController(FormaPagamentoService formaPagamentoService) {
        this.formaPagamentoService = formaPagamentoService;
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> cadastrar(@RequestBody FormaPagamento formaPagamento){
        return ResponseEntity.ok(formaPagamentoService.cadastrar(formaPagamento));
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> listarTodos(){
        return ResponseEntity.ok(formaPagamentoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(formaPagamentoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento){
        return ResponseEntity.ok(formaPagamentoService.atualizarPorId(id, formaPagamento));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
