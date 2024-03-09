package com.kayan.instzaa.model;

public class CardapioItemDT {
	
	private Long idCardapio;
	private String Nome;
	private String Descricao;
	private String Imagem;
	private Long Preco;
	private String Categoria;
	private Boolean Destaque;
	private Boolean Promocao;
	
	public CardapioItemDT() {}

	public CardapioItemDT(Long idCardapio, String nome, String descricao, String imagem, Long preco, String categoria,
		Boolean destaque, Boolean promocao) {
		this.idCardapio = idCardapio;
		this.Nome = nome;
		this.Descricao = descricao;
		this.Imagem = imagem;
		this.Preco = preco;
		this.Categoria = categoria;
		this.Destaque = destaque;
		this.Promocao = promocao;
	}

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

	public Boolean getDestaque() {
		return Destaque;
	}

	public void setDestaque(Boolean destaque) {
		Destaque = destaque;
	}

	public Boolean getPromocao() {
		return Promocao;
	}

	public void setPromocao(Boolean promocao) {
		Promocao = promocao;
	}
	
	
	
	

}
