package com.kayan.instzaa.service;
import com.kayan.instzaa.controller.dto.PagamentoCartaoDTO;
import com.kayan.instzaa.controller.dto.PagamentoCriacaoDTO;
import com.kayan.instzaa.controller.dto.PagamentoQrDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.efi.efisdk.EfiPay;

import java.util.HashMap;
import java.util.Map;


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



    public PagamentoQrDTO createPagamento(PagamentoCriacaoDTO pagamento) throws Exception {
            JSONObject options = new JSONObject();
            options.put("client_id", CLIENT_ID);
            options.put("client_secret", CLIENT_SECRET);
            options.put("certificate", certificado);
            options.put("sandbox", SANDBOX);

            EfiPay efi = new EfiPay(options);

            //criando cobrança
            JSONObject cobranca = new JSONObject();
            cobranca.put("calendario", new JSONObject().put("expiracao", 3600));
            cobranca.put("devedor", new JSONObject().put("cpf", pagamento.CPF()).put("nome", pagamento.Nome()));
            cobranca.put("valor", new JSONObject().put("original", String.valueOf(pagamento.Valor())));
            cobranca.put("chave", "da95d834-7335-449d-8b5f-d081d5bc1ff8");
            cobranca.put("solicitacaoPagador", "Serviço Realizado.");


            JSONObject responseEFI = efi.call("pixCreateImmediateCharge", new HashMap<>(), cobranca);

            JSONObject loc = (JSONObject) responseEFI.get("loc");
            String pix = responseEFI.getString("pixCopiaECola");
            Integer id = (Integer) loc.get("id");

            //pegando qrcode
            Map<String, String> paramsQr = new HashMap<String, String>();
            paramsQr.put("id", String.valueOf(id));
            JSONObject qr = new JSONObject();
            JSONObject responseQREFI = efi.call("pixGenerateQRCode", paramsQr, qr);
            String qrCode = responseQREFI.getString("imagemQrcode");

            return new PagamentoQrDTO(qrCode,pix);
    }

    public boolean createPagamentoCartao(PagamentoCartaoDTO pagamento) throws Exception {
        JSONObject options = new JSONObject();
        options.put("client_id", CLIENT_ID);
        options.put("client_secret", CLIENT_SECRET);
        options.put("certificate", "./certs/homologacao-571485-Instzaa-HML.p12");
        options.put("sandbox", true);

        EfiPay efi = new EfiPay(options);

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

        efi.call("createOneStepCharge", new HashMap<>(), body);
        return true;

    }
}
