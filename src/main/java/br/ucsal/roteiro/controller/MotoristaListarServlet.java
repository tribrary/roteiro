package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.MotoristaDAO;
import br.ucsal.roteiro.model.Motorista;

/**
 * Servlet implementation class MotoristaListaServlet
 */
@WebServlet("/MotoristaListar")
public class MotoristaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotoristaListarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Motorista> motoristas = MotoristaDAO.listarMotoristas();
		request.setAttribute("motoristas", motoristas);
		request.getRequestDispatcher("motoristaLista.jsp").forward(request, response);
	}

	
}
