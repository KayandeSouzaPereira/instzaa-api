package com.kayan.instzaa.model;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "Instzaa_Cardapio")
public class CardapioItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCardapio")
	private Long idCardapio;
	
	@Column(name = "Nome")
	private String Nome;
	
	@Column(name = "Descricao")
	private String Descricao;
	
	@Column(name="Imagem")
	private String Imagem;
	
	@Column(name="Preco")
	private Long Preco;
	
	@Column(name="Categoria")
	private String Categoria;
	
	@Column(name="Destaque")
	private Long Destaque;
	
	@Column(name="Promocao")
	private Long Promocao;

	public Long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getImagem() {
		return Imagem;
	}

	public void setImagem(String imagem) {
		Imagem = imagem;
	}

	public Long getPreco() {
		return Preco;
	}

	public void setPreco(Long preco) {
		Preco = preco;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public Long getDestaque() {
		return Destaque;
	}

	public void setDestaque(Long destaque) {
		Destaque = destaque;
	}

	public Long getPromocao() {
		return Promocao;
	}

	public void setPromocao(Long promocao) {
		Promocao = promocao;
	}
	
	
	
	
	

}
