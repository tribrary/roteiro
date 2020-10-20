package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.ProgramacaoDAO;

/**
 * Servlet implementation class ProgramacaoExcluir
 */
@WebServlet("/ProgramacaoExcluir")
public class ProgramacaoExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramacaoExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		ProgramacaoDAO.removerProgramacao(id);
		response.sendRedirect("./ProgramacaoListar");
	}



}
