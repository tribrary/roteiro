package br.ucsal.roteiro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoPG {

	 private static Connection con;
	// public static void main(String[] args) throws SQLException {
	 static {
		 String url = "jdbc:postgresql://localhost/Roteiros";
		 Properties props = new Properties();
		 props.setProperty("user","postgres");
		 props.setProperty("password",""); //coloque a senha aqui
		 props.setProperty("ssl","false");
	        
	        try {
				
				con = DriverManager.getConnection(url, props);

			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("erro2");
				e.printStackTrace();
			}
	 }

	    public static Connection getConnectionPG(){
	       
	    	return con;
	    }
	 }
