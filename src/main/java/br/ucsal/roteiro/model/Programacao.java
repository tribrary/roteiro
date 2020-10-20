package br.ucsal.roteiro.model;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;

public class Programacao {

	private Integer id;
	private Roteiro roteiro;
	private LocalDate dia;
	private Onibus onibus;
	private LocalTime horaIda;
	private LocalTime horaVolta;
	private Motorista motorista;
//	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
	public Programacao() {
		super();
	}
	
	public Programacao(Integer id, Roteiro roteiro, LocalDate dia, Onibus onibus, LocalTime horaIda,
			LocalTime horaVolta, Motorista motorista) {
		super();
		this.id = id;
		this.roteiro = roteiro;
		this.dia = dia;
		this.onibus = onibus;
		this.horaIda = horaIda;
		this.horaVolta = horaVolta;
		this.motorista = motorista;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Roteiro getRoteiro() {
		return roteiro;
	}
	public void setRoteiro(Roteiro roteiro) {
		this.roteiro = roteiro;
	}
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	public LocalTime getHoraIda() {
		return horaIda;
	}
	public void setHoraIda(LocalTime horaIda) {
		this.horaIda = horaIda;
	}
	public LocalTime getHoraVolta() {
		return horaVolta;
	}
	public void setHoraVolta(LocalTime horaVolta) {
		this.horaVolta = horaVolta;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
}
