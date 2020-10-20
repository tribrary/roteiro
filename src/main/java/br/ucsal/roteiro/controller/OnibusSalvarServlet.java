package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.OnibusDAO;
import br.ucsal.roteiro.model.Onibus;

/**
 * Servlet implementation class OnibusSalvarServlet
 */
@WebServlet("/OnibusSalvar")
public class OnibusSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnibusSalvarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Onibus onibus = new Onibus();
		
		String id = request.getParameter("id"); //hidden
		String placa = request.getParameter("placa");
		String detalhes = request.getParameter("detalhes");
		String situacao = request.getParameter("situacao");
		
		if(id != null && !id.trim().isEmpty() ) {
			onibus.setDetalhes(detalhes);
			onibus.setId(Integer.parseInt(id));
			onibus.setPlaca(placa);
			onibus.setSituacao(situacao);
			OnibusDAO.editarOnibus(onibus);
		}else {
			onibus.setDetalhes(detalhes);
			onibus.setPlaca(placa);
			onibus.setSituacao(situacao);
			OnibusDAO.inserirOnibus(onibus);
		}
		
		response.sendRedirect("./OnibusListar");
		
	}

}
