package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import capa_datos.MysqlBDConexion;
import entidad.Profesor;

import interfaces.InterfaceProfesorDAO;

public class MySqlProfesorDAO implements InterfaceProfesorDAO{

	@Override
	public List<Profesor> ListadoProfesores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesor GetProfesorPorId(String docIdentidad) {
		
		Profesor profesor=new Profesor();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select * from profesores where doc_identidad=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, docIdentidad);
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				profesor.setNombre(rs.getString("nombre"));;
				profesor.setApellido(rs.getString("apellido"));
				profesor.setDocIdentidad(rs.getString("doc_identidad"));				
				
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
		return profesor;
		
	}

}
