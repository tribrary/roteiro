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
 * Servlet implementation class PontoForm
 */
@WebServlet("/PontoForm")
public class PontoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PontoForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		Ponto ponto = null;
		
		if(sId!=null) {
			ponto = PontoDAO.obterPonto(Integer.parseInt(sId));
		}
		
		request.setAttribute("ponto", ponto);
		request.getRequestDispatcher("pontoForm.jsp").forward(request, response);;
	}

	

}
