package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Entrada {

	private int idEntrada;
	private String codEntrada;
	private LocalDate fechaCompra;
	private LocalTime horaCompra;
	private double precio;
	private Espectador espectador;
	private Conferencia conferencia;
	
	
	public Entrada(int idEntrada, String codEntrada, LocalDate fechaCompra, LocalTime horaCompra, double precio,
			Espectador espectador, Conferencia conferencia) {
		super();
		this.idEntrada = idEntrada;
		this.codEntrada = codEntrada;
		this.fechaCompra = fechaCompra;
		this.horaCompra = horaCompra;
		this.precio = precio;
		this.espectador = espectador;
		this.conferencia = conferencia;
	}


	public int getIdEntrada() {
		return idEntrada;
	}


	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}


	public String getCodEntrada() {
		return codEntrada;
	}


	public void setCodEntrada(String codEntrada) {
		this.codEntrada = codEntrada;
	}


	public LocalDate getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public LocalTime getHoraCompra() {
		return horaCompra;
	}


	public void setHoraCompra(LocalTime horaCompra) {
		this.horaCompra = horaCompra;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Espectador getEspectador() {
		return espectador;
	}


	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}


	public Conferencia getConferencia() {
		return conferencia;
	}


	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}


	@Override
	public String toString() {
		return "\nEntrada [idEntrada=" + idEntrada + ", codEntrada=" + codEntrada + ", fechaCompra=" + fechaCompra
				+ ", horaCompra=" + horaCompra + ", precio=" + precio + ", espectador=" + espectador + ", conferencia="
				+ conferencia + "]";
	}
	
	
}
