package br.ucsal.roteiro.model;

public class Onibus {

	private Integer id;
	private String placa;
	private String detalhes;
	private String situacao;
	
	public Onibus() {
		super();
	}
	


	public Onibus(Integer id, String placa, String detalhes, String situacao) {
		super();
		this.id = id;
		this.placa = placa;
		this.detalhes = detalhes;
		this.situacao = situacao;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
