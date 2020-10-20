package br.ucsal.roteiro.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Onibus;
import br.ucsal.roteiro.util.Conexao;

public class OnibusDAO {
	
	public static Connection con = Conexao.getConnection();
	
	public static List<Onibus> listarOnibus(){
		List <Onibus> onibus = new ArrayList<Onibus>();
		
		try {
			String sql = "select * from onibus;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String detalhes = rs.getString(2);
				String situacao = rs.getString(3);
				String placa = rs.getString(4);
				Onibus bus = new Onibus(id, placa, detalhes, situacao);
				onibus.add(bus);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return onibus;
	}
	
	public static Onibus buscarOnibus(Integer idOnibus) {
		Onibus bus = null;
		try {
			String sql = "select * from onibus where id=?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idOnibus);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String detalhes = rs.getString(2);
				String situacao = rs.getString(3);
				String placa = rs.getString(4);
				bus = new Onibus(id, placa, detalhes, situacao);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bus;
	}
	
	public static void inserirOnibus(Onibus onibus) {
		try {
			String sql = "insert into onibus (detalhes, situacao, placa) values (?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, onibus.getDetalhes());
			pstmt.setString(2, onibus.getSituacao());
			pstmt.setString(3, onibus.getPlaca());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editarOnibus(Onibus onibus) {
		try {
			String sql = "UPDATE onibus " + 
					"set detalhes=?, situacao = ?, placa = ? " + 
					"where id = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, onibus.getDetalhes());
			pstmt.setString(2, onibus.getSituacao());
			pstmt.setString(3, onibus.getPlaca());
			pstmt.setInt(4, onibus.getId());
			pstmt.executeUpdate();
			pstmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		}

	public static void removerOnibus(Integer id) {
		try {
			String sql = "DELETE FROM onibus where id=?;";
			//
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
