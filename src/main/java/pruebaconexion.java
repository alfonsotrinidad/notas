import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pruebaconexion {

	static final String USUARIO = "root";
	static final String PASSWORD = "";
	static final String URL = "jdbc:mysql://localhost:3306/cibertec?serverTimezone=UTC";
	
	
	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,USUARIO,PASSWORD);
		    ResultSet rs;				
		    String usuario = "adrian";
		    String password = "123";
			System.out.println("Conected " + con.toString());
			//	String consulta = "select * from usuarios where usuarios.id = '" + usuario + "' and contrasenia = '"+ password + "'";
			String consulta = "select * from grupo";
				System.out.println(consulta);
				
				Statement stm = con.createStatement();
				rs = stm.executeQuery(consulta);
				int rowcount = 0;
				if (rs.last()) {
					  rowcount = rs.getRow();
					  rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
					}
				System.out.println("Afectadas  " + rowcount);
				
				if (rs != null) {
					rs.first();

					String user = rs.getString("cod_grupo");
					//String pass = rs.getString("contrasenia");
					System.out.println(user);
			}}
		catch( Throwable  ex) {
		//	Logger.getLogger(Connection.class.getName().log(Level.SEVERE, null,ex));
			System.out.println("Error" +  ex.toString());
			
		}
		}
}
		

		

