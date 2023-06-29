package capa_datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlBDConexion {
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConexion(){
		String URL = "jdbc:mysql://localhost:3306/cibertec?serverTimezone=UTC";
		final String USUARIO = "root";
		final String PASSWORD = "";
		//"jdbc:mysql://localhost/cibertec?useTimezone=true&serverTimezone=UTC"
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL,USUARIO,PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
		
}
