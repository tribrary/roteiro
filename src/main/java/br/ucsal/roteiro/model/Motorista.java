package br.ucsal.roteiro.model;

public class Motorista {
	
	private Integer id;
	private String nome;
	private String descricao;
	private String situacao;
	
	
	
	public Motorista() {
		super();
	}
	
	public Motorista(Integer id, String nome, String descricao, String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.situacao = situacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
