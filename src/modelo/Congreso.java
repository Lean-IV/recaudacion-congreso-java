package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Congreso {

	private List<Persona> lstPersonas;
	private List<Conferencia> lstConferencias;
	private List<Entrada> lstEntradas;
	
	public Congreso() {
		super();
		this.lstPersonas = new ArrayList<>();
		this.lstConferencias = new ArrayList<>();
		this.lstEntradas = new ArrayList<>();
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Conferencia> getLstConferencias() {
		return lstConferencias;
	}

	public void setLstConferencias(List<Conferencia> lstConferencias) {
		this.lstConferencias = lstConferencias;
	}

	public List<Entrada> getLstEntradas() {
		return lstEntradas;
	}

	public void setLstEntradas(List<Entrada> lstEntradas) {
		this.lstEntradas = lstEntradas;
	}
	
    // ---------------------------
    // AUSPICIANTES
    // ---------------------------
	public Auspiciante traerAuspiciante(String cuit) {
		int i = 0;
		boolean encontrado = false;
		Auspiciante aus = null;
		
		while(i < lstPersonas.size() && !encontrado) {
			Persona p = lstPersonas.get(i);
			if(p instanceof Auspiciante) {
				Auspiciante aux = (Auspiciante)p;
				if(aux.getCuit().equals(cuit)) {
					encontrado = true;
					aus = aux;
				}
			}
			i++;
		}
		
		return aus;
	}
	
	public List<Auspiciante> traerAuspiciante() {
		List<Auspiciante> lista = new ArrayList<Auspiciante>();
		for(int i = 0; i < lstPersonas.size(); i++) {
			Persona p = lstPersonas.get(i);
			if (p instanceof Auspiciante) {
				lista.add((Auspiciante) p);
			}
		}

		return lista;
	}
	
	
	public boolean agregarAuspiciante(String movil, String mail, String razonSocial, String cuit, double montoAportado) throws Exception {
		Auspiciante a = traerAuspiciante(cuit);
		
		if(a != null) {
			throw new Exception("Error, el auspiciante con el cuit " + cuit + " ya se encuentra registrado");
		}
		
		int id = 0;
		
		if(lstPersonas.size() > 0) {
			int ultimoIndice = lstPersonas.size() - 1;
			Persona ultimaPers = lstPersonas.get(ultimoIndice);
			id = ultimaPers.getIdPersona();
		}
		
		Auspiciante nuevo = new Auspiciante(id + 1, movil, mail, razonSocial, cuit, montoAportado);
		return lstPersonas.add(nuevo);
	}
	
    // ---------------------------
    // ESPECTADORES
    // ---------------------------
	public List<Espectador> traerEspectador(){
		List<Espectador> lista = new ArrayList<>();
		
		for(int i = 0; i < lstPersonas.size(); i++) {
			Persona p = lstPersonas.get(i);
			
			if(p instanceof Espectador) {
				lista.add((Espectador) p);
			}
		}
		return lista;
	}
	
	public Espectador traerEspectador(long nroDocumento) {
		Espectador e = null;
		boolean encontrado = false;
		int i = 0;
		
		while(i < lstPersonas.size() && !encontrado) {
			Persona p = lstPersonas.get(i);
			
			if(p instanceof Espectador) {
				Espectador aux = (Espectador) p;
				
				if(aux.getNroDocumento() == nroDocumento) {
					e = aux;
					encontrado = true;
				}
			}
			i++;
		}
		return e;
	}
	
	public boolean agregarEspectador(String movil, String mail, String nombre, String apellido, String tipoDocumento, long
			nroDocumento, String nivelEstudio) {
		
		int id = 0;
		
		if(lstPersonas.size() > 0) {
			int ultimoIndice = lstPersonas.size() - 1;
			Persona ultimaPersona = lstPersonas.get(ultimoIndice);
			id = ultimaPersona.getIdPersona();
		}
		Espectador nuevo = new Espectador(id + 1, movil, mail, nombre, apellido, tipoDocumento, nroDocumento, nivelEstudio);
		return lstPersonas.add(nuevo);
	}
	
    // ---------------------------
    // CONFERENCIAS
    // ---------------------------
	public boolean agregarConferencia(String titulo, LocalDate dia, double costo) {
		int id = 0;
		
		if(lstConferencias.size() > 0) {
			int ultimoIndice = lstConferencias.size() - 1;
			Conferencia ultimaConferencia = lstConferencias.get(ultimoIndice);
			id = ultimaConferencia.getIdConferencia();
		}
		Conferencia nueva = new Conferencia(id + 1, titulo, dia, costo);
		return lstConferencias.add(nueva);
	}
	
	public Conferencia traerConferencia(int idConferencia) {
		Conferencia c = null;
		boolean encontrado = false;
		int i = 0;
		
		while(lstConferencias.size() > i && !encontrado) {
			if(lstConferencias.get(i).getIdConferencia() == idConferencia) {
				encontrado = true;
				c = lstConferencias.get(i);
			}
			i++;
		}
		return c;
	}
	
	public List<Conferencia> traerConferencia(LocalDate dia){
		List<Conferencia> lista = new ArrayList<Conferencia>();
		int i = 0;
		
		while(lstConferencias.size() > i) {
			if(lstConferencias.get(i).getDia().equals(dia)) {
				lista.add(lstConferencias.get(i));
			}
			i++;
		}
		return lista;
	}
	
    // ---------------------------
    // ENTRADAS
    // ---------------------------
	
	public boolean agregarEntrada(String codIngreso, double precio, Espectador espectador, Conferencia conferencia) {
		int id = 0;
		
		if (lstEntradas.size() > 0) {
			int ultimoIndice = lstEntradas.size() - 1;
			Entrada ultimaEntrada = lstEntradas.get(ultimoIndice);
			id = ultimaEntrada.getIdEntrada();
		}
		
		Entrada nueva = new Entrada(id + 1, codIngreso, LocalDate.now(), LocalTime.now(), precio, espectador, conferencia);
		return lstEntradas.add(nueva);
	}
	

	public List<Entrada> traerEntrada(LocalDate dia){
		List<Entrada> lista = new ArrayList<Entrada>();
		int i = 0;
		
		while(lstEntradas.size() > i) {
			if(lstEntradas.get(i).getConferencia().getDia().equals(dia)) {
				lista.add(lstEntradas.get(i));
			}
			i++;
		}
		return lista;
	}
	
    // ---------------------------
    // BALANCE
    // ---------------------------
	public double calcularBalance(LocalDate dia) {
		double resultadoEntradas = 0;
		double resultadoCosto = 0;
		
		for(int i = 0; i < lstEntradas.size(); i++) {
			if(lstEntradas.get(i).getConferencia().getDia().equals(dia)) {
				resultadoEntradas = resultadoEntradas + lstEntradas.get(i).getPrecio();
			}
		}
		for(int i = 0; i < lstConferencias.size(); i++) {
			if(lstConferencias.get(i).getDia().equals(dia)) {
				resultadoCosto = resultadoCosto + lstConferencias.get(i).calcularCostoReal();
			}
		}
		return resultadoEntradas - resultadoCosto;
	}
	
}
