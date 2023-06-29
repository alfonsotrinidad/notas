package interfaces;
import java.util.List;

import entidad.Cliente;

public interface InterfaceClienteDAO {

	public int RegistrarCliente(Cliente clie);
	public List<Cliente>ListadoClientes();
	
	
	
}
