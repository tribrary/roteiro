package br.ucsal.roteiro.model;

import java.util.List;

public class Instituicao {

	private Integer id;
	private String nome;
	private Endereco endereco;
	private List<Curso> cursos;
	
	public Instituicao() {
		super();
	}
	
	public Instituicao(Integer id, String nome, Endereco endereco, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cursos = cursos;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
