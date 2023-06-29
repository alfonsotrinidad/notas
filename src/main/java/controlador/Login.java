package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.SessionImpl;

import dao.MySqlProfesorDAO;
import capa_datos.MysqlBDConexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import entidad.Profesor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		MysqlBDConexion miconexion = new MysqlBDConexion();
		this.con = miconexion.getConexion();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // 
		
		
		ResultSet rs;

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		try {
			String consulta = "select * from usuarios where usuarios.id = '" + usuario + "' and contrasenia = '"+ password + "'";
			Statement stm = this.con.createStatement();
			rs = stm.executeQuery(consulta);
			if (rs != null) {
				rs.next();

				String user = rs.getString("id");
				String pass = rs.getString("contrasenia");
				request.setAttribute("usuario", user);
				request.setAttribute("password", pass);
				
				
				String modas = modalidades();
				request.setAttribute("modas",modas);
				
				
				String asignaturas = asignaturas();
				request.setAttribute("asignaturas",asignaturas);
				
				
				String matriculados = Matricula(); 
				request.setAttribute("matriculados",matriculados);
				
				
				String grupos = grupos();
				request.setAttribute("grupos",grupos);
				
				String pruebas = tipoprueba();
				request.setAttribute("pruebas",pruebas);
			
				
				
				String secciones = secciones();
				request.setAttribute("secciones",secciones);
				
			
				
				
				String asign_notas = asignatura_notas();
				request.setAttribute("notas",asign_notas);
				
				

				String op = request.getParameter("operacion");
				request.getSession().setAttribute("op", op);
				request.getRequestDispatcher("/Menu.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/Menu.jsp");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace ();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}
	
	
	public String modalidades() {
		String consulta = "select * from modalidades";
		String resp = "";

		try {

			Statement stm = this.con.createStatement();
			ResultSet rs;
			rs = stm.executeQuery(consulta);
			if (rs != null) {
				rs.next();
				do {
					resp = resp + "<option>" + rs.getString("id_modalidad") + "  " + rs.getString("descripcion_mod")
							+ "</option>";

				} while (rs.next());
				return resp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<option>Error consultando Modalidades</option>";
		}
		return "<option>Error consultando Modalidades</option>";
	}
	
	
	public String asignaturas() {
		String consulta = "select * from asignatura";
		String resp = "";
		try {
			 Statement stm = con.createStatement();
			 ResultSet  rs = stm.executeQuery(consulta);
			if(rs!=null) {
				rs.next();
				do {
					resp = resp + "<option>"+ rs.getString("id_asign")+"  " + rs.getString("descripcion_asign") + "</option>";
					
				}
				while(rs.next());
				return resp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<option>Error consultando asign</option>";
		}
		return "<option>Error consultando asign</option>";
	}
	
	
	
	public String secciones() {
		String consulta = "select * from secciones";
		String resp = "";
		try {
			 Statement stm = con.createStatement();
			 ResultSet  rs = stm.executeQuery(consulta);

			rs = stm.executeQuery(consulta);
			if(rs!=null) {
				rs.first();
				do {
					resp = resp + "<option>" + rs.getString("id_seccion") + "</option>";
			
				}
				while(rs.next());
				return resp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<option>Error consultando secciones</option>";
		}
		return "<option>Error consultando secciones</option>";
	}


	public String asignatura_notas() {
		String consulta = "select * from asignatura_notas";
		String resp = "";
		try {
			 Statement stm = con.createStatement();
			 ResultSet  rs = stm.executeQuery(consulta);

			rs = stm.executeQuery(consulta);
			if(rs!=null) {
				rs.first();
				do {
					resp = resp + "<option>Codigo  "+rs.getString("cod_prueba")+"   Nº  " + rs.getString("numero_prueba") + "</option>";
			
				}
				while(rs.next());
				return resp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<option>Error consultando notas</option>";
		}
		return "<option>Error consultando notas</option>";
	}
	
	public String grupos() {
		String consulta = "select * from grupo";
		String resp = "";
		try {
			 Statement stm = con.createStatement();
			 ResultSet  rs = stm.executeQuery(consulta);

			rs = stm.executeQuery(consulta);
			if(rs!=null) {
				rs.first();
				do {
					resp = resp + "<option>"+ rs.getString("cod_grupo")+"  " + rs.getString("descrip_grupo") + "</option>";
		
				}
				while(rs.next());
				return resp;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<option>Error consultando grupos</option>";
		}
		return "<option>Error consultando grupos</option>";
	}
	
	public String tipoprueba() {
		String consulta = "select * from tipo_prueba";
		String resp = "";
		try {
			 Statement stm = con.createStatement();
			 ResultSet  rs = stm.executeQuery(consulta);

		//	rs = stm.executeQuery(consulta);
			if(rs!=null) {
				rs.next();
				do {
					resp = resp + "<option>" + rs.getString("cod_prueba") + "  " + rs.getString("descrip_prueba") + "</option>";
					
				}
				while(rs.next());
				return resp; 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<option>Error consultando pruebas</option>";
		}
		return "<option>Error consultando pruebas</option>";
	}
	
	
	public String Matricula() {
	
		return "hola desde la funcion";
	}
	} 
	
	

