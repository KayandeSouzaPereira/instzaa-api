package com.kayan.instzaa.controller;


import com.kayan.instzaa.controller.dto.*;
import com.kayan.instzaa.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/pagamento")
@RestController
@Tag(name = "Controlador do Pagamento", description = "RESTful API for delivery.")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService pagamentoService){
        this.service = pagamentoService;
    }

    @PostMapping("/criarPagamento")
    @Operation(summary = "Criando Pagamento PIX", description = "Criando uma cobrança de pagamento com QR PIX")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<PagamentoQrDTO> criarPagamento(@RequestBody PagamentoCriacaoDTO pagamento) throws Exception{
        return ResponseEntity.ok(service.createPagamento(pagamento));
    }
    @PostMapping("/criarPagamentoCartao")
    @Operation(summary = "Criando Pagamento Cartão", description = "Criando uma cobrança de pagamento com Cartão de Credito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<String> criarPagamentoCartao(@RequestBody PagamentoCartaoDTO pagamento) throws Exception{
        service.createPagamentoCartao(pagamento);
        return ResponseEntity.ok("Cobranca Realizada !");
    }

    @GetMapping("/listaPagamentosPix")
    @Operation(summary = "Lista Pagamentos Pix", description = "Lista Pagamentos Recebidos com a função de PIX")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<Map<String, Object>> listaPagamentoPix() throws Exception{
        return ResponseEntity.ok(service.listPix());
    }

    @GetMapping("/caixa")
    @Operation(summary = "Confere caixa", description = "Confere valor em caixa")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<Map<String, Object>> caixa() throws Exception{
        return ResponseEntity.ok(service.caixa());
    }


}
