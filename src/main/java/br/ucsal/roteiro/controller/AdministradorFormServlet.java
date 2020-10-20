package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.UsuarioDAO;
import br.ucsal.roteiro.model.Usuario;

/**
 * Servlet implementation class AdministradorForm
 */
@WebServlet("/AdministradorForm")
public class AdministradorFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS=request.getParameter("id");
		Usuario usuario=null;
		if(idS!= null) {
			usuario= UsuarioDAO.buscarUsuario(Integer.parseInt(idS)); 
		}
		request.setAttribute("adm", usuario);
		request.getRequestDispatcher("administradorForm.jsp").forward(request, response);
	}

	

}
