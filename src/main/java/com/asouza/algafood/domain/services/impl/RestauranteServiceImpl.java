package com.asouza.algafood.domain.services.impl;

import com.asouza.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.asouza.algafood.domain.model.Cozinha;
import com.asouza.algafood.domain.model.Restaurante;
import com.asouza.algafood.domain.repositories.CozinhaRepository;
import com.asouza.algafood.domain.repositories.RestauranteRepository;
import com.asouza.algafood.domain.services.RestauranteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final CozinhaRepository cozinhaRepository;


    public RestauranteServiceImpl(RestauranteRepository restauranteRepository, CozinhaRepository cozinhaRepository) {
        this.restauranteRepository = restauranteRepository;
        this.cozinhaRepository = cozinhaRepository;
    }


    @Override
    public Restaurante cadastrar(Restaurante restaurante) {
        Cozinha cozinha = restaurante.getCozinha();

        if (cozinha != null && (cozinha.getId() == null || cozinhaRepository.findById(cozinha.getId()).isEmpty())) {
            cozinhaRepository.save(cozinha);
        }

        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entidade não encontrada pelo id: "+ id));
    }

    @Override
    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante atualizarPorId(Long id, Restaurante restaurante) {
        Restaurante porId = buscarPorId(id);
        return restauranteRepository.save(porId);
    }

    @Override
    public void deletarPorId(Long id) {
        restauranteRepository.deleteById(id);

    }

    @Override
    public List<Restaurante> buscarPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }
}
