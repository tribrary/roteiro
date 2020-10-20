package br.ucsal.roteiro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.CursoDAO;
import br.ucsal.roteiro.dao.InstituicaoDAO;
import br.ucsal.roteiro.model.Curso;
import br.ucsal.roteiro.model.Instituicao;

/**
 * Servlet implementation class CursoFormServlet
 */
@WebServlet("/CursoForm")
public class CursoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Curso curso = null;
		List<Instituicao> instituicoes  = InstituicaoDAO.listarInstituicoes();
		
		if(id!=null) {
			curso = CursoDAO.buscarCurso(Integer.parseInt(id));
		}
		request.setAttribute("curso", curso);
		request.setAttribute("instituicoes", instituicoes);
		request.getRequestDispatcher("cursoForm.jsp").forward(request, response);
	}



}
