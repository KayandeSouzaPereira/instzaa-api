package com.kayan.instzaa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayan.instzaa.dao.PedidoDao;
import com.kayan.instzaa.model.Pedido;
import com.kayan.instzaa.model.PedidoDT;

import jakarta.transaction.Transactional;


@Service("PedidoService")
@Transactional
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoDao pedidoDao;

	@Override
	public void save(PedidoDT item) throws Exception {
		Pedido itemEnt = new Pedido();
		
		if(item.getIdPedido() != null) {
			itemEnt.setIdPedido(item.getIdPedido());
		}
		itemEnt.setNomeCliente(item.getNomeCliente());
		itemEnt.setEndereco(item.getEndereco());
		itemEnt.setCpf(item.getCPF());
		itemEnt.setData(item.getData());
		itemEnt.setNumeroContato(item.getNumeroContato());
		itemEnt.setValor(item.getValor());
		itemEnt.setResumoPedido(item.getResumoPedido());
		itemEnt.setStatus(item.getStatus());
		
		
		
		pedidoDao.saveAndFlush(itemEnt);
	}

	@Override
	public List<Pedido> getAll() throws Exception {
		return pedidoDao.findAll();
	}

	@Override
	public void removeById(Long id) throws Exception {
		 pedidoDao.deleteById(id);
	}

	@Override
	public Optional<Pedido> findById(Long id) throws Exception {
		return pedidoDao.findById(id);
	}

}
