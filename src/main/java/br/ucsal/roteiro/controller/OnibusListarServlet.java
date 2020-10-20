package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.OnibusDAO;
import br.ucsal.roteiro.model.Onibus;

/**
 * Servlet implementation class OnibusLista
 */
@WebServlet("/OnibusListar")
public class OnibusListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnibusListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Onibus> onibus = OnibusDAO.listarOnibus();	
		request.setAttribute("onibus", onibus);
		request.getRequestDispatcher("onibusLista.jsp").forward(request, response);
	}



}
