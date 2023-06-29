package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import capa_datos.MysqlBDConexion;
import entidad.Grupo;

import interfaces.InterfaceGrupoDAO;

public class MySqlGrupoDAO implements InterfaceGrupoDAO{

	@Override
	public List<Grupo> ListadoGrupo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grupo GetGrupoPorId(String codGrupo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Grupo> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccion(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura, String idSeccion) {
		
		Set<Grupo> list=new HashSet<>();
		Grupo grupo=null;
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="select an.cod_grupo\r\n"
					+ "from matriculas m inner join asignatura_detalle ad on m.id_asign_detalle=ad.id_asign_detalle\r\n"
					+ "inner join asignatura a on a.id_asign=ad.id_asign\r\n"
					+ "inner join asignatura_notas an on an.id_matricula=m.id_matricula\r\n"
					+ "where m.id_profesor=? and m.cod_local=? and m.anio=? and ad.cod_modalidad=?\r\n"
					+ " and ad.id_asign=? and ad.id_seccion=?; ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idProfesor);
			pstm.setInt(2, local);
			pstm.setInt(3, anio);
			pstm.setString(4, idModalidad);
			pstm.setString(5,idAsignatura);
			pstm.setString(6,idSeccion);
			
			rs = pstm.executeQuery();
				
			
			while(rs.next()){
				
				
				grupo=new Grupo();
				
				grupo.setCodGrupo(rs.getString("cod_grupo"));

				
				list.add(grupo);
				
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
