package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Ponto;
import br.ucsal.roteiro.model.Roteiro;
import br.ucsal.roteiro.model.RoteiroPonto;
import br.ucsal.roteiro.util.Conexao;

public class RoteiroPontoDAO {
	private static Connection con = Conexao.getConnection();
	
	public static void inserirRoteiroPonto(Roteiro roteiro) {
		String sql="insert into roteiro_ponto (id_roteiro, id_ponto) values(?,?)";
		try {
			for (Ponto p : roteiro.getPontos()) {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, roteiro.getId());
				ps.setInt(2, p.getId());
				ps.executeUpdate();
				ps.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void excluirPonto(Integer idPonto) {
		try {
			String sql = "delete from roteiro_ponto where id_ponto=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idPonto);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<RoteiroPonto> buscarPeloPonto(Integer id) {
		List<RoteiroPonto> rp = new ArrayList<>();
		String sql="select * from Roteiro_ponto where id_ponto=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RoteiroPonto r= new RoteiroPonto();
				r.setId(rs.getInt("id"));
				r.setIdPonto(rs.getInt("id_ponto"));
				r.setIdRoteiro(rs.getInt("id_roteiro"));
				rp.add(r);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rp;
	}
	
	public static List<Ponto> buscarPontoDoRoteiro(Integer idRot) {
		List<Ponto> pontos = new ArrayList<>();
		String sql="select * from Roteiro_ponto where id_roteiro=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idRot);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Integer idPonto= rs.getInt("id_ponto");
				pontos.add(PontoDAO.obterPonto(idPonto));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pontos;
	}
	
	public static void excluirPontoDoRoteiro(Integer idRot) {
		try {
			String sql = "delete from roteiro_ponto where id_roteiro=?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, idRot);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
