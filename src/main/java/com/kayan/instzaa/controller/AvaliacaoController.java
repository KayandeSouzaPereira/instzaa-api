package com.kayan.instzaa.controller;


import com.kayan.instzaa.controller.dto.AvaliacaoDTO;
import com.kayan.instzaa.controller.dto.EmpresaDto;
import com.kayan.instzaa.domain.model.Empresa;
import com.kayan.instzaa.service.AvaliacaoService;
import com.kayan.instzaa.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/avaliacao")
@RestController
@Tag(name = "Controlador da Avaliação", description = "RESTful API for delivery.")
public class AvaliacaoController {

    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {this.service = avaliacaoService;}

    @GetMapping("/{id}")
    @Operation(summary = "Apresentar avaliacao pelo Id do Pedido", description = "Apresentar avaliacao pelo Id do Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<AvaliacaoDTO> get(@PathVariable("id") Integer id) throws Exception {return ResponseEntity.ok(service.findById(id));}


    @PostMapping("")
    @Operation(summary = "Salva avaliação", description = "Salva avaliação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atualizado com sucesso !"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a salvar o item invalidos.")
    })
    public ResponseEntity<AvaliacaoDTO> save(@RequestBody AvaliacaoDTO avaliacaoDTO){
        return ResponseEntity.ok(service.save(avaliacaoDTO));
    }



}
