package com.kayan.instzaa.controller.dto;

import java.util.Date;

public record CardPaymentReceiveDTO(
        Date data,
        String valor,
        String idPedido
) {
}
