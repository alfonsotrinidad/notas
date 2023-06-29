package interfaces;

import java.util.List;

import entidad.Matricula;

public interface InterfaceMatriculaDAO {
	
	public List<Matricula> ListadoMatriculas();
	
	public List<Matricula> GetMatriculaPorIdProfesor(String codProfesor	);

	public List<Matricula> GetMatriculaPorIdAlumno(String codAlumno);
	
	
}
