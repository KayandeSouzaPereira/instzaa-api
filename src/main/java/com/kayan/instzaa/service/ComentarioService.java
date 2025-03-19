package com.kayan.instzaa.service;

import com.kayan.instzaa.domain.model.Comentario;
import com.kayan.instzaa.domain.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {
    private ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario update(Integer id, Comentario comentario) {
        Optional<Comentario> comentarioId = Optional.ofNullable(findById(id));
        Comentario comentarioToUpdate = comentarioId.get();
        comentarioToUpdate.setDataComentario(comentario.getDataComentario());
        comentarioToUpdate.setNomeComentario(comentario.getNomeComentario());
        comentarioToUpdate.setComentario(comentario.getComentario());
        comentarioToUpdate.setNota(comentario.getNota());
        comentarioRepository.save(comentarioToUpdate);
        return comentarioToUpdate;
    }

    public List<Comentario> list() {
        return comentarioRepository.findAll();
    }

    public void delete(Integer id){
        Optional<Comentario> comentario = Optional.ofNullable(findById(id));
        comentarioRepository.delete(comentario.get());
    }

    public Comentario findById(Integer id) {
        return comentarioRepository.findById(Long.valueOf(id)).orElseThrow();
    }

    public List<Comentario> findByIdProduto(Integer idProduto) {
        return comentarioRepository.listComentarioByIdProduto(idProduto);
    }
}
