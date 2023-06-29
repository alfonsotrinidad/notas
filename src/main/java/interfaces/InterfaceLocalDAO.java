package interfaces;

import java.util.List;

import entidad.Local;

public interface InterfaceLocalDAO {
	
	public List<Local> ListadoLocales();
	
	public Local GetLocalPorId(int Idlocal);

}
