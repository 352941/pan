package br.com.bancopan.api.model;

public class Municipios {
	
	private Long id;
	private String nome;
	private Microrregiao microrregiao;

	public Municipios(Long id, String nome) {
		this.id = id;
		this.nome = nome;
		this.microrregiao = new Microrregiao();
	}
	
	public Municipios() {
		super();
		this.microrregiao = new Microrregiao();
	}
	
	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
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
