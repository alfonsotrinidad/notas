package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.AlumnoExt;
import entidad.AsignaturaDetalle;
import entidad.AsignaturaDetalleExt;
import interfaces.InterfaceAsignaturaDetalleDAO;

public class MySqlAsignaturaDetalleDAO implements InterfaceAsignaturaDetalleDAO{

	@Override
	public List<AsignaturaDetalle> ListadoAsignaturasDetalle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsignaturaDetalle> GetAsignaturaDetallePorIdSeccion(int idSeccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsignaturaDetalle> GetAsignaturaDetallePorIdAsignatura(int idAsignatura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsignaturaDetalle> GetAsignaturaDetallePorIdModalidad(int idModalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsignaturaDetalle> GetAsignaturaDetallePorId(AsignaturaDetalle asignaturaDetalle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsignaturaDetalleExt> GetAsignaturaDetallePorAlumnoAnioLocalModalidad(
			String idAlumno,int anio,int local,String codModalidad) {
		
		List<AsignaturaDetalleExt> list=null;
		AsignaturaDetalleExt asignaturaDetalleExt=null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql =" select  a.descripcion_asign,a.id_asign,ad.id_seccion,sum(an.nota) as 'suma_nota'\r\n"
					+ " from \r\n"
					+ " matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ " inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ " inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ " where m.id_alumno=? and m.anio=? and m.cod_local=? and ad.cod_modalidad=?\r\n"
					+ " group by a.descripcion_asign,a.id_asign,ad.id_seccion;\r\n"
					+ "";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idAlumno);
			pstm.setInt(2, anio);
			pstm.setInt(3, local);
			pstm.setString(4, codModalidad);
				
			
			rs = pstm.executeQuery();
				
			list=new ArrayList<>();
			while(rs.next()){
				asignaturaDetalleExt=new AsignaturaDetalleExt();
				asignaturaDetalleExt.setDescripAsign(rs.getString("descripcion_asign"));
				asignaturaDetalleExt.setIdAsign(rs.getString("id_asign"));
				asignaturaDetalleExt.setIdSeccion(rs.getString("id_seccion"));
				asignaturaDetalleExt.setSumaNotas(rs.getInt("suma_nota"));
				
				list.add(asignaturaDetalleExt);
				
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
