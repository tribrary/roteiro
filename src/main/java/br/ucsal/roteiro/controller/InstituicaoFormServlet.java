package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.ucsal.roteiro.dao.InstituicaoDAO;


@WebServlet("/InstituicaoForm")
public class InstituicaoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InstituicaoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS= request.getParameter("id");
		request.setAttribute("instituicao", InstituicaoDAO.buscarInstituicao(Integer.parseInt(idS)));
		request.getRequestDispatcher("instituicaoForm.jsp").forward(request, response);
	}


	

}
