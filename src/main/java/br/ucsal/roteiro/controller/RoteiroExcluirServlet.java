package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.RoteiroDAO;

@WebServlet("/RoteiroExcluir")
public class RoteiroExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoteiroExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		Integer id = Integer.parseInt(sId);
		RoteiroDAO.excluirRoteiro(id);
		response.sendRedirect("./RoteiroListar");
	}


}
