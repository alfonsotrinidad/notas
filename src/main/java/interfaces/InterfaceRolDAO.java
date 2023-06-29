package interfaces;

import java.util.List;

import entidad.Rol;

public interface InterfaceRolDAO {
	
	public List<Rol> ListadoRol();
	
	public Rol GetRolPorId(String idRol);

}
