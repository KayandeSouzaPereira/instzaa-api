package com.kayan.instzaa.controller;


import com.kayan.instzaa.controller.dto.PagamentoCartaoDTO;
import com.kayan.instzaa.controller.dto.PagamentoCriacaoDTO;
import com.kayan.instzaa.controller.dto.PagamentoQrDTO;
import com.kayan.instzaa.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/criarPagamento")
    @Operation(summary = "Criando Pagamento PIX", description = "Criando uma cobrança de pagamento com QR PIX")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<PagamentoQrDTO> criarPagamento(PagamentoCriacaoDTO pagamento) throws Exception{
        return ResponseEntity.ok(service.createPagamento(pagamento));
    }
    @PostMapping("/criarPagamentoCartao")
    @Operation(summary = "Criando Pagamento Cartão", description = "Criando uma cobrança de pagamento com Cartão de Credito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida !"),
            @ApiResponse(responseCode = "500", description = "Erro na transação."),
            @ApiResponse(responseCode = "403", description = "Requisição não autorizada.")
    })
    public ResponseEntity<String> criarPagamentoCartao(PagamentoCartaoDTO pagamento) throws Exception{
        service.createPagamentoCartao(pagamento);
        return ResponseEntity.ok("Cobrança Realizada !");
    }


}
