package br.ucsal.roteiro.model;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String nomeSocial;
	private String email;
	private String cpf;
	private String senha;
	private Endereco endereco;
	private Papel papel;
	private Estudante estudante;
	


	public Usuario() {
		super();
	}


	public Usuario(Integer id, String nome, String nomeSocial, String email, String cpf, String senha,
			Endereco endereco, Papel papel) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
		this.papel = papel;
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
	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}
	

	public Estudante getEstudante() {
		return estudante;
	}


	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
}
