package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Motorista;
import br.ucsal.roteiro.util.Conexao;

public class MotoristaDAO {
	
	private static Connection con = Conexao.getConnection();
	
	public static List<Motorista> listarMotoristas(){
		List <Motorista> motoristas = new ArrayList<Motorista>();
		try {
			String sql = "SELECT * from motoristas;"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String situacao = rs.getString(4);
				
				Motorista motorista = new Motorista(id, nome, descricao, situacao);
				motoristas.add(motorista);
				
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return motoristas;
	}
	
	public static Motorista buscarMotorista(int idMotorista) {
		Motorista motorista = null;
		try {
			String sql = "select * from motoristas where id=?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idMotorista);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String situacao = rs.getString(4);
				motorista = new Motorista(id, nome, descricao, situacao);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return motorista;
	}
	public static void inserirMotorista(Motorista motorista) {
		try {
			String sql = "insert into motoristas (nome, descricao, situacao) values (?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, motorista.getNome());
			pstmt.setString(2, motorista.getDescricao());
			pstmt.setString(3, motorista.getSituacao());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void editarMotorista(Motorista motorista) {
		try {
			String sql = "UPDATE motoristas " + "set nome=?, descricao = ?, situacao = ? " + "where id = ?;";
			System.out.println(motorista.getId());
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, motorista.getNome());
			pstmt.setString(2, motorista.getDescricao());
			pstmt.setString(3, motorista.getSituacao());
			pstmt.setInt(4, motorista.getId());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removerMotorista(Integer idMotorista) {
		try {
			String sql = "DELETE FROM motoristas where motorista_id=?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idMotorista);
			pstmt.executeUpdate();
			pstmt.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
