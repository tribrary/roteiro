package br.ucsal.roteiro.model;

import java.util.List;

public class Estudante {

	private Integer id;
	private Usuario usuario;
	private List<Roteiro> roteiros;
	private Curso curso;
	
	public Estudante() {
		super();
	}

	public Estudante(Integer id, Usuario usuario, List<Roteiro> roteiros, Curso curso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.roteiros = roteiros;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Roteiro> getRoteiros() {
		return roteiros;
	}

	public void setRoteiros(List<Roteiro> roteiros) {
		this.roteiros = roteiros;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
