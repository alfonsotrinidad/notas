package capa_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * Permite crer una conexion a la BD
 * Se debe tener:
 * 1) Driver JDBC
 * 2) Ip del Servidor
 * 3) puerto
 * 4) Nombre de la BD
 * 5) Usuario
 * 6) Password  
 * 
 */
public class SqlServerBDConexion {

	static{
		try {
			//permite crear objetos (Hace new)
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConexion(){
		Connection cone = null;
		
		try {
			cone = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:3306/ventas2023","sa","sql");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cone;
	}
	

}
