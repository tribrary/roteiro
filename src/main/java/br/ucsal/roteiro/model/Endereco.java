package br.ucsal.roteiro.model;

public class Endereco {

	private Integer id;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	private Usuario usuario;
	private Instituicao instituicao;
		
	public Endereco() {
		super();
	}

	public Endereco(Integer id, String cidade, String cep, String bairro, String rua, String numero) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
