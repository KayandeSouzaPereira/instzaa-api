package com.kayan.instzaa.controller;


import com.kayan.instzaa.controller.dto.CardapioDTO;
import com.kayan.instzaa.controller.dto.PedidoDTO;
import com.kayan.instzaa.domain.model.Cardapio;
import com.kayan.instzaa.domain.model.Pedido;
import com.kayan.instzaa.service.CardapioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cardapio")
@RestController
@Tag(name = "Controlador do Cardapio", description = "RESTful API for delivery.")
public class CardapioController {

    private final CardapioService service;

    public CardapioController(CardapioService cardapioService){
        this.service = cardapioService;
    }


    @GetMapping("/")
    @Operation(summary = "Lista cardapio", description = "Lista todos os itens do cardapio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<List<Cardapio>> list() {
        return ResponseEntity.ok(service.list());
    }
    @GetMapping("/{id}")
    @Operation(summary = "Pega pelo Id", description = "Retorna um único item do cardapio pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Item não encontrado.")
    })

    public ResponseEntity<CardapioDTO> getByID(@PathVariable("id") Long id) {
        Cardapio cardapio = service.findById(id);
        CardapioDTO cardapioDTO = CardapioDTO.fromDomain(cardapio);
        return ResponseEntity.ok(cardapioDTO);
    }
    @GetMapping("/page{page}/limit{limit}")
    @Operation(summary = "Lista cardapio com paginação", description = "Lista todos os itens do cardapio com opção de paginação e limite.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<List<Cardapio>> list(@PathVariable("page")Integer page, @PathVariable("limit")Integer limit) {
        return ResponseEntity.ok(service.listPagination(page, limit));
    }
    @PostMapping
    @Operation(summary = "Cria item", description = "Adiciona um novo item ao cardapio.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a criação do item invalidos.")
    })
    public ResponseEntity<CardapioDTO> create(@RequestBody CardapioDTO cardapioDTO){
        Cardapio cardapio = service.save(cardapioDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cardapio.getId())
                .toUri();
        return ResponseEntity.created(location).body(CardapioDTO.fromDomain(cardapio));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza o item", description =  "Atualiza o item do cardapio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atualizado com sucesso !"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a atualização do item invalidos.")
    })
    public ResponseEntity<CardapioDTO> update(@PathVariable("id") Long id,@RequestBody CardapioDTO cardapioDTO){
        return ResponseEntity.ok(service.update(id, cardapioDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove item", description = "Remove item do cardapio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item removido com sucesso !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Item não encontrado.")
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
