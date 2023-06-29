package entidad;

public class Grupo {
	
	private String codGrupo;
	
	private String descripGrupo;

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getDescripGrupo() {
		return descripGrupo;
	}

	public void setDescripGrupo(String descripGrupo) {
		this.descripGrupo = descripGrupo;
	}
	
	
	//métodos que evitan duplicidad
    @Override
    public int hashCode() {
        return codGrupo.hashCode();
    }
	
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grupo otroGrupo= (Grupo) obj;
        return codGrupo.equals(otroGrupo.codGrupo);
    }

}
