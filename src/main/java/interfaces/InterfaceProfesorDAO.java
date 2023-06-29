package interfaces;

import java.util.List;

import entidad.Profesor;

public interface InterfaceProfesorDAO {
	
	public List<Profesor> ListadoProfesores();
	
	public Profesor GetProfesorPorId(String docIdentidad);

}
