package com.kayan.instzaa.service;

import java.util.List;
import java.util.Optional;

import com.kayan.instzaa.model.Pedido;
import com.kayan.instzaa.model.PedidoDT;

public interface PedidoService {
	
	void save(PedidoDT item) throws Exception;
	List<Pedido> getAll() throws Exception;
	void removeById(Long id) throws Exception;
	Optional<Pedido> findById(Long id) throws Exception;

}
