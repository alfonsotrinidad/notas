package entidad;

public class Alumno {

	private String docIdentidad;
	
	private String nombre;
	
	private String apellido;

	public String getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(String docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	//métodos que evitan duplicidad
    @Override
    public int hashCode() {
        return docIdentidad.hashCode();
    }
	
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Alumno otroAlumno= (Alumno) obj;
        return docIdentidad.equals(otroAlumno.docIdentidad);
    }

	
}
