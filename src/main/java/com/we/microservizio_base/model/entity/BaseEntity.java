package com.we.microservizio_base.model.entity;

import com.we.microservizio_base.K.K;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = K.BASE_ENTITY + K.SEQ_GEN)
    @SequenceGenerator(name = K.BASE_ENTITY + K.SEQ_GEN)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String nome;

    @Column
    private String cognome;

    @Column
    private LocalDate data;


}
