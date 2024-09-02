package com.kayan.instzaa.service;


import com.kayan.instzaa.controller.dto.AvaliacaoDTO;
import com.kayan.instzaa.domain.model.Avaliacao;
import com.kayan.instzaa.domain.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository){this.repository = repository;}

    public AvaliacaoDTO save(AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoDTO.toDomain();
        repository.save(avaliacao);
        return avaliacaoDTO;
    }

    public AvaliacaoDTO findById(Integer id) throws Exception{
        Avaliacao avaliacao = repository.findByIdPedido(id).get();
        return new AvaliacaoDTO(avaliacao.getIdPedido(), avaliacao.getAvaliacao());
    }



}
