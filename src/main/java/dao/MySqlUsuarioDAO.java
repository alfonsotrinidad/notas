package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import capa_datos.MysqlBDConexion;

import entidad.Usuario;
import interfaces.InterfaceUsuarioDAO;

public class MySqlUsuarioDAO implements InterfaceUsuarioDAO{

	@Override
	public List<Usuario> ListadoUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario GetUsuarioPorId(String id) {
		
		Usuario usuario=new Usuario();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select * from usuarios where id=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				usuario.setId(rs.getString("id"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setIdRol(rs.getString("id_rol"));
				usuario.setIdAlumno(rs.getString("id_alumno"));
				usuario.setIdProfesor(rs.getString("id_profesor"));
				
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return usuario;
		
	}

	@Override
	public Usuario GetUsuarioPorIdAlumno(String idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario GetUsuarioPorIdProfesor(String idProfesor) {
		// TODO Auto-generated method stub
		return null;
	}

}
