package datos;

import logica.Grafo;
import logica.Persona;
import logica.Clasificador;

public class GestorJSON {
	public static PersonasJSON lasPersonas = new PersonasJSON();

//	public static void main(String[] args) {
//		Persona p1 = new Persona("Melina", 0, 0, 0, 0, 0);
//		Persona p2 = new Persona("Rororo", 0, 0, 0, 0, 0);
//		Persona p3 = new Persona("Perrito", 2, 2, 2, 2, 2);
//		Persona p4 = new Persona("Perro", 3,3,3,3,3);
//		Persona p5 = new Persona("Perr",3,3,3,3,3);
//		
//		agregarPersonas(p1);
//		agregarPersonas(p2);
//		agregarPersonas(p3);
//		agregarPersonas(p4);
//		agregarPersonas(p5);
//		
//		guardarPersonas();
//	}
	
	public static void agregarPersonas (Persona persona) {
		lasPersonas.addPersona(persona);
	}
	
	public static void guardarPersonas () {
		String jsonPretty = lasPersonas.generarJSONPretty();
		lasPersonas.guardarJSON(jsonPretty, "PersonasPretty.JSON");
	}

}
