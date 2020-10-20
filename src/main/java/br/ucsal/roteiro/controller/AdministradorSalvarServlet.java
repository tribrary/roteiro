package br.ucsal.roteiro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.roteiro.dao.EnderecoDAO;
import br.ucsal.roteiro.dao.PapelDAO;
import br.ucsal.roteiro.dao.UsuarioDAO;
import br.ucsal.roteiro.model.Endereco;
import br.ucsal.roteiro.model.Papel;
import br.ucsal.roteiro.model.Usuario;


@WebServlet("/AdministradorSalvar")
public class AdministradorSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdministradorSalvarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUserS= request.getParameter("id");

	
		String nome = request.getParameter("nome");
		String nomeSocial = request.getParameter("nomeSocial");
		String email = request.getParameter("email"); 
		String cpf=request.getParameter("cpf");
		String senha= request.getParameter("senha");

		String bairro =request.getParameter("bairro");
		String cep=request.getParameter("cep");
		String cidade=request.getParameter("cidade");
		String rua=request.getParameter("rua");
		String numero=request.getParameter("numero");
		Papel p=PapelDAO.buscarPapel(1);
		
		if(idUserS== null || idUserS.trim().isEmpty()) {
			
			Endereco endereco = new Endereco();
			endereco.setBairro(bairro);
			endereco.setCep(cep);
			endereco.setCidade(cidade);
			endereco.setRua(rua);
			endereco.setNumero(numero);

			Usuario usuario = new Usuario(null, nome, nomeSocial, email, cpf, senha, endereco, p);
			endereco.setUsuario(usuario);
			EnderecoDAO.inserirEndereco(endereco);
		}else {
			Usuario usuario = UsuarioDAO.buscarUsuario(Integer.parseInt(idUserS));
			usuario.setNome(nome);
			usuario.setNomeSocial(nomeSocial);
			usuario.setEmail(email); 
			usuario.setCpf(cpf);
			usuario.setSenha(senha);
			
			Endereco endereco = EnderecoDAO.buscarEndereco(usuario.getEndereco().getId());
			endereco.setBairro(bairro);
			endereco.setCep(cep);
			endereco.setCidade(cidade);
			endereco.setRua(rua);
			endereco.setNumero(numero);
			usuario.setEndereco(endereco);
			UsuarioDAO.EditarUsuario(usuario);
		}
		response.sendRedirect("./AdministradorListar");
	}

}
