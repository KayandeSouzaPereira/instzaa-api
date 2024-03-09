package com.kayan.instzaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kayan.instzaa.model.Pedido;
import com.kayan.instzaa.model.PedidoDT;
import com.kayan.instzaa.service.PedidoService;


@RestController
@RequestMapping("pedido")
public class PedidoController {
	
	@Lazy
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value = "listPedido", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> listCardapio() throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		List<Pedido> lista = service.getAll();
		resposta.put("lista", lista);
		
		return resposta;
	}
	
	@RequestMapping(value = "savePedido", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> savePedido(@RequestBody PedidoDT item) throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		service.save(item);
		
		return resposta;
	}
	
	@RequestMapping(value = "deletePedido", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> deletePedido(@RequestBody Long item) throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		service.removeById(item);
		
		return resposta;
	}
	
	@RequestMapping(value = "findByIDPedido", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> findByIDPedido(@RequestBody Long item) throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		Optional<Pedido> pedido = service.findById(item);
		resposta.put("pedido", pedido);
		
		return resposta;
	}


}
