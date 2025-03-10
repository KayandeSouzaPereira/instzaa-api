package com.kayan.instzaa.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name="CARDAPIO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Column
    private String imagem;

    @Column
    private BigDecimal preco;

    @Column
    private String categoria;

    @Column
    private boolean destaque;

    @Column
    private boolean promocao;

    @Column
    private boolean itemLanche;

    @OneToMany(mappedBy = "cardapio", fetch = FetchType.LAZY)
    private Set<ItemLanche> itemLanches;

    public Cardapio(Integer id, String nome, String descricao, String imagem, BigDecimal preco, String categoria, boolean destaque, boolean promocao, boolean itemLanche) {
    }


    public static Cardapio create(Integer id, String nome, String descricao, String imagem, BigDecimal preco, String categoria, boolean destaque, boolean promocao, boolean itemLanche) {
        return new Cardapio(id, nome, descricao, imagem, preco, categoria, destaque, promocao, itemLanche);
    }
    public static Cardapio update(Integer id, String nome, String descricao, String imagem, BigDecimal preco, String categoria, boolean destaque, boolean promocao, boolean itemLanche) {
        return new Cardapio(id, nome, descricao, imagem, preco, categoria, destaque, promocao, itemLanche);
    }

}
