package com.kayan.instzaa.service;

import com.kayan.instzaa.controller.dto.CardapioDTO;
import com.kayan.instzaa.domain.model.Cardapio;
import com.kayan.instzaa.domain.repository.CardapioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioService {

    private final CardapioRepository repository;

    public CardapioService(CardapioRepository repository){
        this.repository = repository;
    }

    public Cardapio save(CardapioDTO cardapioDTO) {
        Cardapio cardapio = new Cardapio();
        cardapio.setNome(cardapioDTO.nome());
        cardapio.setDescricao(cardapioDTO.descricao());
        cardapio.setImagem(cardapioDTO.imagem());
        cardapio.setPreco(cardapioDTO.preco());
        cardapio.setCategoria(cardapioDTO.categoria());
        cardapio.setDestaque(cardapioDTO.destaque());
        cardapio.setPromocao(cardapioDTO.promocao());
        cardapio.setItemLanche(cardapioDTO.itemLanche());
        repository.save(cardapio);
        return cardapio;
    }

    public CardapioDTO update(Long id, CardapioDTO cardapioDTO){
        Optional<Cardapio> cardapioId = Optional.ofNullable(findById(id));
        Cardapio cardapio = cardapioId.get();
        cardapio.setNome(cardapioDTO.nome());
        cardapio.setDescricao(cardapioDTO.descricao());
        cardapio.setImagem(cardapioDTO.imagem());
        cardapio.setPreco(cardapioDTO.preco());
        cardapio.setCategoria(cardapioDTO.categoria());
        cardapio.setDestaque(cardapioDTO.destaque());
        cardapio.setPromocao(cardapioDTO.promocao());
        cardapio.setItemLanche(cardapioDTO.itemLanche());
        repository.save(cardapio);
        return cardapioDTO;
    }

    public List<Cardapio> list(){
        return repository.findAll();
    }

    public List<Cardapio> listCardapio() throws Exception {
        return repository.findCardapioLanche(true);
    }



    public List<Cardapio> listPagination(Integer page, Integer limit){
        List<Cardapio> lista = repository.findAll();

        if(page == 1) {
            return lista.subList(0, limit);
        }else if(page != 1){
            return lista.subList(page*limit, page*limit+limit);
        }
        return null;
    }

    public Cardapio findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        Optional<Cardapio> cardapio = Optional.ofNullable(findById(id));
        repository.delete(cardapio.get());
    }
}
