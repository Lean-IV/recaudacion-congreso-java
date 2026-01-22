package modelo;

import java.util.Objects;

public class Auspiciante extends Persona {

	private String razonSocial;
	private String cuit;
	private double montoAportado;
	
	public Auspiciante(int idPersona, String movil, String mail, String razonSocial, String cuit, double montoAportado) {
		super(idPersona, movil, mail);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.montoAportado = montoAportado;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public double getMontoAportado() {
		return montoAportado;
	}

	public void setMontoAportado(double montoAportado) {
		this.montoAportado = montoAportado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auspiciante other = (Auspiciante) obj;
		return Objects.equals(cuit, other.cuit);
	}

	@Override
	public String toString() {
		return "\nAuspiciante [razonSocial=" + razonSocial + ", cuit=" + cuit + ", montoAportado=" + montoAportado
				+ ", idPersona=" + idPersona + ", movil=" + movil + ", mail=" + mail + "]";
	}

	
}
