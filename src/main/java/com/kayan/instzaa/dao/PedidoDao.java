package com.kayan.instzaa.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kayan.instzaa.model.Pedido;

@EntityScan
public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
