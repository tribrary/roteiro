package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.roteiro.model.Papel;
import br.ucsal.roteiro.util.Conexao;

public class PapelDAO {
	private static Connection con = Conexao.getConnection();

	public static List<Papel> listarPapeis() {
		List<Papel> papeis = new ArrayList<Papel>();

		try {
			String sql = "select * from papeis;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Integer id = rs.getInt("id");
				String codigo = rs.getString("codigo");
				String descricao = rs.getString("descricao");

				Papel papel = new Papel(id, codigo, descricao);
				papeis.add(papel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return papeis;
	}

	public static Papel buscarPapel(Integer id) {
		Papel papel = null;
		try {
			String sql = "select * from papeis where id=?;";
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()) {
				Integer idPapel = rs.getInt("id");
				String codigo = rs.getString("codigo");
				String descricao = rs.getString("descricao");
				papel= new Papel(idPapel, codigo, descricao);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return papel;
	}
}
