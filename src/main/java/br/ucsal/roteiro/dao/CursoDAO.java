package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.ucsal.roteiro.model.Curso;
import br.ucsal.roteiro.model.Estudante;
import br.ucsal.roteiro.model.Instituicao;
import br.ucsal.roteiro.util.Conexao;

public class CursoDAO {
	private static Connection con = Conexao.getConnection();

	public static List<Curso> listarCursos() {
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			String sql = "SELECT * from cursos ;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				int duracao = Integer.parseInt(rs.getString(3));
				Instituicao instituicao = InstituicaoDAO.buscarInstituicao(Integer.parseInt(rs.getString(4)));
				List<Estudante> estudantes = EstudanteDAO.buscarEstudantePeloCurso(id);
				Curso curso = new Curso();
				curso.setDuracao(duracao);
				curso.setId(id);
				curso.setNome(nome);
				curso.setInstituicao(instituicao);
				curso.setEstudantes(estudantes);
				cursos.add(curso);

			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	public static Curso buscarCurso(int idCurso) {
		Connection c = Conexao.getConnection();
		Curso curso = null;
		try {
			String sql = "select * from cursos where id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, idCurso);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				int duracao = Integer.parseInt(rs.getString(3));
				Instituicao instituicao = InstituicaoDAO.buscarInstituicao(Integer.parseInt(rs.getString(4)));
				curso = new Curso(id, instituicao, nome, duracao);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return curso;
	}

	// COLOQUEI ESSA FUNÇÃO PQ PRECISAVA PRA PARTE DE INSTITUIÇÃO
	public static List<Curso> buscarCursoDaInstituicao(Integer idInstituicao) {
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			String sql = "select * from cursos where id_instituicao=?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idInstituicao);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				Integer duracao = rs.getInt("duracao");
					
				Curso curso = new Curso();
				curso.setId(id);
				curso.setNome(nome);
				curso.setDuracao(duracao);
				cursos.add(curso);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	public static void inserirCurso(Curso curso) {
		try {
			String sql = "insert into cursos (nome, duracao, id_instituicao) values (?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, curso.getNome());
			pstmt.setInt(2, curso.getDuracao());
			pstmt.setInt(3, curso.getInstituicao().getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void editarCurso(Curso curso) {
		try {
			String sql = "UPDATE cursos " + "set nome=?, duracao = ?, id_instituicao = ? " + "where id = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, curso.getNome());
			pstmt.setInt(2, curso.getDuracao());
			pstmt.setInt(3, curso.getInstituicao().getId());
			pstmt.setInt(4, curso.getId());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removerCurso(int idCurso) {
		try {
			String sql = "DELETE FROM cursos where id=?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCurso);
			pstmt.executeUpdate();
			pstmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removerCursosPelaInstituicao(Integer idInstituicao) {
		String sql="delete from cursos where id_instituicao=?";
		
		
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, idInstituicao);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
