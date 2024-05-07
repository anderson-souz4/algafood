package com.asouza.algafood.domain.services;

import com.asouza.algafood.domain.model.FormaPagamento;
import com.asouza.algafood.domain.model.Restaurante;

import java.util.List;

public interface FormaPagamentoService {
    FormaPagamento cadastrar(FormaPagamento formaPagamento);
    FormaPagamento buscarPorId(Long id);
    List<FormaPagamento> buscarTodos();
    FormaPagamento atualizarPorId(Long id, FormaPagamento formaPagamento);
    void deletarPorId(Long id);
}
