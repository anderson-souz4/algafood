package com.asouza.algafood.domain.services;

import com.asouza.algafood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteService {
    Restaurante cadastrar(Restaurante restaurante);
    Restaurante buscarPorId(Long id);
    List<Restaurante> buscarTodos();
    Restaurante atualizarPorId(Long id, Restaurante restaurante);
    void deletarPorId(Long id);

    List<Restaurante> buscarPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal);
}
