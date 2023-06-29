package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.TipoPrueba;
import interfaces.InterfaceTipoPruebaDAO;

public class MySqlTipoPruebaDAO implements InterfaceTipoPruebaDAO{

	@Override
	public List<TipoPrueba> ListoTipoPrueba() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPrueba GetTipoPruebaPorId(String codPrueba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TipoPrueba> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGru(String idProfesor,
			int local, int anio, String idModalidad, String idAsignatura, String idSeccion, String idGrupo) {
		
		Set<TipoPrueba> list=new HashSet<>();
		TipoPrueba tipoPrueba=null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select tp.cod_prueba, tp.descrip_prueba\r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ "inner join tipo_prueba tp on an.cod_prueba=tp.cod_prueba\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=?\r\n"
					+ " and ad.id_asign=? and ad.id_seccion=? and an.cod_grupo=?; ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			pstm.setString(5,idAsignatura);
			pstm.setString(6,idSeccion);
			pstm.setString(7,idGrupo);
			
			
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				tipoPrueba=new TipoPrueba();
				
				tipoPrueba.setCodPrueba(rs.getString("cod_prueba"));
				tipoPrueba.setDescripPrueba(rs.getString("descrip_prueba"));

				list.add(tipoPrueba);
				
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

	@Override
	public List<Integer> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGruYTiprue(
			String idProfesor, int local, int anio, String idModalidad, String idAsignatura, String idSeccion,
			String idGrupo, String codPrueba) {
		
		List<Integer> list=new ArrayList<>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select an.numero_prueba\r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ "inner join tipo_prueba tp on an.cod_prueba=tp.cod_prueba\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=?\r\n"
					+ " and ad.id_asign=? and ad.id_seccion=? and an.cod_grupo=? and tp.cod_prueba=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			pstm.setString(5,idAsignatura);
			pstm.setString(6,idSeccion);
			pstm.setString(7,idGrupo);
			pstm.setString(8, codPrueba);
			
			
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				list.add(rs.getInt("numero_prueba"));
				
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
