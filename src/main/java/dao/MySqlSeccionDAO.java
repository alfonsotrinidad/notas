package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.Seccion;
import interfaces.InterfaceSeccionDAO;

public class MySqlSeccionDAO implements InterfaceSeccionDAO{

	@Override
	public List<Seccion> ListadoSeccion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seccion GetListadoPorId(String idSeccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Seccion> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignatura(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura) {
		
		Set<Seccion> list=new HashSet<>();
		Seccion seccion=null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select ad.id_seccion \r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=? and ad.id_asign=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			pstm.setString(5,idAsignatura);
			
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				
				seccion=new Seccion();
				
				seccion.setIdSeccion(rs.getString("id_seccion"));

				
				list.add(seccion);
				
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
