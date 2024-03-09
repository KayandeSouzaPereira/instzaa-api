package com.kayan.instzaa.model;

import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "Instzaa_Pedido")
public class Pedido implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private Long idPedido;
	
	@Column(name = "NomeCliente")
	private String nomeCliente;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "Endereco")
	private String endereco;
	
	@Column(name = "Data")
	private Date data;
	
	@Column(name = "NumeroContato")
	private String numeroContato;
	
	@Column(name = "valor")
	private Long valor;
	
	
	@Column(name = "ResumoPedido")
	private String resumoPedido;
	
	@Column(name = "Status")
	private Long Status;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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
		return Status;
	}

	public void setStatus(Long status) {
		Status = status;
	}
	
	
	

}
