package com.kayan.instzaa.controller;


import com.kayan.instzaa.service.PagamentoService;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pagamento")
@RestController
@Tag(name = "Controlador do Pagamento", description = "RESTful API for delivery.")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService pagamentoService){
        this.service = pagamentoService;
    }

    @GetMapping("/")
    @Operation(summary = "Teste de pagamento", description = "Teste de pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<String> testePagamento() throws MPException, MPApiException {
        return ResponseEntity.ok(service.testePagamento());
    }

}
