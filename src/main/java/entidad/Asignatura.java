package entidad;

public class Asignatura {

	private String idAsign;
	
	private String descripAsign;
	
	private int creditos;

	public String getIdAsign() {
		return idAsign;
	}

	public void setIdAsign(String idAsign) {
		this.idAsign = idAsign;
	}

	public String getDescripAsign() {
		return descripAsign;
	}

	public void setDescripAsign(String descripAsign) {
		this.descripAsign = descripAsign;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	
	//métodos que evitan duplicidad
    @Override
    public int hashCode() {
        return idAsign.hashCode();
    }
	
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Asignatura otraAsignatura= (Asignatura) obj;
        return idAsign.equals(otraAsignatura.idAsign);
    }
}
