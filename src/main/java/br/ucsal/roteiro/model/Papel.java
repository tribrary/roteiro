package br.ucsal.roteiro.model;

public class Papel {
	
	private Integer id;
	private String codigo;
	private String descricao;
	
	public Papel() {
		super();
	}
	
	public Papel(Integer id, String codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
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
	
	
}
