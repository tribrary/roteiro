package br.ucsal.roteiro.model;

import java.util.List;

public class Roteiro {

	private Integer id;
	private String codigo;
	private String descricao;
	private String tipo;
	private List<Ponto> pontos;
	
	public Roteiro() {
		super();
	}
	
	

	public Roteiro(Integer id, String codigo, String descricao, String tipo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		this.pontos = pontos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
