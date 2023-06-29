package interfaces;

import java.util.List;
import java.util.Set;

import entidad.Seccion;

public interface InterfaceSeccionDAO {
	
	public List<Seccion> ListadoSeccion();
	
	public Seccion GetListadoPorId(String idSeccion);
	
	public Set<Seccion> GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignatura(String idProfesor,int local,int anio,String idModalidad,String idAsignatura);


}
