package br.com.bancopan.api.model;

public class Endereco {
	
	private String endereco;
	private Long cep;
	
	public Endereco(Long cep, String endereco) {
		super();
		this.endereco = endereco;
		this.cep = cep;
	}
	
	public Endereco(){
		super();
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getCep() {
		return cep;
	}
	public void setCep(Long cep) {
		this.cep = cep;
	}

	
}
