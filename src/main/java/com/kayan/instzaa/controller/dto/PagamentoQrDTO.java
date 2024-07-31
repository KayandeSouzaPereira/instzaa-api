package com.kayan.instzaa.controller.dto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public record PagamentoQrDTO(
       String QrCode,
       String Pix
) {


}
