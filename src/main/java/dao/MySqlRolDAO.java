package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capa_datos.MysqlBDConexion;
import entidad.Rol;
import interfaces.InterfaceRolDAO;

public class MySqlRolDAO implements InterfaceRolDAO{

	@Override
	public List<Rol> ListadoRol() {
		
		List<Rol> data = new ArrayList<Rol>();
		
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		try {
			conn = MysqlBDConexion.getConexion();//ok
			String sql ="select * from roles";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
					
			Rol objRol= null;
			
			
			while(rs.next()){
				
				objRol = new Rol();
	
				objRol.setIdRol(rs.getString("id_rol"));
				objRol.setRol(rs.getString("rol"));

				data.add(objRol);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;

	}

	@Override
	public Rol GetRolPorId(String idRol) {
		// TODO Auto-generated method stub
		return null;
	}

}
