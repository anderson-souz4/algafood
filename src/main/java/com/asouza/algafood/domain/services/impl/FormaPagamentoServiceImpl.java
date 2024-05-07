package com.asouza.algafood.domain.services.impl;

import com.asouza.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.asouza.algafood.domain.model.Cozinha;
import com.asouza.algafood.domain.model.FormaPagamento;
import com.asouza.algafood.domain.repositories.CozinhaRepository;
import com.asouza.algafood.domain.repositories.FormaPagamentoRepository;
import com.asouza.algafood.domain.services.CozinhaService;
import com.asouza.algafood.domain.services.FormaPagamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoServiceImpl implements FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;


    public FormaPagamentoServiceImpl(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    @Override
    public FormaPagamento cadastrar(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    @Override
    public FormaPagamento buscarPorId(Long id) {
        return formaPagamentoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entidade não encontrada pelo id: "+ id));
    }

    @Override
    public List<FormaPagamento> buscarTodos() {
        return formaPagamentoRepository.findAll();
    }

    @Override
    public FormaPagamento atualizarPorId(Long id, FormaPagamento formaPagamento) {
        FormaPagamento porId = buscarPorId(id);
        return formaPagamentoRepository.save(porId);
    }

    @Override
    public void deletarPorId(Long id) {
        formaPagamentoRepository.deleteById(id);

    }
}
