package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capa_datos.MysqlBDConexion;

import entidad.Local;
import interfaces.InterfaceLocalDAO;

public class MySqlLocalDAO implements InterfaceLocalDAO{

	@Override
	public List<Local> ListadoLocales() {
		
		List<Local> data = new ArrayList<Local>();
		
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		try {
			conn = MysqlBDConexion.getConexion();//ok
			String sql ="select * from locales";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			
			Local objAnio= null;
			
			
			while(rs.next()){
				
				objAnio = new Local();
	
				
				objAnio.setIdLocal(rs.getInt("id_local"));
				objAnio.setDescripLocal(rs.getString("descrip_local"));

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
	public Local GetLocalPorId(int Idlocal) {
		// TODO Auto-generated method stub
		return null;
	}

}
