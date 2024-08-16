package com.kayan.instzaa.controller.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public record PagamentoCriacaoDTO(
       String cpf,
       String nome,
       String valor
) {


}
