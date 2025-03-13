package com.kayan.instzaa.controller;

import com.kayan.instzaa.domain.model.Comentario;
import com.kayan.instzaa.service.ComentarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/comentario")
@RestController
@Tag(name = "Controlador dos comentários", description = "RESTful API for delivery.")
public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService comentarioService) {
        this.service = comentarioService;
    }

    @GetMapping("/")
    @Operation(summary = "Lista comentarios", description = "Lista todos os comentários do item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada")
    })
    public ResponseEntity<List<Comentario>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Pega o comentário pelo id", description = "Retorna um único comentário pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "404", description = "Comentário não encontrado")
    })
    public ResponseEntity<Comentario> getById(@PathVariable("id") Integer id) {
        Comentario comentario = service.findById(id);
        return ResponseEntity.ok(comentario);
    }

    @GetMapping("/comentarioByIdProduto/{id}")
    @Operation(summary = "Pega o produto pelo id", description = "Retorna um produto pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<List<Comentario>> getComentarioByIdProduto(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findByIdProduto(id));
    }

    @PostMapping
    @Operation(summary = "Cria comentario", description = "Adiciona um novo comentario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comentário criado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "422", description = "Dados para a criação do comentário inválidos")
    })
    public ResponseEntity<Comentario> create(@RequestBody Comentario comentario){
        Comentario comentarioToCreate = service.save(comentario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(comentarioToCreate.getIdComentario())
                .toUri();
        return ResponseEntity.created(location).body(comentarioToCreate);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza o comentário", description = "Atualiza o comentário do item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comentário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Comentário não encontrado"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "422", description = "Dados para a atualização do comentário inválidos")
    })
    public ResponseEntity<Comentario> update(@PathVariable("id") Integer id, @RequestBody Comentario comentario){
        return ResponseEntity.ok(service.update(id, comentario));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove comentário", description = "Remove o comentário do item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Comentário removido com sucesso"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada"),
            @ApiResponse(responseCode = "404", description = "Comentário não encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
