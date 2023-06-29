package interfaces;

import java.util.List;
import java.util.Map;

import entidad.AsignaturaNota;
import entidad.AsignaturaNotaExt;

public interface InterfaceAsignaturaNotaDAO {
	
	public List<AsignaturaNota> ListadoAsignaturaNota();
	
	public List<AsignaturaNota> GetAsignaturaNotaPorProfesorAsignaturaSeccionGrupoTipoPruebaNumeroPrueba(
			String docProfesor,String idAsignatura,String idSeccion,String codGrupo,String codPrueba,int numPrueba
			);
	
	
	public int ActualizarNotas(String idProfesor, int local,
			int anio, String idModalidad, String idAsignatura,String idSeccion,AsignaturaNota asignaturaNota);
	
	
	public  Map<String, List<AsignaturaNotaExt>> ObtenerCursosYNotas(String idAlumno,int anio,int local,String codModalidad);
		
	
}
