package br.com.bancopan.api.model;

public class User {
	
	private String nome;
	private Long cpf;
	private Long idade;
	private String estadoCivil;
	private String endereco;
	private Long numero;
	private Long telefone;
	
	
	public User(String nome, Long cpf, Long idade, String estadoCivil, String endereco, Long numero, Long telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
		this.numero = numero;
		this.telefone = telefone;
	}
	
	public User(){
		super();
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
		return endereco;
	}
	public void setEndereço(String endereco) {
		this.endereco = endereco;
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
