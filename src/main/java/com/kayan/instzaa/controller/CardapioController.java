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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kayan.instzaa.model.CardapioItem;
import com.kayan.instzaa.model.CardapioItemDT;
import com.kayan.instzaa.service.CardapioService;

@RestController
@RequestMapping("cardapio")
public class CardapioController {
	
	
	@Lazy
	@Autowired
	private CardapioService service;
	
	@RequestMapping(value = "listCardapio", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> listCardapio() throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		List<CardapioItem> lista = service.getAll();
		resposta.put("lista", lista);
		
		return resposta;
	}
	
	@RequestMapping(value = "saveCardapioItem", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> saveCardapioItem(@RequestBody CardapioItemDT item) throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		service.save(item);
		
		return resposta;
	}
	
	@RequestMapping(value = "deleteCardapioItem", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> deleteCardapioItem(@RequestBody String std) throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(std);
		Long id = mapper.convertValue(node.get("id"), Long.class);
		service.removeById(id);
		
		return resposta;
	}
	
	@RequestMapping(value = "findByIDCardapioItem", method = RequestMethod.POST,produces = "application/json")
	public Map<String, Object> findByIDCardapioItem(@RequestBody Long item) throws Exception {
		Map<String, Object> resposta = new HashMap<String, Object>();
		
		Optional<CardapioItem> itemCardapio = service.findById(item);
		resposta.put("item", itemCardapio);
		
		return resposta;
	}

}
