package com.asouza.algafood.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(of = "id")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
