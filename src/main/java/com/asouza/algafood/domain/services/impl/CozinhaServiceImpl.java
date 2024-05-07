package com.asouza.algafood.domain.services.impl;

import com.asouza.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.asouza.algafood.domain.model.Cozinha;
import com.asouza.algafood.domain.repositories.CozinhaRepository;
import com.asouza.algafood.domain.services.CozinhaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaServiceImpl implements CozinhaService {

    private final CozinhaRepository cozinhaRepository;


    public CozinhaServiceImpl(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }


    @Override
    public Cozinha cadastrar(Cozinha restaurante) {
        return cozinhaRepository.save(restaurante);
    }

    @Override
    public Cozinha buscarPorId(Long id) {
        return cozinhaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entidade não encontrada pelo id: "+ id));
    }

    @Override
    public List<Cozinha> buscarTodos() {
        return cozinhaRepository.findAll();
    }

    @Override
    public Cozinha atualizarPorId(Long id, Cozinha restaurante) {
        Cozinha porId = buscarPorId(id);
        return cozinhaRepository.save(porId);
    }

    @Override
    public void deletarPorId(Long id) {
        cozinhaRepository.deleteById(id);

    }

    @Override
    public List<Cozinha> buscarPorNome(String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }
}
