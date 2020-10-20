package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.PontoDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;
import br.ucsal.roteiro.model.Ponto;
import br.ucsal.roteiro.model.Roteiro;

/**
 * Servlet implementation class RoteiroListaServlet
 */
@WebServlet("/RoteiroListar")
public class RoteiroListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoteiroListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Roteiro> roteiros = RoteiroDAO.listarRoteiros();
		List<Ponto> pontos = PontoDAO.listarPontos();
		
		request.setAttribute("pontos", pontos);
		request.setAttribute("roteiros", roteiros);
		request.getRequestDispatcher("roteiroLista.jsp").forward(request, response);
	}


}
