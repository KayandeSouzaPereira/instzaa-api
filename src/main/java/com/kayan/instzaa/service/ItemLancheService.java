package com.kayan.instzaa.service;


import com.kayan.instzaa.controller.dto.ItemLancheDTO;
import com.kayan.instzaa.domain.model.ItemLanche;
import com.kayan.instzaa.domain.repository.CardapioRepository;
import com.kayan.instzaa.domain.repository.ItemLancheRepository;
import io.swagger.v3.oas.models.info.License;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemLancheService {

    private final ItemLancheRepository repository;
    private final CardapioRepository cardapioRepository;

    public ItemLancheService(ItemLancheRepository repository, CardapioRepository cardapioRepository) {
        this.repository = repository;
        this.cardapioRepository = cardapioRepository;
    }


    public ItemLanche save(ItemLancheDTO itemLancheDTO) {
        ItemLanche itemLanche = new ItemLanche();
        itemLanche.setIdItemLanche(itemLancheDTO.id_lanche());
        itemLanche.setCardapio(cardapioRepository.findById(itemLancheDTO.id()).get());
        itemLanche.setImagem(itemLancheDTO.imagem());
        itemLanche.setDescricao(itemLancheDTO.descricao());
        itemLanche.setPreco(itemLancheDTO.preco());
        repository.save(itemLanche);
        return itemLanche;
    }

    public ItemLancheDTO update(Long id, ItemLancheDTO itemLancheDTO) {
        Optional<ItemLanche> _itemLanche = Optional.ofNullable(findById(id));
        ItemLanche itemLanche = _itemLanche.get();
        itemLanche.setIdItemLanche(itemLancheDTO.id_lanche());
        itemLanche.setCardapio(cardapioRepository.findById(itemLancheDTO.id()).get());
        itemLanche.setImagem(itemLancheDTO.imagem());
        itemLanche.setDescricao(itemLancheDTO.descricao());
        itemLanche.setPreco(itemLancheDTO.preco());
        repository.save(itemLanche);
        return itemLancheDTO;
    }

    public List<ItemLanche> list(){
        return repository.findAll();
    }

    public List<ItemLanche> listPagination(Integer page, Integer limit){
        List<ItemLanche> lista = repository.findAll();

        if(page == 1){
            return lista.subList(0, limit);
        } else if(page != 1){
            return lista.subList(page*limit, page*limit+limit);
        }
        return null;
    }

    public ItemLanche findById(Long id){ return repository.findById(id).orElseThrow(); }

    public void delete(Long id){
        Optional<ItemLanche> itemLanche = Optional.ofNullable(findById(id));
        repository.delete(itemLanche.get());
    }

}
