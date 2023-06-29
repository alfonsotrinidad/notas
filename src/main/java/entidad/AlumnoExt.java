package entidad;

public class AlumnoExt extends Alumno{
	
	private String idAlumno;
	
	private int nota;

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	//métodos que evitan duplicidad
    @Override
    public int hashCode() {
        return idAlumno.hashCode();
    }
	
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AlumnoExt otroAlumnoExt= (AlumnoExt) obj;
        return idAlumno.equals(otroAlumnoExt.idAlumno);
    }

}
