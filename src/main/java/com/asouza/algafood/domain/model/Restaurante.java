package com.asouza.algafood.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(of = "id")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurante_id")
//    private List<FormaPagamento> formasPagamento;





}
