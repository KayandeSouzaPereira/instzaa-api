package com.kayan.instzaa.domain.model;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.Set;


public class ResumoPedido {
    @ManyToMany
    @JoinTable(
            name="resumo_pedido",
            joinColumns = @JoinColumn(name="pedido_id"),
            inverseJoinColumns = @JoinColumn(name ="cardapio_id")
    )
    Set<Cardapio> resumoPedido;
}
