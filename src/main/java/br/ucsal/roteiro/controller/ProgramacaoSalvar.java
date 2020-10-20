package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.MotoristaDAO;
import br.ucsal.roteiro.dao.OnibusDAO;
import br.ucsal.roteiro.dao.ProgramacaoDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;
import br.ucsal.roteiro.model.Motorista;
import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.model.Programacao;
import br.ucsal.roteiro.model.Roteiro;




/**
 * Servlet implementation class ProgramacaoSlavar
 */
@WebServlet("/ProgramacaoSalvar")
public class ProgramacaoSalvar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProgramacaoSalvar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm:ss");

		String sDia = request.getParameter("dia");
		System.out.println(sDia);
		String sHoraIda = request.getParameter("horaIda")+":00"; //gambiarrazada!
		String sHoraVolta = request.getParameter("horaVolta")+":00";

		String sIdOnibus = request.getParameter("onibus");
		String sIdRoteiro = request.getParameter("roteiro");
		String sIdmotorista = request.getParameter("motorista");

		LocalDate dia = LocalDate.parse(sDia, dateFormat);
		LocalTime horaIda = LocalTime.parse(sHoraIda, timeFormat);
		LocalTime horaVolta = LocalTime.parse(sHoraVolta, timeFormat);

		Onibus onibus = OnibusDAO.buscarOnibus(Integer.parseInt(sIdOnibus));
		Motorista motorista = MotoristaDAO.buscarMotorista(Integer.parseInt(sIdmotorista));
		Roteiro roteiro = RoteiroDAO.obterRoteiro(Integer.parseInt(sIdRoteiro));
		Programacao programacao =null;

		if(id != null && !id.trim().isEmpty()) {
			programacao= ProgramacaoDAO.buscarProgramacao(Integer.parseInt(id));
			programacao.setDia(dia);
			programacao.setHoraIda(horaIda);
			programacao.setHoraVolta(horaVolta);
			programacao.setMotorista(motorista);
			programacao.setOnibus(onibus);
			programacao.setRoteiro(roteiro);
			ProgramacaoDAO.editarProgramacao(programacao);
		}else {
			programacao = new Programacao();
			programacao.setDia(dia);
			programacao.setHoraIda(horaIda);
			programacao.setHoraVolta(horaVolta);
			programacao.setMotorista(motorista);
			programacao.setOnibus(onibus);
			programacao.setRoteiro(roteiro);

			ProgramacaoDAO.inserirProgramacao(programacao);
		}
		response.sendRedirect("./ProgramacaoListar");



	}


}
