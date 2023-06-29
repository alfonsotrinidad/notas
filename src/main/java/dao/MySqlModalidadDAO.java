package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capa_datos.MysqlBDConexion;

import entidad.Modalidad;
import interfaces.InterfaceModalidadDAO;

public class MySqlModalidadDAO implements InterfaceModalidadDAO{

	@Override
	public List<Modalidad> ListadoModalidad() {
		
		List<Modalidad> data = new ArrayList<Modalidad>();
		
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		try {
			conn = MysqlBDConexion.getConexion();//ok
			String sql ="select * from modalidades";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
		
			Modalidad objModalidad= null;
			
			
			while(rs.next()){
				
				objModalidad = new Modalidad();
				
				objModalidad.setIdModalidad(rs.getString("id_modalidad"));
				objModalidad.setDescripModalidad(rs.getString("descripcion_mod"));	
			
				data.add(objModalidad);
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
	public Modalidad GetModalidadPorId(String codModalidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
