package datos;

import logica.Persona;

public class GestorJSON {
	public static PersonasJSON lasPersonas = new PersonasJSON();

	public static void agregarPersonas(Persona persona) {
		lasPersonas.addPersona(persona);
	}

	public static void guardarPersonas() {
		String jsonPretty = lasPersonas.generarJSONPretty();
		lasPersonas.guardarJSON(jsonPretty, "usuarios.JSON");
	}

}
