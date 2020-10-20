package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.ucsal.roteiro.model.Endereco;
import br.ucsal.roteiro.model.Instituicao;
import br.ucsal.roteiro.util.Conexao;

public class InstituicaoDAO {
	private static Connection con = Conexao.getConnection();

	public static List<Instituicao> listarInstituicoes() {
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();

		try {
			String sql = "select * from instituicoes;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Integer id= rs.getInt("id");
				String nome = rs.getString("nome");
				Integer idEndereco = rs.getInt("id_endereco");
				Endereco e = EnderecoDAO.obterPonto(idEndereco);	
				Instituicao instituicao = new Instituicao(id, nome, e, CursoDAO.buscarCursoDaInstituicao(id));
				instituicoes.add(instituicao);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return instituicoes;
	}


	public static Instituicao buscarInstituicao(Integer id) {
		Instituicao instituicao= null;

		try {
			String sql = "select * from instituicoes where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				Integer idInstituicao= rs.getInt("id");
				String nome = rs.getString("nome");
				Integer idEndereco = rs.getInt("id_endereco");	
				Endereco e= EnderecoDAO.buscarEndereco(idEndereco);
				instituicao = new Instituicao(idInstituicao, nome, e, CursoDAO.buscarCursoDaInstituicao(idInstituicao));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instituicao;

	}

	public static void inserirInstituicao(Instituicao instituicao) {
		String sql= "insert into instituicoes ( nome, id_endereco) values (?,?)";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, instituicao.getNome());
			pstmt.setInt(2, instituicao.getEndereco().getId());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void EditarInstituicao(Instituicao instituicao) {
		String sql="update instituicoes set nome=? where id=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, instituicao.getNome());
			pstmt.setInt(2, instituicao.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		EnderecoDAO.editarEndereco(instituicao.getEndereco());
	}

	public static void DeletarInstituicao(Integer id) {
		CursoDAO.removerCursosPelaInstituicao(id);
		String sql="delete from instituicoes where id=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
