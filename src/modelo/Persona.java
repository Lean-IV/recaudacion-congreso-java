package modelo;

import java.util.Objects;

public class Persona {

	protected int idPersona;
	protected String movil;
	protected String mail;
	
	
	public Persona(int idPersona, String movil, String mail) {
		super();
		this.idPersona = idPersona;
		this.movil = movil;
		this.mail = mail;
	}
	

	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public String getMovil() {
		return movil;
	}


	public void setMovil(String movil) {
		this.movil = movil;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", movil=" + movil + ", mail=" + mail + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return idPersona == other.idPersona;
	}
	
	
	
}
