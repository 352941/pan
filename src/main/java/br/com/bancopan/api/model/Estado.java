package br.com.bancopan.api.model;

public class Estado {
	
	private Long id;
	private String nome;
	private String sigla;
	private Regiao regiao;

	public Estado(Long id, String nome) {
		this.id = id;
		this.nome = nome;
		this.regiao = new Regiao();
	}
	
	public Estado() {
		super();
		this.regiao = new Regiao();
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
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
	
}
