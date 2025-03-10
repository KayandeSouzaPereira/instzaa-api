package com.kayan.instzaa.controller;


import com.kayan.instzaa.controller.dto.CardapioDTO;
import com.kayan.instzaa.controller.dto.ItemLancheDTO;
import com.kayan.instzaa.domain.model.ItemLanche;
import com.kayan.instzaa.service.ItemLancheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/itemLanche")
@RestController
@Tag(name = "Controlador dos Itens de lanches", description = "RESTful API for delivery.")
public class ItemLancheController {
    private final ItemLancheService service;

    public ItemLancheController(ItemLancheService service) { this.service = service;}

    @GetMapping("/")
    @Operation(summary = "Lista opções de complementos para lanches", description = "Lista opções de complementos para lanches")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<List<ItemLanche>> list() {return ResponseEntity.ok(service.list());}

    @GetMapping("/{id}")
    @Operation(summary = "Pega pelo id", description = "Retorna um único complemento pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Item não encontrado.")
    })
    public ResponseEntity<ItemLanche> getByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/page{page}/limit{limit}")
    @Operation(summary = "Lista opções de complemento para lanches com paginação", description = "Lista opções de complemento para lanches com paginação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<List<ItemLanche>> list(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit) {
        return ResponseEntity.ok(service.listPagination(page,limit));
    }

    @PostMapping
    @Operation(summary = "Cria complemento para lanche", description = "Cria complemento para lanche")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Complemento criado com sucesso !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a criação do complemento invalidos.")
    })
    public ResponseEntity<ItemLancheDTO> create(@RequestBody ItemLancheDTO itemLancheDTO){
        ItemLanche itemLanche = service.save(itemLancheDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemLanche.getIdItemLanche())
                .toUri();
        return ResponseEntity.created(location).body(itemLancheDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza o complemento para lanche", description =  "Atualiza o complemento para lanche")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Complemento atualizado com sucesso !"),
            @ApiResponse(responseCode = "404", description = "Complemento não encontrado."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a atualização do complemento invalidos.")
    })
    public ResponseEntity<ItemLancheDTO> update(@PathVariable("id") Long id, @RequestBody ItemLancheDTO itemLancheDTO){
        return ResponseEntity.ok(service.update(id, itemLancheDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove complemento para lanche", description = "Remove complemento para lanche")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item complemento com sucesso !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Complemento não encontrado.")
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
