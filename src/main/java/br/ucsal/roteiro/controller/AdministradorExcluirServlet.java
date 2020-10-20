package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.UsuarioDAO;

/**
 * Servlet implementation class AdministradorExcluirServlet
 */
@WebServlet("/AdministradorExcluir")
public class AdministradorExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdministradorExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		UsuarioDAO.deletarUsuario(Integer.parseInt(idS));
		request.getRequestDispatcher("AdministradorListar").forward(request, response);
	}

	
}
