package br.ucsal.roteiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.MotoristaDAO;
import br.ucsal.roteiro.dao.OnibusDAO;
import br.ucsal.roteiro.model.Onibus;

/**
 * Servlet implementation class OnibusFormServlet
 */
@WebServlet("/OnibusForm")
public class OnibusFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnibusFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Onibus onibus = null;
		
		String situacao = request.getParameter("situacao");
		System.out.println(situacao+" "+id);
		if(id!=null) {
			onibus = OnibusDAO.buscarOnibus(Integer.parseInt(id));
		}
		if(situacao != null && situacao.equals("desabilitado")) {
			onibus.setSituacao("Desabilitado");
			OnibusDAO.editarOnibus(onibus);
			response.sendRedirect("./OnibusListar");
		}else {
		request.setAttribute("onibus", onibus);
		request.getRequestDispatcher("onibusForm.jsp").forward(request, response);
		}
	}


}
