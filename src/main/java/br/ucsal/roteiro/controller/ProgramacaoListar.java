package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.ProgramacaoDAO;
import br.ucsal.roteiro.model.Programacao;

/**
 * Servlet implementation class ProgramacaoLista
 */
@WebServlet("/ProgramacaoListar")
public class ProgramacaoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramacaoListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Programacao> programacoes = ProgramacaoDAO.listarProgramacoes();
		request.setAttribute("programacoes", programacoes);
		request.getRequestDispatcher("programacaoLista.jsp").forward(request, response);
	}

}
