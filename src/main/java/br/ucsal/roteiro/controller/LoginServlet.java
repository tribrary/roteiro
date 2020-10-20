package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.UsuarioDAO;
import br.ucsal.roteiro.model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		Usuario usuarioLogado = UsuarioDAO.autenticarUsuario(usuario);
	
		if(usuarioLogado != null) {
			request.getSession().setAttribute("usuario", usuario);
			if(usuario.getPapel().getId()==2) //adm
				request.getRequestDispatcher("dashboardEstudante.jsp").forward(request, response);;
			if(usuario.getPapel().getId()==1) {
				request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);;
				
			}
		}else {
			request.setAttribute("erro", "E-mail ou senha inválido!");
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
	}

}
