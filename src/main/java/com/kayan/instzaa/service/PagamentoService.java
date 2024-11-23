package com.kayan.instzaa.service;
import br.com.efi.efisdk.exceptions.EfiPayException;
import com.kayan.instzaa.controller.dto.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.efi.efisdk.EfiPay;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Optional.of;


@Service
public class PagamentoService {
    @Value("${Efi.CLIENT_ID}")
    private String CLIENT_ID;
    @Value("${Efi.CLIENT_SECRET}")
    private String CLIENT_SECRET;
    @Value("${Efi.SANDBOX}")
    private boolean SANDBOX;
    @Value("${Efi.Cert}")
    private String certificado;

    public String getStatusPix(String txid) throws Exception {
        JSONObject options = new JSONObject();
        options.put("client_id", CLIENT_ID);
        options.put("client_secret", CLIENT_SECRET);
        options.put("certificate", certificado);
        options.put("sandbox", SANDBOX);

        EfiPay efi = new EfiPay(options);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("txid", txid);

        Map<String, Object> responseEFI = efi.call("pixDetailCharge", params, new HashMap<String, Object>());
        String status = (String) responseEFI.get("status");
        if (status.contains("CONCLUIDA")){
            return "Pagamento bem sucedido !";
        }else if(status.contains("ATIVA")){
            return "Pagamento em andamento...";
        }else{
            return "Ocorreu um problema no pagamento !";
        }
    }

    public PagamentoQrDTO createPagamento(PagamentoCriacaoDTO pagamento) throws Exception {
            JSONObject options = new JSONObject();
            options.put("client_id", CLIENT_ID);
            options.put("client_secret", CLIENT_SECRET);
            options.put("certificate", certificado);
            options.put("sandbox", SANDBOX);

            EfiPay efi = new EfiPay(options);

            System.out.println("Valor : " + pagamento.valor());

            //criando cobrança
            JSONObject cobranca = new JSONObject();
            cobranca.put("calendario", new JSONObject().put("expiracao", 7200));
            cobranca.put("devedor", new JSONObject().put("cpf", pagamento.cpf()).put("nome", pagamento.nome()));
            cobranca.put("valor", new JSONObject().put("original", pagamento.valor()));
            cobranca.put("chave", "da95d834-7335-449d-8b5f-d081d5bc1ff8");
            cobranca.put("solicitacaoPagador", "Serviço Realizado.");


            JSONObject responseEFI = efi.call("pixCreateImmediateCharge", new HashMap<>(), cobranca);

            JSONObject loc = (JSONObject) responseEFI.get("loc");
            String pix = responseEFI.getString("pixCopiaECola");
            Integer id = (Integer) loc.get("id");
            String txid = (String) responseEFI.get("txid");

            //pegando qrcode
            Map<String, String> paramsQr = new HashMap<String, String>();
            paramsQr.put("id", String.valueOf(id));
            JSONObject qr = new JSONObject();
            JSONObject responseQREFI = efi.call("pixGenerateQRCode", paramsQr, qr);
            String qrCode = responseQREFI.getString("imagemQrcode");

            return new PagamentoQrDTO(qrCode,pix, txid);
    }



    public PagamentoCartaoDadosDTO createPagamentoCartao(PagamentoCartaoDTO pagamento) throws Exception {
        JSONObject options = new JSONObject();
        options.put("client_id", CLIENT_ID);
        options.put("client_secret", CLIENT_SECRET);
        options.put("certificate", certificado);
        options.put("sandbox", SANDBOX);

        EfiPay efi = new EfiPay(options);

        System.out.println(pagamento.Nome());

        JSONArray listItem = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("name", "Produto Teste");
        item.put("amount", 1);
        item.put("value", Integer.parseInt(pagamento.Valor()));
        listItem.put(item);

        JSONObject cliente = new JSONObject();
        cliente.put("name", pagamento.Nome());
        cliente.put("cpf", pagamento.Cpf());
        cliente.put("phone_number", pagamento.Telefone());
        cliente.put("email", pagamento.Email());
        cliente.put("birth", pagamento.DataDeNascimento());


        JSONObject endereco = new JSONObject();
        endereco.put("street", pagamento.Rua());
        endereco.put("number", pagamento.NumeroEndereco());
        endereco.put("neighborhood", pagamento.Bairro());
        endereco.put("zipcode", pagamento.Cep());
        endereco.put("city", pagamento.Cidade());
        endereco.put("state", pagamento.Estado());

        JSONObject cartao = new JSONObject();
        cartao.put("installments", 1);
        cartao.put("billing_address", endereco);
        cartao.put("payment_token", pagamento.PaymentToken());
        cartao.put("customer", cliente);

        JSONObject pagamentoObj = new JSONObject();
        pagamentoObj.put("credit_card", cartao);

        JSONObject body = new JSONObject();
        body.put("payment", pagamentoObj);
        body.put("items", listItem);

        JSONObject responseEFI = efi.call("createOneStepCharge", new HashMap<>(), body);
        JSONObject data = responseEFI.getJSONObject("data");
        System.out.println(responseEFI);
        PagamentoCartaoDadosDTO result = new PagamentoCartaoDadosDTO((String) data.get("status"), (Integer) data.get("charge_id"));

        return result;

    }



    public Map<String, Object> listPix() throws Exception{
        String padrao = "yyyy-MM-dd";
        String hoje =new SimpleDateFormat(padrao).format(new Date());


        JSONObject options = new JSONObject();
        options.put("client_id", CLIENT_ID);
        options.put("client_secret", CLIENT_SECRET);
        options.put("certificate", certificado);
        options.put("sandbox", SANDBOX);

        EfiPay efi = new EfiPay(options);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("inicio", hoje + "T00:00:00Z");
        params.put("fim", hoje + "T23:59:30Z");

        Map<String, Object> response = efi.call("pixListCharges", params, new HashMap<String, Object>());


        return response;
    }
    public Map<String, Object> caixa() throws Exception{

        JSONObject options = new JSONObject();
        options.put("client_id", CLIENT_ID);
        options.put("client_secret", CLIENT_SECRET);
        options.put("certificate", certificado);
        options.put("sandbox", SANDBOX);

        EfiPay efi = new EfiPay(options);


        Map<String, Object> response = efi.call("getAccountBalance", new HashMap<String,String>(), new HashMap<String, Object>());


        return response;

    }
}
