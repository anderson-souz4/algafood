package com.asouza.algafood.domain.services.impl;

import com.asouza.algafood.domain.model.Cozinha;
import com.asouza.algafood.domain.model.Restaurante;
import com.asouza.algafood.domain.repositories.CozinhaRepository;
import com.asouza.algafood.domain.repositories.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CozinhaRepository cozinhaRepository;
    private final RestauranteRepository restauranteRepository;

    @Autowired
    public DataInitializer(CozinhaRepository cozinhaRepository, RestauranteRepository restauranteRepository) {
        this.cozinhaRepository = cozinhaRepository;
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Adicionando cozinhas
        Cozinha brasileira = Cozinha.builder().nome("brasileira").build();
        Cozinha tailandesa = Cozinha.builder().nome("tailandesa").build();
        Cozinha japonesa = Cozinha.builder().nome("japonesa").build();

        cozinhaRepository.save(brasileira);
        cozinhaRepository.save(tailandesa);
        cozinhaRepository.save(japonesa);

        // Adicionando restaurantes com as respectivas cozinhas
        Restaurante restaurante1 = Restaurante.builder()
                .nome("Restaurante Brasileiro")
                .cozinha(brasileira)
                .taxaFrete(new BigDecimal("9.50"))
                .build();

        Restaurante restaurante2 = Restaurante.builder()
                .nome("Restaurante Tailandês")
                .cozinha(tailandesa)
                .taxaFrete(new BigDecimal("12.50"))
                .build();

        Restaurante restaurante3 = Restaurante.builder()
                .nome("Restaurante Japonês")
                .cozinha(japonesa)
                .taxaFrete(new BigDecimal("15.00"))
                .build();

        restauranteRepository.save(restaurante1);
        restauranteRepository.save(restaurante2);
        restauranteRepository.save(restaurante3);

        System.out.println("Dados iniciais adicionados no banco de dados.");
    }
}
