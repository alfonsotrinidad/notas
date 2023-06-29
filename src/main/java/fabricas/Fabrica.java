package fabricas;

import interfaces.InterfaceAlumnoDAO;

//Es una f�brica de objetos
//Se usa el patr�n DAO (Data Access Object)

import interfaces.*;

public abstract class Fabrica {

	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	
	//public static final double igv=0.18;

	//Se inscribe el dao Cliente a las f�bricas
   public abstract InterfaceClienteDAO getInterfaceClienteDAO();
   
   public abstract InterfaceAlumnoDAO  getInterfaceAlumnoDAO();
   
   public abstract InterfaceAnioDAO  getInterfaceAnioDAO();
   
   public abstract InterfaceAsignaturaDAO  getInterfaceAsignaturaDAO();

   public abstract InterfaceAsignaturaDetalleDAO  getInterfaceAsignaturaDetalleDAO();

   public abstract InterfaceAsignaturaNotaDAO  getInterfaceAsignaturaNotaDAO();

   public abstract InterfaceCarreraDAO  getInterfaceCarreraDAO();

   public abstract InterfaceGrupoDAO  getInterfaceGrupoDAO();

   public abstract InterfaceLocalDAO  getInterfaceLocalDAO();
   
   public abstract InterfaceMatriculaDAO  getInterfaceMatriculaDAO();

   public abstract InterfaceModalidadDAO  getInterfaceModalidadDAO();

   public abstract InterfaceProfesorDAO  getInterfaceProfesorDAO();

   public abstract InterfaceRolDAO  getInterfaceRolDAO();

   public abstract InterfaceSeccionDAO  getInterfaceSeccionDAO();

   public abstract InterfaceTipoPruebaDAO  getInterfaceTipoPruebaDAO();

   public abstract InterfaceUsuarioDAO  getInterfaceUsuarioDAO();

	//Va fabricar subfabricas (Mysql y sqlserver)
	public static Fabrica getFabrica(int tipo){
		Fabrica salida = null;
		switch(tipo){
			case MYSQL: 
				salida = new FabricaMysql();
				break;			
				
		}
		return salida;
	}
}
