package com.kayan.instzaa.controller;

import com.kayan.instzaa.controller.dto.CardapioDTO;
import com.kayan.instzaa.controller.dto.PedidoDTO;
import com.kayan.instzaa.domain.model.Cardapio;
import com.kayan.instzaa.domain.model.Pedido;
import com.kayan.instzaa.service.CardapioService;
import com.kayan.instzaa.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RequestMapping("/pedido")
@RestController
@Tag(name = "Controlador dos Pedidos", description = "RESTful API for delivery.")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService pedidoService){
        this.service = pedidoService;
    }

    @GetMapping("/")
    @Operation(summary = "Lista pedidos", description = "Lista todos os pedidos realizados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public  ResponseEntity<List<Pedido>> list() {
        return ResponseEntity.ok(service.list());
    }
    @GetMapping("/{id}")
    @Operation(summary = "Pega pelo Id", description = "Retorna um único pedido pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado.")
    })

    public ResponseEntity<PedidoDTO> getByID(@PathVariable("id") Long id) {
        Pedido pedido = service.findById(id);
        PedidoDTO pedidoDTO = PedidoDTO.fromDomain(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }
    @GetMapping("/page{page}/limit{limit}")
    @Operation(summary = "Lista pedidos com paginação", description = "Lista todos os pedidos com opção de paginação e limite.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<List<Pedido>> list(@PathVariable("page")Integer page, @PathVariable("limit")Integer limit) {
        return ResponseEntity.ok(service.listPagination(page, limit));
    }
    @PostMapping
    @Operation(summary = "Cria pedido", description = "Adiciona um novo pedido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a criação do pedido invalidos.")
    })
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = service.save(pedidoDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedido.getId())
                .toUri();
        return ResponseEntity.created(location).body(PedidoDTO.fromDomain(pedido));
    }
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza o pedido", description =  "Atualiza o pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso !"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a atualização do pedido invalidos.")
    })
    public ResponseEntity<PedidoDTO> update(@PathVariable("id") Long id,@RequestBody PedidoDTO pedidoDTO){
        return ResponseEntity.ok(service.update(id, pedidoDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove pedido", description = "Remove pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido removido com sucesso !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado.")
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{id}")
    @Operation(summary = "Atualiza status pelo Id", description = "Atualiza status pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado.")
    })
    public ResponseEntity<PedidoDTO> updateStatusByID(@PathVariable("id") Long id) {
        Pedido pedido = service.updateStatus(id);
        PedidoDTO pedidoDTO = PedidoDTO.fromDomain(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/cancelaStatus/{id}")
    @Operation(summary = "Cancela pelo Id", description = "Cancela pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado.")
    })
    public ResponseEntity<PedidoDTO> cancelaStatusByID(@PathVariable("id") Long id) {
        Pedido pedido = service.updateStatusCancelar(id);
        PedidoDTO pedidoDTO = PedidoDTO.fromDomain(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }

}
