package test;

import java.time.LocalDate;


import modelo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Congreso congreso = new Congreso();
		System.out.println("1) Agregar e imprimir los siguientes auspiciantes:");
		try {
			congreso.agregarAuspiciante("1511111111", "unqui@edu.ar", "Universidad Nacional de Quilmes", "30-11111111-9", 2000);
			congreso.agregarAuspiciante("1522222222", "undav@edu.ar", "Universidad Nacional de Avellaneda", "30-22222222-9", 3000);
			congreso.agregarAuspiciante("1533333333", "unlz@edu.ar", "Universidad Nacional de Lomas", "30-33333333-9", 1000);
			congreso.agregarAuspiciante("1544444444", "utnavellaneda@edu.ar", "Universidad Tecnologíca de Avellaneda", "30-44444444-9", 4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(congreso.traerAuspiciante());

		System.out.println("\n2) Intentar agregar Auspiciante duplicado (mismo CUIT):");
		
		try {
			congreso.agregarAuspiciante("1599999999", "utnlanus@edu.ar", "Universidad Tecnologíca de Lanús", "30-44444444-9", 2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n3) Agregar e imprimir los siguientes espectadores:");
		congreso.agregarEspectador("1555555555", "dperez@edu.com", "Dario", "Perez", "DNI", 55555555, "Universitario");
		congreso.agregarEspectador("1566666666", "dgonzalez@edu.com", "Diego", "Gonzalez", "DNI", 66666666, "Universitario");
		congreso.agregarEspectador("1577777777", "fmariscano@edu.com", "Franco", "Mariscano", "DNI", 77777777, "Postgrado");
		congreso.agregarEspectador("1588888888", "cmadero@edu.com", "Carolina", "Madero", "DNI", 88888888, "Postgrado");

		
		System.out.println(congreso.traerEspectador());
		

		System.out.println("\n4) Agregar e imprimir las siguientes conferencias:");
		congreso.agregarConferencia("La BIGDATA en la Filosofía", LocalDate.of(2019, 10, 8), 12000);
		congreso.agregarConferencia("Ser o no ser en la era moderna", LocalDate.of(2019, 10, 8), 5000);
		congreso.agregarConferencia("El ABC de la filosofía", LocalDate.of(2019, 10, 9), 8000);


		congreso.traerConferencia(1).agregarAuspiciante(congreso.traerAuspiciante("30-11111111-9"));
		congreso.traerConferencia(1).agregarAuspiciante(congreso.traerAuspiciante("30-22222222-9"));
		congreso.traerConferencia(2).agregarAuspiciante(congreso.traerAuspiciante("30-33333333-9"));
		congreso.traerConferencia(3).agregarAuspiciante(congreso.traerAuspiciante("30-44444444-9"));

		System.out.println(congreso.getLstConferencias());

		System.out.println("\n5) Agregar e imprimir las siguientes entradas:");

		congreso.agregarEntrada("9561755", 500, congreso.traerEspectador(55555555), congreso.traerConferencia(1));
		congreso.agregarEntrada("8492747", 600, congreso.traerEspectador(55555555), congreso.traerConferencia(2));
		congreso.agregarEntrada("6472949", 900, congreso.traerEspectador(55555555), congreso.traerConferencia(3));
		congreso.agregarEntrada("2514741", 500, congreso.traerEspectador(66666666), congreso.traerConferencia(1));
		congreso.agregarEntrada("6738262", 600, congreso.traerEspectador(66666666), congreso.traerConferencia(2));
		congreso.agregarEntrada("8795638", 600, congreso.traerEspectador(77777777), congreso.traerConferencia(2));
		congreso.agregarEntrada("7462839", 600, congreso.traerEspectador(77777777), congreso.traerConferencia(3));
		congreso.agregarEntrada("6742459", 750, congreso.traerEspectador(77777777), congreso.traerConferencia(1));


		System.out.println("\n6) Intentar agregar entrada inválida:");
		try {
			congreso.agregarEntrada("2257435", 1100, congreso.traerEspectador(77777777), congreso.traerConferencia(3));
		} catch (Exception ex) {
			System.out.println("Error al agregar entrada: " + ex.getMessage());
		}

		System.out.println("\n7) Entradas del día 08/10/2019:");
		//for (Entrada ent : congreso.traerEntrada(LocalDate.of(2019, 10, 8))) {
			System.out.println(congreso.traerEntrada(LocalDate.of(2019, 10, 8)));
		//}

		System.out.println("\n8) Conferencias del día 09/10/2019:");
		for (Conferencia conf : congreso.traerConferencia(LocalDate.of(2019, 10, 9))) {
			System.out.println(conf);
		}

		System.out.println("\n9) Balance del Congreso del día 08/10/2019:");
		System.out.println("Balance: " + congreso.calcularBalance(LocalDate.of(2019, 10, 8)));

	 
	}

}