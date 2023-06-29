package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.Asignatura;
import entidad.Matricula;
import interfaces.InterfaceAsignaturaDAO;

public class MySqlAsignaturaDAO implements InterfaceAsignaturaDAO{

	@Override
	public List<Asignatura> ListadoAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asignatura GetAsignatura(String idAsign) {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public Set<Asignatura> GetAsignaturaPorCicloAcademicoIdProfesorYModalidad(String idProfesor, int local, int anio,
			String idModalidad) {
		
		Set<Asignatura> list=new HashSet<>();
		Asignatura asignatura=null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select a.id_asign, a.descripcion_asign \r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				
				asignatura=new Asignatura();
				
				asignatura.setIdAsign(rs.getString("id_asign"));
				asignatura.setDescripAsign(rs.getString("descripcion_asign"));
				
				list.add(asignatura);
				
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
		return list;
		
	}
	
	
	

}
