package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.EstudanteDAO;
import br.ucsal.roteiro.dao.RoteiroEstudanteDAO;
import br.ucsal.roteiro.dao.UsuarioDAO;

/**
 * Servlet implementation class EstudanteExcluir
 */
@WebServlet("/EstudanteExcluir")
public class EstudanteExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudanteExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer idEst = EstudanteDAO.buscarEstudantePeloUsuario(Integer.parseInt(id)).getId();
		RoteiroEstudanteDAO.deletarPeloEstudante(idEst);
		
		EstudanteDAO.deletarEstudantePeloUsuario(Integer.parseInt(id));
		UsuarioDAO.deletarUsuario(Integer.parseInt(id));
		
		request.getRequestDispatcher("EstudanteListar").forward(request, response);
	}

	

}
