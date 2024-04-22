package com.kayan.instzaa.controller.dto;

import com.kayan.instzaa.domain.model.Cardapio;
import com.kayan.instzaa.domain.model.Pedido;
import com.kayan.instzaa.domain.model.Status;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public record PedidoDTO(
        Integer id,
        String nomeCliente,
        String CPF,
        String endereco,
        Date data,
        String numeroContato,
        BigDecimal valor,
        Status status,
        Set<Cardapio> resumoPedido
) {

    public static PedidoDTO fromDomain(Pedido pedido){
        return new PedidoDTO(
                pedido.getId(),
                pedido.getNomeCliente(),
                pedido.getCPF(),
                pedido.getEndereco(),
                pedido.getData(),
                pedido.getNumeroContato(),
                pedido.getValor(),
                pedido.getStatus(),
                pedido.getResumoPedido()
        );
    }

    public static Pedido toDomain(PedidoDTO pedidoDTO){
        return new Pedido(
                pedidoDTO.id(),
                pedidoDTO.nomeCliente(),
                pedidoDTO.CPF(),
                pedidoDTO.endereco(),
                pedidoDTO.data(),
                pedidoDTO.numeroContato(),
                pedidoDTO.valor(),
                pedidoDTO.status(),
                pedidoDTO.resumoPedido()
        );
    }
}