package br.com.bancopan.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mesorregiao {

	private Long id;
	private String nome;
	private Uf uf;
	
	public Mesorregiao() {
		super();
		this.uf = new Uf();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@JsonProperty("UF") 
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(Uf uf) {
		this.uf = uf;
	}	
	
}
