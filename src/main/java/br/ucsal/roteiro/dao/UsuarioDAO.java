package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Endereco;
import br.ucsal.roteiro.model.Papel;
import br.ucsal.roteiro.model.Usuario;
import br.ucsal.roteiro.util.Conexao;

public class UsuarioDAO {
	private static Connection con = Conexao.getConnection();

	public static Usuario autenticarUsuario(Usuario user) {
		boolean autenticado = false;
		try {
			String sql = "select * from usuarios where email=? and senha=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getSenha());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				//TODO: colocar todas as informações do usuario
				autenticado = true;
				user.setId(Integer.parseInt(rs.getString(1)));
				user.setNome(rs.getString(2));
				Papel papel = PapelDAO.buscarPapel(Integer.parseInt(rs.getString(8)));
				user.setPapel(papel);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		if(autenticado /*== true*/) {
			return user;
		}else {
			return null;
		}
	}

	public static List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String sql = "select * from usuarios;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Integer id= rs.getInt("id");
				String nome= rs.getString("nome");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String senha = rs.getString("senha");
				Integer idEndereco = rs.getInt("id_endereco");
				Integer idPapel = rs.getInt("id_papel");
				Papel p = PapelDAO.buscarPapel(idPapel);
				Endereco e =EnderecoDAO.obterPonto(idEndereco);
				Usuario usuario = new Usuario(id, nome, nomeSocial, email, cpf, senha, e, p);
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}


	public static Usuario buscarUsuario(Integer id) {
		Usuario usuario = null;	

		try {
			String sql = "select * from usuarios where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				Integer idUser= rs.getInt("id");
				String nome= rs.getString("nome");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String senha =rs.getString("senha");
				Integer idEndereco = rs.getInt("id_endereco");
				Integer idPapel = rs.getInt("id_papel");
				Papel p = PapelDAO.buscarPapel(idPapel);
				Endereco e = EnderecoDAO.buscarEndereco(idEndereco);
				usuario = new Usuario(idUser, nome, nomeSocial, email, cpf, senha, e, p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;

	}

	public static void inserirUsuario(Usuario usuario) {
		try {
			String sql="insert into usuarios (nome, nome_social, email, cpf, senha, id_endereco, id_papel) values(?,?,?,?,?,?,?);";
			PreparedStatement pstmt= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getNomeSocial());
			pstmt.setString(3, usuario.getEmail());
			pstmt.setString(4, usuario.getCpf());
			pstmt.setString(5, usuario.getSenha());
			pstmt.setInt(6, usuario.getEndereco().getId());
			pstmt.setInt(7, usuario.getPapel().getId());
			pstmt.execute();
			
			if (usuario.getEstudante()!=null) {
				ResultSet rs = pstmt.getGeneratedKeys();
				Integer id = -1;
				
				if(rs.next()) {
					id=rs.getInt("id");
				}
				usuario.getEstudante().getUsuario().setId(id);
				EstudanteDAO.inserirEstudante(usuario.getEstudante());
				
			}
			
			pstmt.close();
		} catch (SQLException e ) {
			e.printStackTrace(); 
		}
	}

	public static void EditarUsuario(Usuario usuario) {
		String sql="update usuarios set nome=?, nome_social=?, email=?, cpf=?, senha=?, id_endereco=?, id_papel=? where id=?;";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getNomeSocial());
			pstmt.setString(3, usuario.getEmail());
			pstmt.setString(4, usuario.getCpf());
			pstmt.setString(5, usuario.getSenha());
			pstmt.setInt(6, usuario.getEndereco().getId());
			pstmt.setInt(7, usuario.getPapel().getId());
			pstmt.setInt(8, usuario.getId());
			pstmt.executeUpdate();
			pstmt.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(usuario.getEstudante()!= null){
			EstudanteDAO.EditarEstudante(usuario.getEstudante());
		}
		if(usuario.getEndereco()!= null) {
			EnderecoDAO.editarEndereco(usuario.getEndereco());
		}
		
	}

	public static void deletarUsuario(Integer id) {
		Integer idEnd=UsuarioDAO.buscarUsuario(id).getEndereco().getId();
		String sql = "delete from usuarios where id=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		EnderecoDAO.deletarEndereco(idEnd);
	}
	
	public static List<Usuario> listarAdministradores() {
		List<Usuario> administradores = new ArrayList<Usuario>();
		Usuario usuario;
		String sql = "select * from usuarios where id_papel=1;";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Integer idUser= rs.getInt("id");
				String nome= rs.getString("nome");
				String nomeSocial = rs.getString("nome_social");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String senha =rs.getString("senha");
				Integer idEndereco = rs.getInt("id_endereco");
				Integer idPapel = rs.getInt("id_papel");
				Papel p = PapelDAO.buscarPapel(idPapel);
				Endereco e = EnderecoDAO.obterPonto(idEndereco);
				usuario = new Usuario(idUser, nome, nomeSocial, email, cpf, senha, e, p);
				administradores.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return administradores;
	}
}
