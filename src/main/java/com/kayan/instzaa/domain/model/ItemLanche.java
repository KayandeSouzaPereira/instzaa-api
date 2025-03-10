package com.kayan.instzaa.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="item_lanche")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemLanche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idItemLanche;

    @ManyToOne
    @JoinColumn(name="id")
    private Cardapio cardapio;

    @JoinColumn(name="imagem")
    private String imagem;

    @JoinColumn(name="descricao")
    private String descricao;

    @JoinColumn(name="preco")
    private BigDecimal preco;

}
