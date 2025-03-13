package com.kayan.instzaa.domain.repository;

import com.kayan.instzaa.domain.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    @Query(value="select comentario from Comentario comentario where comentario.idCardapio = :idCardapio")
    List<Comentario> listComentarioByIdProduto(Integer idCardapio);
}
