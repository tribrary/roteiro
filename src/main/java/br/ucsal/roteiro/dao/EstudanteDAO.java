package br.ucsal.roteiro.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.ucsal.roteiro.model.Curso;
import br.ucsal.roteiro.model.Endereco;
import br.ucsal.roteiro.model.Estudante;
import br.ucsal.roteiro.model.Papel;
import br.ucsal.roteiro.model.Usuario;
import br.ucsal.roteiro.util.Conexao;

public class EstudanteDAO {
	private static Connection con = Conexao.getConnection();

	
	public static List<Estudante> listarEstudantes() {
		List<Estudante> estudantes = new ArrayList<>();

		try {
			String sql = "select * from estudantes;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				Integer idCurso= rs.getInt("id_curso");
				Integer idUsuario=rs.getInt("id_usuario");
				Curso c= CursoDAO.buscarCurso(idCurso);
				Usuario u = UsuarioDAO.buscarUsuario(idUsuario);		
				Estudante estudante = new Estudante(id, u, null, c);
				estudantes.add(estudante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return estudantes;
	}

	public static List<Usuario> buscarEstudantes() {
		List<Usuario> estudantes = new ArrayList<Usuario>();
		Usuario usuario;
		String sql = "select * from usuarios where id_papel=2;";
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
				estudantes.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estudantes;
	}
	
	public static Estudante buscarEstudante(Integer id) {
		Estudante estudante=null;

		try {
			String sql = "select * from estudantes where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				Integer idEstudante= rs.getInt("id");
				Integer idCurso= rs.getInt("id_curso");
				Integer idUsuario=rs.getInt("id_usuario");
				Curso c= CursoDAO.buscarCurso(idCurso);
				Usuario u = UsuarioDAO.buscarUsuario(idUsuario);		
				estudante = new Estudante(idEstudante, u, null, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return estudante;		
	}

	public static void inserirEstudante(Estudante estudante) {
		String sql = "insert into estudantes ( id_curso, id_usuario)  values(?,?);";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setInt(1, estudante.getCurso().getId());
			pstmt.setInt(2, estudante.getUsuario().getId()); 
			pstmt.execute();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			Integer id = -1;
			
			if(rs.next()) {
				id=rs.getInt("id");
			}
			estudante.setId(id);
			RoteiroEstudanteDAO.inserRoteiroEstudante(estudante);
			pstmt.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void EditarEstudante(Estudante estudante) {
		String sql ="update estudantes set id_curso=?, id_usuario=? where id=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, estudante.getCurso().getId());
			pstmt.setInt(2, estudante.getUsuario().getId());
			pstmt.setInt(3, estudante.getId());
			pstmt.executeUpdate();
			pstmt.close(); 
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		if(estudante.getRoteiros()!= null) {
			RoteiroEstudanteDAO.deletarPeloEstudante(estudante.getId());
			RoteiroEstudanteDAO.inserRoteiroEstudante(estudante);
		}
	
	}

	public static void deletarEstudantePeloUsuario(Integer id) {
		String sql="delete from estudantes where id_usuario=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Estudante buscarEstudantePeloUsuario(Integer idUser) {
		Estudante estudante=null;

		try {
			String sql = "select * from estudantes where id_usuario=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, idUser);
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				Integer idEstudante= rs.getInt("id");
				Integer idCurso= rs.getInt("id_curso");
				Integer idUsuario=rs.getInt("id_usuario");
				Curso c= CursoDAO.buscarCurso(idCurso);
				Usuario u = UsuarioDAO.buscarUsuario(idUsuario);		
				estudante = new Estudante(idEstudante, u, null, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return estudante;		
	}
	
	public static List<Estudante> buscarEstudantePeloCurso(Integer idC) {
		List<Estudante> estudantes = new ArrayList<>();

		try {
			String sql = "select * from estudantes where id_curso=?;";		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idC);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				Integer idCurso= rs.getInt("id_curso");
				Integer idUsuario=rs.getInt("id_usuario");
				Curso c= CursoDAO.buscarCurso(idCurso);
				Usuario u = UsuarioDAO.buscarUsuario(idUsuario);		
				Estudante estudante = new Estudante(id, u, null, c);
				estudantes.add(estudante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return estudantes;
	}

}
