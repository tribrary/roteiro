package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.MotoristaDAO;
import br.ucsal.roteiro.model.Motorista;

/**
 * Servlet implementation class MotoristaSalvarServlet
 */
@WebServlet("/MotoristaSalvar")
public class MotoristaSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotoristaSalvarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Motorista motorista = new Motorista();
		
		String id = request.getParameter("id"); //hidden
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String situacao = request.getParameter("situacao");
		
		
		if(id != null && !id.trim().isEmpty() ) {
			motorista.setId(Integer.parseInt(id));
			motorista.setNome(nome);
			motorista.setDescricao(descricao);
			motorista.setSituacao(situacao);
			MotoristaDAO.editarMotorista(motorista);
		}else {
			motorista.setNome(nome);
			motorista.setDescricao(descricao);
			motorista.setSituacao(situacao);
			MotoristaDAO.inserirMotorista(motorista);
		}
		
		response.sendRedirect("./MotoristaListar");
	}

	

}
