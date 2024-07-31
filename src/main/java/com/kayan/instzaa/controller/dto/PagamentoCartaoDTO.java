package com.kayan.instzaa.controller.dto;

public record PagamentoCartaoDTO(
        String Nome,
        String Cpf,
        String Valor,
        String Telefone,
        String Email,
        String DataDeNascimento,
        String PaymentToken,
        String Rua,
        String NumeroEndereco,
        String Bairro,
        String Cep,
        String Cidade,
        String Estado
) {
}
