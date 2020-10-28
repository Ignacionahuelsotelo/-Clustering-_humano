package logica;

public class MainJSON {

	public static void main(String[] args) {
		Persona p1 = new Persona("Melina", 1, 5, 4, 3, 2);
		Persona p2 = new Persona("Ro", 1, 2, 3, 4, 5);
		Persona p3 = new Persona("Perrito", 1, 3, 5, 1, 2);

		PersonasJSON lasPersonas = new PersonasJSON();

		lasPersonas.addPersona(p1);
		lasPersonas.addPersona(p2);
		lasPersonas.addPersona(p3);

		String jsonBasico = lasPersonas.generarJSONBasico();
		String jsonPretty = lasPersonas.generarJSONPretty();

		lasPersonas.guardarJSON(jsonBasico, "Personas.JSON");
		lasPersonas.guardarJSON(jsonPretty, "PersonasPretty.JSON");

	}

}
