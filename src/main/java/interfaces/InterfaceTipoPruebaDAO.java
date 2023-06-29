package interfaces;

import java.util.List;
import java.util.Set;

import entidad.Alumno;
import entidad.TipoPrueba;

public interface InterfaceTipoPruebaDAO {
	
	public List<TipoPrueba> ListoTipoPrueba();
	
	public TipoPrueba GetTipoPruebaPorId(String codPrueba);
	
	public Set<TipoPrueba> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGru(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura,String idSeccion,String idGrupo);
	
	public List<Integer> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGruYTiprue(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura,String idSeccion,String idGrupo,String codPrueba);

}
