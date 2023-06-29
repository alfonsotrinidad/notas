import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.Soundbank;

import entidad.*;
import fabricas.Fabrica;
import interfaces.*;

public class prueba {
	
	public static void main(String[] args) {


			Fabrica mifabrica=Fabrica.getFabrica(Fabrica.MYSQL);

			
			//sirve para logeo
			//probandoLogeoProfesorAlumno(mifabrica,"i20212286");	
			
			
			//listar todas las modalidades
			//probandoListaModalidades(mifabrica);
			
			//listar todos los ciclos académicos
			//probandoObteniendoCicloAcademico(mifabrica);
			
			//nombre del profesor
			//probandoObteniendoNombreProfesor(mifabrica,"77777777");

			//listar asignaturas
			//probandoObteniendoCursosDictadosPorProfesorYLocalYAnioYModalidad(mifabrica,"55555555",81,2023,"SP");
			
			
			//listar secciones	
			//probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignatura(mifabrica,"55555555",81,2023,"SP","2326");
			

			//listar grupos
			//probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccion(mifabrica,"55555555",81,2023,"SP","2326","T3LJ");
			
	
			//listar tipo prueba
			//probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccionYGrupo(mifabrica,"55555555",81,2023,"SP","2326","T3LJ","01");
			
			//listar numero de prueba
			//probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccionYGrupoCodprue(
			//		mifabrica,"55555555",81,2023,"SP","2326","T3LJ","01","SP");
	
			//listar alumnos
			//probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccionYGrupoCodprueNumPrue(
			//mifabrica,"55555555",81,2023,"SP","2326","T3LJ","01","SP",2);			
	
			//actualizar notas
			/*
			AsignaturaNota asignaturaNota=new AsignaturaNota();
			asignaturaNota.setCodGrupo("01");
			asignaturaNota.setCodPrueba("SP");
			asignaturaNota.setNumeroPrueba(2);
			asignaturaNota.setNota(1);
			probandoActualizarNotas(mifabrica,"55555555",81,2023,"SP","2326","T3LJ",asignaturaNota);			 
			 */

			

			//listar cursos llevados en el año y ciclo academico (sirve para el lado del alumno)
			//probandoObtenerCursosPorCicloAcademicoYModalidad(mifabrica,"48102299",2023,81,"SP");
			
			
			//listar cursos,notas, peso, etc  (sirve para el lado del alumno)
			probandoObtenerCursosNotasPesos(mifabrica,"48102299",2023,81,"SP");
			
			
			
	}
	
	public static void probandoObtenerCursosNotasPesos(Fabrica mifabrica,String idAlumno, int anio, int local,
			String codModalidad) {
		
        

		InterfaceAsignaturaNotaDAO dao=mifabrica.getInterfaceAsignaturaNotaDAO();
		
		Map<String, List<AsignaturaNotaExt>> datosPorCurso= dao.ObtenerCursosYNotas(idAlumno, anio, local, codModalidad);

        // Acceder a los datos agrupados por curso
        for (String curso : datosPorCurso.keySet()) {
            System.out.println("Curso: " + curso);
            List<AsignaturaNotaExt> datosDelCurso = datosPorCurso.get(curso);
            
            for (AsignaturaNotaExt dato : datosDelCurso) {
                // Aquí puedes realizar las operaciones o imprimir los datos según necesites
                System.out.println(dato.getIdAsign());
                System.out.println(dato.getCodPrueba());
                System.out.println(dato.getDescripPrueba());
                System.out.println(dato.getNumeroPrueba());
                System.out.println(dato.getPeso());
                System.out.println(dato.getNota());
                
                
                
                
                
            }
            
            System.out.println("--------------------");
        }
		
	}
	
	
	public static void probandoObtenerCursosPorCicloAcademicoYModalidad(Fabrica mifabrica,String idAlumno,int anio,int local,String codModalidad) {
		
		
		InterfaceAsignaturaDetalleDAO dao=mifabrica.getInterfaceAsignaturaDetalleDAO();
		
		List<AsignaturaDetalleExt> numPruebas= dao.GetAsignaturaDetallePorAlumnoAnioLocalModalidad(idAlumno, anio, local, codModalidad);

		for (AsignaturaDetalleExt asignaturaDetalleExt : numPruebas) {
			
			System.out.println(asignaturaDetalleExt.getDescripAsign());
			System.out.println(asignaturaDetalleExt.getIdAsign());
			System.out.println(asignaturaDetalleExt.getIdSeccion());
			
			if(asignaturaDetalleExt.getSumaNotas()>0) {
				System.out.println("Sí hay notas");
			}else {
				System.out.println("no hay notas");
			}
			
			
		}
	 

	}
	
	
	public static void probandoActualizarNotas(Fabrica mifabrica,String idProfesor, int local, int anio, String idModalidad,
			String idAsignatura,String idSeccion, AsignaturaNota asignaturaNota) {
		
		InterfaceAsignaturaNotaDAO dao=mifabrica.getInterfaceAsignaturaNotaDAO();
		int resultado=dao.ActualizarNotas(idProfesor, local, anio, idModalidad, idAsignatura, idSeccion, asignaturaNota);

		if(resultado==1) {
			System.out.println("Actualización correcta");
		}else {
			System.out.println("No se ejecutó actualización");
		}
		
	}


		


	public static void probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccionYGrupoCodprueNumPrue(
			Fabrica mifabrica,String idProfesor,int local,int anio,String codModalidad,String idAsignatura,String idSeccion,String idGrupo,String codPrueba,int numPrueba) {
		
		
		InterfaceAlumnoDAO dao=mifabrica.getInterfaceAlumnoDAO();
		
		Set<AlumnoExt> numPruebas= dao.GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGruYTiprue(
				idProfesor, local, anio, codModalidad, idAsignatura,idSeccion,idGrupo,codPrueba,numPrueba);
		
		for (AlumnoExt alumnoExt : numPruebas) {
			
			System.out.println(alumnoExt.getIdAlumno());
			System.out.println(alumnoExt.getNombre());
			System.out.println(alumnoExt.getApellido());
			System.out.println(alumnoExt.getDocIdentidad());
		}
		  
		 

	}
	
	
	public static void probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccionYGrupoCodprue(
			Fabrica mifabrica,String idProfesor,int local,int anio,String codModalidad,String idAsignatura,String idSeccion,String idGrupo,String codPrueba) {
		
		InterfaceTipoPruebaDAO dao=mifabrica.getInterfaceTipoPruebaDAO();
		
		List<Integer> numPruebas= dao.GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGruYTiprue(
				idProfesor, local, anio, codModalidad, idAsignatura,idSeccion,idGrupo,codPrueba);
		
		for (int i = 0; i < numPruebas.size(); i++) {
			
			System.out.println("prueba numero:");
			System.out.println(numPruebas.get(i));
			
		}
	}
	
	
	
	public static void probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccionYGrupo(
			Fabrica mifabrica,String idProfesor,int local,int anio,String codModalidad,String idAsignatura,String idSeccion,String idGrupo) {
		
		InterfaceTipoPruebaDAO dao=mifabrica.getInterfaceTipoPruebaDAO();
		
		Set<TipoPrueba> tipoPruebas= dao.GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccionYGru(
				idProfesor, local, anio, codModalidad, idAsignatura,idSeccion,idGrupo);
		
		for (TipoPrueba tipoPrueba: tipoPruebas) {
			
			System.out.println(tipoPrueba.getCodPrueba());
			System.out.println(tipoPrueba.getDescripPrueba());

		}
	}
	
	public static void probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignaturaYSeccion(
			Fabrica mifabrica,String idProfesor,int local,int anio,String codModalidad,String idAsignatura,String idSeccion) {
		
		InterfaceGrupoDAO dao=mifabrica.getInterfaceGrupoDAO();
		
		Set<Grupo> grupos= dao.GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignaturaYSeccion(idProfesor, local, anio, codModalidad, idAsignatura,idSeccion);
		
		for (Grupo grupo: grupos) {
			
			System.out.println(grupo.getCodGrupo());

		}
	}
		
	
	
	
	public static void probandoObteniendoSeccionesDictadosPorProfesorYLocalYAnioYModalidadYAsignatura(
			Fabrica mifabrica,String idProfesor,int local,int anio,String codModalidad,String idAsignatura) {
		
		InterfaceSeccionDAO dao=mifabrica.getInterfaceSeccionDAO();
		
		Set<Seccion> seccions= dao.GetSeccionPorCicloAcademicoIdProfesorYModalidadYAsignatura(idProfesor, local, anio, codModalidad, idAsignatura);
		
		for (Seccion seccion: seccions) {
			
			System.out.println(seccion.getIdSeccion());

		}
	}
	
	
	
	
	public static void probandoObteniendoCursosDictadosPorProfesorYLocalYAnioYModalidad(
			Fabrica mifabrica,String idProfesor,int local,int anio,String codModalidad) 
	
	{
		
		InterfaceAsignaturaDAO dao=mifabrica.getInterfaceAsignaturaDAO();
		
		Set<Asignatura> asignaturas= dao.GetAsignaturaPorCicloAcademicoIdProfesorYModalidad(idProfesor, local, anio, codModalidad);
		
		for (Asignatura asignatura : asignaturas) {
			
			System.out.println(asignatura.getIdAsign());
			System.out.println(asignatura.getDescripAsign());
		}
	}
	
	public static void probandoObteniendoCicloAcademico(Fabrica mifabrica) {
		
		//esto unirá los años y locales
		
		
		//obteniendo años
		InterfaceAnioDAO dao=mifabrica.getInterfaceAnioDAO();
		List<Anio> anios=dao.ListadoAnios();
		
		for (int i = 0; i < anios.size(); i++) {
			
			System.out.println(anios.get(i).getAnio());
			
			
		}
		
		//obteniendolocales
		
		InterfaceLocalDAO dao2=mifabrica.getInterfaceLocalDAO();
		List<Local> list=dao2.ListadoLocales();
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).getDescripLocal());
			
			
		}		
		

		//uniendo locales con años
		String anioU;
		for (int i = 0; i < anios.size(); i++) {
			
			anioU=Integer.toString(anios.get(i).getAnio());

			for (int j = 0; j < list.size(); j++) {
				System.out.println(anioU+list.get(j).getIdLocal());
			}
			
		}
		
		
		
	}
	
	
	
	public static void probandoObteniendoNombreProfesor(Fabrica mifabrica,String id) {
		
		
		InterfaceProfesorDAO dao=mifabrica.getInterfaceProfesorDAO();
		
		Profesor profesor= dao.GetProfesorPorId(id);
		
		System.out.println(profesor);
		System.out.println(profesor.getApellido());
		System.out.println(profesor.getDocIdentidad());
		System.out.println(profesor.getNombre());

		
	}
	
	public static void probandoLogeoProfesorAlumno(Fabrica mifabrica,String id) {
		
		
		InterfaceUsuarioDAO dao=mifabrica.getInterfaceUsuarioDAO();
		
		Usuario usuario= dao.GetUsuarioPorId(id);
		
		System.out.println(usuario);
		System.out.println(usuario.getContrasenia());
		System.out.println(usuario.getIdProfesor());
		System.out.println(usuario.getIdAlumno());
		
		if(usuario.getContrasenia()==null) {
			System.out.println("no se encontró usuario");
		}
		
	}
	
	
	
	public static void probandoListaModalidades(Fabrica mifabrica){
		InterfaceModalidadDAO dao=mifabrica.getInterfaceModalidadDAO();
		
		List<Modalidad> list=dao.ListadoModalidad();
		
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).getDescripModalidad());
			
			
		}
	}

}
