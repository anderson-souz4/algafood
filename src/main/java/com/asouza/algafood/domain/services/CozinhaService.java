package com.asouza.algafood.domain.services;

import com.asouza.algafood.domain.model.Cozinha;

import java.util.List;


public interface CozinhaService {
    Cozinha cadastrar(Cozinha restaurante);
    Cozinha buscarPorId(Long id);
    List<Cozinha> buscarTodos();
    Cozinha atualizarPorId(Long id, Cozinha restaurante);
    void deletarPorId(Long id);
    List<Cozinha> buscarPorNome(String nome);
}
