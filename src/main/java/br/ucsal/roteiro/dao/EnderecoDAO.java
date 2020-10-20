package br.ucsal.roteiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.ucsal.roteiro.model.Endereco;
import br.ucsal.roteiro.util.Conexao;

public class EnderecoDAO {

	private static Connection con = Conexao.getConnection();


	public static Endereco obterPonto(Integer idEndereco) {
		Endereco endereco = new Endereco();
		try {
			String sql = "select * from enderecos where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, idEndereco);
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		return endereco;
	}

	public static Endereco buscarEndereco(Integer id) {
		Endereco endereco = null;
		try {
			String sql = "select * from enderecos where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Integer idEnd= rs .getInt("id");
				String cep=rs.getString("cep");
				String cidade=rs.getString("cidade");
				String bairro=rs.getString("bairro");
				String rua=rs.getString("rua");
				String numero=rs.getString("numero");
				endereco= new Endereco(idEnd, cidade, cep, bairro, rua, numero);
			}
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		return endereco;
	}

	public static void inserirEndereco(Endereco endereco) {
		String sql = "insert into enderecos (cep, cidade, bairro, rua, numero) values (?,?,?,?,?);";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, endereco.getCep());
			pstmt.setString(2, endereco.getCidade());
			pstmt.setString(3, endereco.getBairro());
			pstmt.setString(4, endereco.getRua());
			pstmt.setString(5, endereco.getNumero());
			pstmt.execute();

			ResultSet rs = pstmt.getGeneratedKeys();
			Integer id = -1;
			if(rs.next()) {
				id=rs.getInt("id");
			}	
			if(endereco.getUsuario()!=null) {
				
				endereco.getUsuario().getEndereco().setId(id);
				UsuarioDAO.inserirUsuario(endereco.getUsuario());
			}
			
			if(endereco.getInstituicao()!=null) {
				endereco.getInstituicao().getEndereco().setId(id);
				InstituicaoDAO.inserirInstituicao(endereco.getInstituicao());
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void deletarEndereco(Integer id) {
		String sql= "delete from enderecos where id=?";
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void editarEndereco(Endereco endereco) {
		String sql ="update enderecos set cep=?, cidade=?, bairro=?, rua=?, numero=? where id=?";
		
		try {
			PreparedStatement pstmt= con.prepareStatement(sql);
			pstmt.setString(1, endereco.getCep());
			pstmt.setString(2, endereco.getCidade());
			pstmt.setString(3, endereco.getBairro());
			pstmt.setString(4, endereco.getRua());
			pstmt.setString(5, endereco.getNumero());
			pstmt.setInt(6, endereco.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
