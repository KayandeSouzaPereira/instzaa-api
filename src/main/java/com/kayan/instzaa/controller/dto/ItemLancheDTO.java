package com.kayan.instzaa.controller.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.kayan.instzaa.domain.model.ItemLanche;

import java.math.BigDecimal;

@JsonInclude
public record ItemLancheDTO(
        Integer id_lanche,
        Long id,
        String imagem,
        String descricao,
        BigDecimal preco
) {
}
