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
 * Servlet implementation class MotoristaFormServlet
 */
@WebServlet("/MotoristaForm")
public class MotoristaFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotoristaFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Motorista motorista = null;
		String situacao = request.getParameter("situacao");
		if(id!=null) {
			motorista = MotoristaDAO.buscarMotorista(Integer.parseInt(id));
		}
		if(situacao != null && situacao.equals("demitir")) {
			motorista.setSituacao("Demitido");
			MotoristaDAO.editarMotorista(motorista);
			response.sendRedirect("./MotoristaListar");
		}else {
		request.setAttribute("motorista", motorista);
		request.getRequestDispatcher("motoristaForm.jsp").forward(request, response);
		}
	}


}
