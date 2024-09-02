package com.kayan.instzaa.domain.repository;

import com.kayan.instzaa.domain.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query(value="Select avaliacao from Avaliacao avaliacao where avaliacao.idPedido = :idPedido")
    Optional<Avaliacao> findByIdPedido(Integer idPedido) throws Exception;
}
