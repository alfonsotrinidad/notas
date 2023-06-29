import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class pruebaconexion {

	static final String USUARIO = "root";
	static final String PASSWORD = "";
	static final String URL = "jdbc:mysql://localhost:3306/cibertec?serverTimezone=UTC";
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USUARIO,PASSWORD);
	//		stm = con.createStatement();
			System.out.println("Conectado " + con.toString());
			}
		catch( ClassNotFoundException ex) {
		//	Logger.getLogger(Connection.class.getName().log(Level.SEVERE, null,ex));
			System.out.println("Error" +  ex.toString());
			
		}
		

	}

}
