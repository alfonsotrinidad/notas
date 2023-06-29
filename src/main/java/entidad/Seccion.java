package entidad;

public class Seccion {

	
	private String idSeccion;

	public String getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(String idSeccion) {
		this.idSeccion = idSeccion;
	}
	
	//métodos que evitan duplicidad
    @Override
    public int hashCode() {
        return idSeccion.hashCode();
    }
	
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Seccion otraSeccion= (Seccion) obj;
        return idSeccion.equals(otraSeccion.idSeccion);
    }
}
