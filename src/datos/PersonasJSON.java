package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.*;

import logica.Persona;

public class PersonasJSON {
	private ArrayList<Persona> personas;

	public PersonasJSON() {
		personas = new ArrayList<Persona>();
	}

	public void addPersona(Persona persona) {
		personas.add(persona);
	}

	public int tamanio() {
		return personas.size();
	}

	public String generarJSONBasico() {
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(this);

		return json;
	}

	public String generarJSONPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);

		return json;
	}

	public void guardarJSON(String jsonParaGuardar, String archivoDestino) {
		try {
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static PersonasJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		PersonasJSON ret = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, PersonasJSON.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<String> getPersonasString (){
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < this.personas.size(); i++) {
			ret.add(personas.get(i).toString());
		}
		return ret;
	}
}
