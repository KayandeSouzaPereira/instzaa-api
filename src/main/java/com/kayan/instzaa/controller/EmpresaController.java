package com.kayan.instzaa.controller;


import com.kayan.instzaa.controller.dto.EmpresaDto;
import com.kayan.instzaa.domain.model.Empresa;
import com.kayan.instzaa.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/empresa")
@RestController
@Tag(name = "Controlador da Empresa", description = "RESTful API for delivery.")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService empresaService) {this.service = empresaService;}

    @GetMapping("/")
    @Operation(summary = "Apresentar os dados da empresa", description = "Apresentar os dados da empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<Empresa> get() {return ResponseEntity.ok(service.findById(1L));}


    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados da Empresa", description = "Atualiza dados da empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atualizado com sucesso !"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada."),
            @ApiResponse(responseCode = "422", description = "Dados para a atualização do item invalidos.")
    })
    public ResponseEntity<EmpresaDto> update(@PathVariable("id") Long id, @RequestBody EmpresaDto empresaDto){
        return ResponseEntity.ok(service.update(id, empresaDto));
    }



}
