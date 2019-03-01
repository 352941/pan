package br.com.bancopan.api.model;

public class Microrregiao {
	
	private Long id;
	private String nome;
	private Mesorregiao mesorregiao;
	
	public Microrregiao(Long id, String nome) {
		this.id = id;
		this.nome = nome;
		this.mesorregiao = new Mesorregiao();
	}
	
	public Microrregiao() {
		super();
		this.mesorregiao = new Mesorregiao();
	}
	
	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
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
