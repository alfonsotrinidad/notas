package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capa_datos.MysqlBDConexion;
import entidad.Anio;
import interfaces.InterfaceAnioDAO;

public class MySqlAnioDAO implements InterfaceAnioDAO{

	@Override
	public List<Anio> ListadoAnios() {
		
		List<Anio> data = new ArrayList<Anio>();
		
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		try {
			conn = MysqlBDConexion.getConexion();//ok
			String sql ="select * from anio";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			
			
			
			Anio objAnio= null;
			
			
			while(rs.next()){
				
				objAnio = new Anio();
	
				
				objAnio.setAnio(rs.getInt("anio"));

				data.add(objAnio);
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
	public Anio GetAnio(String anio) {
		// TODO Auto-generated method stub
		return null;
	}

}
