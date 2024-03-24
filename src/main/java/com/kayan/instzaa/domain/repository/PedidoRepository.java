package com.kayan.instzaa.domain.repository;

import com.kayan.instzaa.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
