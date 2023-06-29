package fabricas;

import dao.*;
import interfaces.InterfaceAlumnoDAO;
import interfaces.InterfaceAnioDAO;
import interfaces.InterfaceAsignaturaDAO;
import interfaces.InterfaceAsignaturaDetalleDAO;
import interfaces.InterfaceAsignaturaNotaDAO;
import interfaces.InterfaceCarreraDAO;
import interfaces.InterfaceClienteDAO;
import interfaces.InterfaceGrupoDAO;
import interfaces.InterfaceLocalDAO;
import interfaces.InterfaceMatriculaDAO;
import interfaces.InterfaceModalidadDAO;
import interfaces.InterfaceProfesorDAO;
import interfaces.InterfaceRolDAO;
import interfaces.InterfaceSeccionDAO;
import interfaces.InterfaceTipoPruebaDAO;
import interfaces.InterfaceUsuarioDAO;

public class FabricaMysql extends Fabrica {

	@Override
	public InterfaceClienteDAO getInterfaceClienteDAO() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}

	@Override
	public InterfaceAlumnoDAO getInterfaceAlumnoDAO() {
		// TODO Auto-generated method stub
		return new MySqlAlumnoDAO();
	}

	@Override
	public InterfaceAnioDAO getInterfaceAnioDAO() {
		// TODO Auto-generated method stub
		return new MySqlAnioDAO();
	}

	@Override
	public InterfaceAsignaturaDAO getInterfaceAsignaturaDAO() {
		// TODO Auto-generated method stub
		return new MySqlAsignaturaDAO();
	}

	@Override
	public InterfaceAsignaturaDetalleDAO getInterfaceAsignaturaDetalleDAO() {
		// TODO Auto-generated method stub
		return new MySqlAsignaturaDetalleDAO();
	}

	@Override
	public InterfaceAsignaturaNotaDAO getInterfaceAsignaturaNotaDAO() {
		// TODO Auto-generated method stub
		return new MySqlAsignaturaNotaDAO();
	}

	@Override
	public InterfaceCarreraDAO getInterfaceCarreraDAO() {
		// TODO Auto-generated method stub
		return new MySqlCarreraDAO();
	}

	@Override
	public InterfaceGrupoDAO getInterfaceGrupoDAO() {
		// TODO Auto-generated method stub
		return new MySqlGrupoDAO();
	}

	@Override
	public InterfaceLocalDAO getInterfaceLocalDAO() {
		// TODO Auto-generated method stub
		return new MySqlLocalDAO();
	}

	@Override
	public InterfaceMatriculaDAO getInterfaceMatriculaDAO() {
		// TODO Auto-generated method stub
		return new MySqlMatriculaDAO();
	}

	@Override
	public InterfaceModalidadDAO getInterfaceModalidadDAO() {
		// TODO Auto-generated method stub
		return new MySqlModalidadDAO();
	}

	@Override
	public InterfaceProfesorDAO getInterfaceProfesorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProfesorDAO();
	}

	@Override
	public InterfaceRolDAO getInterfaceRolDAO() {
		// TODO Auto-generated method stub
		return new MySqlRolDAO();
	}

	@Override
	public InterfaceSeccionDAO getInterfaceSeccionDAO() {
		// TODO Auto-generated method stub
		return new MySqlSeccionDAO();
	}

	@Override
	public InterfaceTipoPruebaDAO getInterfaceTipoPruebaDAO() {
		// TODO Auto-generated method stub
		return new MySqlTipoPruebaDAO();
	}

	@Override
	public InterfaceUsuarioDAO getInterfaceUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

}
