package interfaces;

import java.util.List;

import entidad.Usuario;

public interface InterfaceUsuarioDAO {
	
	public List<Usuario> ListadoUsuarios();
	
	public Usuario GetUsuarioPorId(String id);
	
	public Usuario GetUsuarioPorIdAlumno(String idAlumno);
	
	public Usuario GetUsuarioPorIdProfesor(String idProfesor);

}
