package com.kayan.instzaa.domain.repository;

import com.kayan.instzaa.domain.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

    @Query(value="Select cardapio from Cardapio cardapio where cardapio.itemLanche = :item")
    List<Cardapio> findCardapioLanche(Boolean item) throws Exception;

}
