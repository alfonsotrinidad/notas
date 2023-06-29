package interfaces;

import java.util.List;
import java.util.Set;

import entidad.Asignatura;
import entidad.Matricula;

public interface InterfaceAsignaturaDAO {
	

	public List<Asignatura>ListadoAsignaturas();
	
	public Asignatura GetAsignatura(String idAsign);
	
	public Set<Asignatura> GetAsignaturaPorCicloAcademicoIdProfesorYModalidad(String idProfesor,int local,int anio,String idModalidad);

}
