package interfaces;

import java.util.List;


import entidad.AsignaturaDetalle;
import entidad.AsignaturaDetalleExt;

public interface InterfaceAsignaturaDetalleDAO {

	
	public List<AsignaturaDetalle>ListadoAsignaturasDetalle();
	
	public List<AsignaturaDetalle> GetAsignaturaDetallePorIdSeccion(int idSeccion);
	
	public List<AsignaturaDetalle> GetAsignaturaDetallePorIdAsignatura(int idAsignatura);

	public List<AsignaturaDetalle> GetAsignaturaDetallePorIdModalidad(int idModalidad);
	
	
	public List<AsignaturaDetalle> GetAsignaturaDetallePorId(AsignaturaDetalle asignaturaDetalle);
	
	public List<AsignaturaDetalleExt> GetAsignaturaDetallePorAlumnoAnioLocalModalidad(String idAlumno,int anio,int local,String codModalidad);
}

