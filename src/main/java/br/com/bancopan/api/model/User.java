package br.com.bancopan.api.model;

public class User {
	
	private String nome;
	private Long cpf;
	private Long idade;
	private String estadoCivil;
	private String endereço;
	private Long numero;
	private Long telefone;
	
	
	public User(String nome, Long cpf, Long idade, String estadoCivil, String endereço, Long numero, Long telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.estadoCivil = estadoCivil;
		this.endereço = endereço;
		this.numero = numero;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public Long getIdade() {
		return idade;
	}
	public void setIdade(Long idade) {
		this.idade = idade;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	
}
