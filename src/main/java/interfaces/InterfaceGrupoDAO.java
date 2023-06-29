package interfaces;


import java.util.List;
import java.util.Set;

import entidad.Grupo;


public interface InterfaceGrupoDAO {

	public List<Grupo> ListadoGrupo();
	
	public Grupo GetGrupoPorId(String codGrupo);

	public Set<Grupo> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccion(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura,String idSeccion);

	
}
