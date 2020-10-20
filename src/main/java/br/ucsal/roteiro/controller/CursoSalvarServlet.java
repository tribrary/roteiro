package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.CursoDAO;
import br.ucsal.roteiro.dao.InstituicaoDAO;
import br.ucsal.roteiro.model.Curso;

/**
 * Servlet implementation class CursoSalvarServlet
 */
@WebServlet("/CursoSalvar")
public class CursoSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoSalvarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Curso curso = new Curso();
		
		String id = request.getParameter("id"); //hidden
		String instituicao = request.getParameter("instituicao");
		String nome = request.getParameter("nome");
		String duracao = request.getParameter("duracao");
		
		
		if(id != null && !id.trim().isEmpty() ) {
			curso.setId(Integer.parseInt(id));
			curso.setInstituicao(InstituicaoDAO.buscarInstituicao(Integer.parseInt(instituicao)));
			curso.setNome(nome);
			curso.setDuracao(Integer.parseInt(duracao));
			CursoDAO.editarCurso(curso);
		}else {
			
			
			curso.setInstituicao(InstituicaoDAO.buscarInstituicao(Integer.parseInt(instituicao)));
			curso.setNome(nome);
			curso.setDuracao(Integer.parseInt(duracao));
			CursoDAO.inserirCurso(curso);
		}
		
		response.sendRedirect("./CursoListar");
		
	}

	


}
