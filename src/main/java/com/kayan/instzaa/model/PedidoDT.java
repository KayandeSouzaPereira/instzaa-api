package com.kayan.instzaa.model;

import java.sql.Date;

public class PedidoDT {
	
	private Long idPedido;
	private String nomeCliente;
	private String cpf;
	private String endereco;
	private Date data;
	private String numeroContato;
	private Long valor;
	private String resumoPedido;
	private Long status;
	
	public PedidoDT() {}

	public PedidoDT(Long idPedido, String nomeCliente, String cpf, String endereco, Date data, String numeroContato,
			Long valor, String resumoPedido, Long status) {
		super();
		this.idPedido = idPedido;
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.endereco = endereco;
		this.data = data;
		this.numeroContato = numeroContato;
		this.valor = valor;
		this.resumoPedido = resumoPedido;
		this.status = status;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public String getResumoPedido() {
		return resumoPedido;
	}

	public void setResumoPedido(String resumoPedido) {
		this.resumoPedido = resumoPedido;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
	

}
