package interfaces;

import java.util.List;

import entidad.Carrera;

public interface InterfaceCarreraDAO {
	
	public List<Carrera> ListadoCarrera();
	
	public Carrera GetCarreraPorId(String codCarrera);

}
