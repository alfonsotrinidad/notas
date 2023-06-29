package interfaces;

import java.util.List;
import java.util.Set;

import entidad.Alumno;
import entidad.AlumnoExt;


public interface InterfaceAlumnoDAO {
	
	public List<Alumno>ListadoAlunos();
	
	public Alumno GetAlumno(String docIdentidad);
	
	public Set<AlumnoExt> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGruYTiprue(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura,String idSeccion,String idGrupo,String codPrueba,int numPrueba);
	

	
}
