package com.kayan.instzaa.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="AVALIACAO_PEDIDO")
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idAvalicao;

    @Column
    private Integer idPedido;

    @Column
    private Integer avaliacao;

    public Avaliacao(Integer idPedido, Integer avaliacao){}

}
