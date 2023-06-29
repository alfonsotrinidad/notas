package interfaces;

import java.util.List;

import entidad.Anio;

public interface InterfaceAnioDAO {
	
	public List<Anio>ListadoAnios();
	
	public Anio GetAnio(String anio);
	

}
