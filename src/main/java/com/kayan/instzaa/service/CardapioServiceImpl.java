package com.kayan.instzaa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayan.instzaa.dao.CardapioDao;
import com.kayan.instzaa.model.CardapioItem;
import com.kayan.instzaa.model.CardapioItemDT;

import jakarta.transaction.Transactional;




@Service("CardapioService")
@Transactional
public class CardapioServiceImpl implements CardapioService {
	@Autowired
	CardapioDao cardapioDao;
	
	@Override
	public Optional<CardapioItem> findById(Long id) throws Exception {
		return cardapioDao.findById(id);
	}

	@Override
	public void save(CardapioItemDT item) throws Exception {
		CardapioItem itemEnt = new CardapioItem();
		
		if(item.getIdCardapio() != null) {
			itemEnt.setIdCardapio(item.getIdCardapio());
		}
		System.out.println(item.getNome());
		itemEnt.setNome(item.getNome());
		itemEnt.setDescricao(item.getDescricao());
		itemEnt.setImagem(item.getImagem());
		itemEnt.setPreco(item.getPreco());
		itemEnt.setCategoria(item.getCategoria());

		Long destaque = (long) (item.getDestaque() ? 1 : 0);
		Long promocao = (long) (item.getPromocao() ? 1 : 0);

		itemEnt.setDestaque(destaque);
		itemEnt.setPromocao(promocao);
		
		
		
		cardapioDao.save(itemEnt);
	}

	@Override
	public List<CardapioItem> getAll() throws Exception {
		return cardapioDao.findAll();
	}

	@Override
	public void removeById(Long id) throws Exception {
		Optional<CardapioItem> item = cardapioDao.findById(id);
		if(item.isPresent()) {
			cardapioDao.deleteById(id);
		}
	}
	
}
