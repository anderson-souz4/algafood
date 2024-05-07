package com.asouza.algafood.api.controller;

import com.asouza.algafood.domain.model.Restaurante;
import com.asouza.algafood.domain.services.RestauranteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping
    public ResponseEntity<Restaurante> cadastrar(@RequestBody Restaurante restaurante){
        return ResponseEntity.ok(restauranteService.cadastrar(restaurante));
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> listarTodos(){
        return ResponseEntity.ok(restauranteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(restauranteService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante){
        return ResponseEntity.ok(restauranteService.atualizarPorId(id, restaurante));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar-restaurantes-por-taxa-frete")
    public ResponseEntity<List<Restaurante>> buscarPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
        return ResponseEntity.ok(restauranteService.buscarPorTaxaFrete(taxaInicial, taxaFinal));
    }
}
