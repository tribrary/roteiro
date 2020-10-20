package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Estudante;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.util.Conexao;

public class RoteiroEstudanteDAO {
	private static Connection con = Conexao.getConnection();
	
	public static void inserRoteiroEstudante(Estudante estudante) {
		String sql= "insert into roteiro_estudante (id_roteiro, id_estudante) values ( ?, ?);";
		
		try {
			for (Roteiro roteiro : estudante.getRoteiros()) {
				PreparedStatement pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, roteiro.getId());
				pstmt.setInt(2, estudante.getId());
				pstmt.executeUpdate();
				pstmt.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Roteiro> buscarRoteiroDoEstudante(Integer idEstudante) {
		List<Roteiro> roteiros = new ArrayList<Roteiro>();
		String sql="select * from roteiro_estudante where id_estudante=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, idEstudante);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer idRoteiro = rs.getInt("id_roteiro");		
				roteiros.add(RoteiroDAO.obterRoteiro(idRoteiro));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roteiros;
	}
	
	public static void deletarPeloEstudante(Integer idEst) {
		String sql="delete from roteiro_estudante where id_estudante=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, idEst);
			pstmt.executeUpdate();
			pstmt.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
