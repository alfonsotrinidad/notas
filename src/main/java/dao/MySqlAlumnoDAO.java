package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.Alumno;
import entidad.AlumnoExt;
import interfaces.InterfaceAlumnoDAO;

public class MySqlAlumnoDAO implements InterfaceAlumnoDAO{


	@Override
	public Alumno GetAlumno(String docIdentidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<AlumnoExt> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGruYTiprue(String idProfesor,
			int local, int anio, String idModalidad, String idAsignatura, String idSeccion, String idGrupo,
			String codPrueba, int numPrueba) {
		
		Set<AlumnoExt> list=new HashSet<>();
		AlumnoExt alumnoExt=null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select u.id,al.nombre,al.apellido,al.doc_identidad\r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ "inner join tipo_prueba tp on an.cod_prueba=tp.cod_prueba\r\n"
					+ "inner join alumnos al on al.doc_identidad=m.id_alumno\r\n"
					+ "inner join usuarios u on u.id_alumno=al.doc_identidad\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=?\r\n"
					+ " and ad.id_asign=? and ad.id_seccion=? and an.cod_grupo=? and tp.cod_prueba=? and an.numero_prueba=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			pstm.setString(5,idAsignatura);
			pstm.setString(6,idSeccion);
			pstm.setString(7,idGrupo);
			pstm.setString(8, codPrueba);
			pstm.setInt(9,numPrueba);
			
			
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				alumnoExt=new AlumnoExt();
				alumnoExt.setIdAlumno(rs.getString("id"));
				alumnoExt.setNombre(rs.getString("nombre"));
				alumnoExt.setApellido(rs.getString("apellido"));
				
				alumnoExt.setDocIdentidad(rs.getString("doc_identidad"));
				
				
				list.add(alumnoExt);
				
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
	public List<Alumno> ListadoAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

}
