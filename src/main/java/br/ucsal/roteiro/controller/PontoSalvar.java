package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.PontoDAO;
import br.ucsal.roteiro.model.Ponto;

/**
 * Servlet implementation class PontoSalvar
 */
@WebServlet("/PontoSalvar")
public class PontoSalvar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PontoSalvar() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		String descricao = request.getParameter("descricao");
		String sX = request.getParameter("x");
		String sY = request.getParameter("y");
		long x = Long.parseLong(sX);
		long y = Long.parseLong(sY);
		Ponto ponto = new Ponto();
		
		if(sId != null && !sId.trim().isEmpty()) {
			int id = Integer.parseInt(sId);
			ponto.setId(id);
			ponto.setDescricao(descricao);
			ponto.setX(x);
			ponto.setY(y);
			PontoDAO.editarPonto(ponto);
		}else {
			ponto.setDescricao(descricao);
			ponto.setX(x);
			ponto.setY(y);
			PontoDAO.inserirPonto(ponto);
		}
		response.sendRedirect("PontoListar");
	}

}
