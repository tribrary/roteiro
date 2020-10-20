package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.PontoDAO;
import br.ucsal.roteiro.model.Ponto;

/**
 * Servlet implementation class PontoListar
 */
@WebServlet("/PontoListar")
public class PontoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PontoListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ponto> pontos = null;
		String sId = request.getParameter("idRoteiro");
		if(sId!=null) {
			pontos = PontoDAO.listarPontosPorRoteiro(Integer.parseInt(sId));
		}else {
			pontos = PontoDAO.listarPontos();
			
		}
		//int id = Integer.parseInt(sId);
		request.setAttribute("idRoteiro", sId);//setando o atributo pra poder ocultar o link novo ponto
		request.setAttribute("pontos", pontos);
		request.getRequestDispatcher("pontoLista.jsp").forward(request, response);
	}

}
