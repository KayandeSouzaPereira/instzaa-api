package com.kayan.instzaa.service;

import java.util.List;
import java.util.Optional;

import com.kayan.instzaa.model.CardapioItem;
import com.kayan.instzaa.model.CardapioItemDT;

public interface CardapioService {
	
	void save(CardapioItemDT item) throws Exception;
	
	List<CardapioItem> getAll() throws Exception;
	
	void removeById(Long id) throws Exception;
	
	Optional<CardapioItem> findById(Long id) throws Exception;

}
