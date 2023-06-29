package entidad;

public class TipoPrueba {
	
	private String codPrueba;
	
	private String descripPrueba;

	public String getCodPrueba() {
		return codPrueba;
	}

	public void setCodPrueba(String codPrueba) {
		this.codPrueba = codPrueba;
	}

	public String getDescripPrueba() {
		return descripPrueba;
	}

	public void setDescripPrueba(String descripPrueba) {
		this.descripPrueba = descripPrueba;
	}
	
	
	//métodos que evitan duplicidad
    @Override
    public int hashCode() {
        return codPrueba.hashCode();
    }
	
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TipoPrueba otroTipoPrueba= (TipoPrueba) obj;
        return codPrueba.equals(otroTipoPrueba.codPrueba);
    }

}
