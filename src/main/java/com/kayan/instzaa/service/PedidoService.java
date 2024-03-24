package com.kayan.instzaa.service;


import com.kayan.instzaa.controller.dto.CardapioDTO;
import com.kayan.instzaa.controller.dto.PedidoDTO;
import com.kayan.instzaa.domain.model.Cardapio;
import com.kayan.instzaa.domain.model.Pedido;
import com.kayan.instzaa.domain.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;


    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido save(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setNomeCliente(pedidoDTO.nomeCliente());
        pedido.setCPF(pedidoDTO.CPF());
        pedido.setEndereco(pedidoDTO.endereco());
        pedido.setValor(pedidoDTO.valor());
        pedido.setNumeroContato(pedidoDTO.numeroContato());
        pedido.setData(pedidoDTO.data());
        pedido.setResumoPedido(pedidoDTO.resumoPedido());
        repository.save(pedido);
        return pedido;
    }

    public PedidoDTO update(Long id, PedidoDTO pedidoDTO){
        Optional<Pedido> pedidoId = Optional.ofNullable(findById(id));
        Pedido pedido = pedidoId.get();
        pedido.setNomeCliente(pedidoDTO.nomeCliente());
        pedido.setCPF(pedidoDTO.CPF());
        pedido.setEndereco(pedidoDTO.endereco());
        pedido.setValor(pedidoDTO.valor());
        pedido.setNumeroContato(pedidoDTO.numeroContato());
        pedido.setData(pedidoDTO.data());
        pedido.setResumoPedido(pedidoDTO.resumoPedido());
        repository.save(pedido);
        return pedidoDTO;
    }

    public List<Pedido> list(){
        return repository.findAll();
    }

    public List<Pedido> listPagination(Integer page, Integer limit){
        List<Pedido> lista = repository.findAll();

        if(page == 1) {
            return lista.subList(0, limit);
        }else if(page != 1){
            return lista.subList(page*limit, page*limit+limit);
        }
        return null;
    }

    public Pedido findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        Optional<Pedido> pedido = Optional.ofNullable(findById(id));
        repository.delete(pedido.get());
    }



}
