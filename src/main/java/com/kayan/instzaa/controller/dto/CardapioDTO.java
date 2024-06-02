package com.kayan.instzaa.controller.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.kayan.instzaa.domain.model.Cardapio;

import java.math.BigDecimal;
import java.math.BigInteger;

@JsonInclude
public record CardapioDTO(
        Integer id,
        String nome,
        String descricao,
        String imagem,
        BigDecimal preco,
        String categoria,
        boolean destaque,
        boolean promocao

) {
    public static CardapioDTO fromDomain(Cardapio cardapio){
        return new CardapioDTO(
                cardapio.getId(),
                cardapio.getNome(),
                cardapio.getDescricao(),
                cardapio.getImagem(),
                cardapio.getPreco(),
                cardapio.getCategoria(),
                cardapio.isDestaque(),
                cardapio.isPromocao()
        );
    }

    public Cardapio toDomain(){
        return Cardapio.create(nome,descricao,imagem,preco,categoria,destaque,promocao);
    }

    public Cardapio toDomainUpdate(Integer id){
        return Cardapio.update(
                id,nome,descricao,imagem,preco,categoria,destaque,promocao
        );
    }

}
