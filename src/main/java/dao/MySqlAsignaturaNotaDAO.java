package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.AlumnoExt;
import entidad.AsignaturaDetalleExt;
import entidad.AsignaturaNota;
import entidad.AsignaturaNotaExt;
import interfaces.InterfaceAsignaturaNotaDAO;

public class MySqlAsignaturaNotaDAO implements InterfaceAsignaturaNotaDAO{

	@Override
	public List<AsignaturaNota> ListadoAsignaturaNota() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AsignaturaNota> GetAsignaturaNotaPorProfesorAsignaturaSeccionGrupoTipoPruebaNumeroPrueba(
			String docProfesor, String idAsignatura, String idSeccion, String codGrupo, String codPrueba,
			int numPrueba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ActualizarNotas(String idProfesor, int local, int anio, String idModalidad, String idAsignatura,
			String idSeccion, AsignaturaNota asignaturaNota) {
		
		Connection conn= null;
		PreparedStatement pstm = null;
		int resultado=0;
		
		try {
		
			
			conn = MysqlBDConexion.getConexion();
			String sql ="update asignatura_notas anotas\r\n"
					+ " join(\r\n"
					+ "select m.id_matricula\r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ "inner join tipo_prueba tp on an.cod_prueba=tp.cod_prueba\r\n"
					+ "inner join alumnos al on al.doc_identidad=m.id_alumno\r\n"
					+ "inner join usuarios u on u.id_alumno=al.doc_identidad\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=?\r\n"
					+ " and ad.id_asign=? and ad.id_seccion=? and an.cod_grupo=? and tp.cod_prueba=?\r\n"
					+ " and an.numero_prueba=? \r\n"
					+ " ) as subquery\r\n"
					+ " set nota=?\r\n"
					+ " where anotas.id_matricula=subquery.id_matricula and anotas.cod_prueba=? and anotas.numero_prueba=? and anotas.cod_grupo=?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			pstm.setString(5,idAsignatura);
			pstm.setString(6,idSeccion);
			pstm.setString(7,asignaturaNota.getCodGrupo());
			pstm.setString(8, asignaturaNota.getCodPrueba());
			pstm.setInt(9,asignaturaNota.getNumeroPrueba());
			pstm.setInt(10, asignaturaNota.getNota());
			pstm.setString(11, asignaturaNota.getCodPrueba());
			pstm.setInt(12, asignaturaNota.getNumeroPrueba());
			pstm.setString(13,asignaturaNota.getCodGrupo());
			
			
			resultado=pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return resultado;

	}

	@Override
	public Map<String, List<AsignaturaNotaExt>> ObtenerCursosYNotas(String idAlumno, int anio, int local,
			String codModalidad) {

        Map<String, List<AsignaturaNotaExt>> datosPorCurso= new HashMap<>();
		List<AsignaturaNotaExt> list=null;
		AsignaturaNotaExt asignaturaNotaExt=null;

		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql =" select   a.descripcion_asign,ad.id_asign,an.cod_prueba,tp.descrip_prueba,an.numero_prueba,an.peso,an.nota\r\n"
					+ " from \r\n"
					+ " matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ " inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ " inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ " inner join tipo_prueba tp on tp.cod_prueba=an.cod_prueba\r\n"
					+ " where m.id_alumno=? and m.anio=? and m.cod_local=? and ad.cod_modalidad=?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idAlumno);
			pstm.setInt(2, anio);
			pstm.setInt(3, local);
			pstm.setString(4, codModalidad);
				
			
			rs = pstm.executeQuery();
				
			list=new ArrayList<>();
			
			while(rs.next()){
				asignaturaNotaExt=new AsignaturaNotaExt();
				asignaturaNotaExt.setDescripAsign(rs.getString("descripcion_asign"));
				asignaturaNotaExt.setIdAsign(rs.getString("id_asign"));
				asignaturaNotaExt.setCodPrueba(rs.getString("cod_prueba"));
				asignaturaNotaExt.setDescripPrueba(rs.getString("descrip_prueba"));
				asignaturaNotaExt.setNumeroPrueba(rs.getInt("numero_prueba"));
				asignaturaNotaExt.setPeso(rs.getDouble("peso"));
				asignaturaNotaExt.setNota(rs.getInt("nota"));
				
				list.add(asignaturaNotaExt);
				
			}
			
	        for (AsignaturaNotaExt dato : list) {
	            String curso = dato.getDescripAsign();
	            
	            if (!datosPorCurso.containsKey(curso)) {
	                datosPorCurso.put(curso, new ArrayList<>());
	            }
	            
	            datosPorCurso.get(curso).add(dato);
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
		return datosPorCurso;
		
	}
	

}
