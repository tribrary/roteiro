package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.PontoDAO;
import br.ucsal.roteiro.dao.RoteiroDAO;
import br.ucsal.roteiro.dao.RoteiroPontoDAO;
import br.ucsal.roteiro.model.Roteiro;

@WebServlet("/RoteiroForm")
public class RoteiroFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoteiroFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Roteiro roteiro = null;
		if(id != null) {
			roteiro = RoteiroDAO.obterRoteiro(Integer.parseInt(id));
			request.setAttribute("pontosCadastrados",RoteiroPontoDAO.buscarPontoDoRoteiro(Integer.parseInt(id)));
			
		}
		request.setAttribute("pontos", PontoDAO.listarPontos());
		request.setAttribute("roteiro", roteiro);
		request.getRequestDispatcher("roteiroForm.jsp").forward(request, response);
	}
}
