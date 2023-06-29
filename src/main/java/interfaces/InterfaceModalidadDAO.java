package interfaces;

import java.util.List;

import entidad.Modalidad;

public interface InterfaceModalidadDAO {
	
	public List<Modalidad> ListadoModalidad();
	
	public Modalidad GetModalidadPorId(String codModalidad);

}
