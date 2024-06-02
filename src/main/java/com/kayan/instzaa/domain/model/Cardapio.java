package com.kayan.instzaa.domain.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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



    public Cardapio(String nome, String descricao, String imagem, BigDecimal preco, String categoria, boolean destaque, boolean promocao) {
    }


    public static Cardapio create(String nome, String descricao, String imagem, BigDecimal preco, String categoria, boolean destaque, boolean promocao) {
        return new Cardapio(nome, descricao, imagem, preco, categoria, destaque, promocao);
    }
    public static Cardapio update(Integer id, String nome, String descricao, String imagem, BigDecimal preco, String categoria, boolean destaque, boolean promocao) {
        return new Cardapio(id, nome, descricao, imagem, preco, categoria, destaque, promocao);
    }

}
