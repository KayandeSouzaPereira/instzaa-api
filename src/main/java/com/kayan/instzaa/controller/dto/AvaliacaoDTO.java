package com.kayan.instzaa.controller.dto;

import com.kayan.instzaa.domain.model.Avaliacao;

public record AvaliacaoDTO(
        Integer idPedido,
        Integer avaliacao
) {

    public Avaliacao toDomain() {
        return new Avaliacao(idPedido, avaliacao);
    }

    public static AvaliacaoDTO fromDomain(Avaliacao avaliacao){
        return new AvaliacaoDTO(avaliacao.getIdPedido(), avaliacao.getAvaliacao());
    }


}
