package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Clasificador {
	public Grafo grafo;
	ArrayList<Persona> personas;
	Set<Persona> grupo1;
	Set<Persona> grupo2;

	public Clasificador() {
		personas = new ArrayList<Persona>();
		grafo = new Grafo();

	}

	public void agregarPersonas(Persona persona) {
		if (persona == null)
			throw new NullPointerException("No se puede agregar una persona null");

		if (!personas.contains(persona)) {
			personas.add(persona);
			grafo.agregarVertice(persona);
		}
	}

	public void completarGrafo() {
		grafo = new Grafo();
		for (int i = 0; i < personas.size(); i++) {
			grafo.agregarVertice(personas.get(i));
		}
		grafo.completarGrafo();
	}

	// Carga los atributos de las personas y las agrega a personas
	public void cargarPersona(String nombre, int musica, int deporte, int espectaculo, int ciencia, int arte) {
		Persona persona = new Persona(nombre, musica, deporte, espectaculo, ciencia, arte);
		agregarPersonas(persona);
	}

	public Grafo dividirGrafo() {
		if(grafo.tamanio()<2)
			return grafo;
		completarGrafo();
		Grafo nuevo = AGM.generadoMin(grafo);
		nuevo.eliminarNodoMasPesado();
		return nuevo;
	}

	public ArrayList<Set<Persona>> agruparPersonas() {
		Grafo nuevo = dividirGrafo();
		ArrayList<Set<Persona>> grupos = new ArrayList<Set<Persona>>();
		grupo1 = BFS.alcanzables(nuevo, 0);
		grupo2 = new HashSet<Persona>();
		for (int i = 0; i < personas.size(); i++) {
			if (!grupo1.contains(personas.get(i))) {
				grupo2.add(personas.get(i));
			}
		}
		grupos.add(grupo1);
		grupos.add(grupo2);
		
		return grupos;

	}

	public Grafo getGrafo() {
		return this.grafo;
	}
	
	public Set<Persona> getGrupo1(){
		return grupo1;
	}
	
	public Set<Persona> getGrupo2(){
		return grupo2;
	}

	@Override
	public String toString() {
		return "Grupo1=" + grupo1 + ", Grupo2=" + grupo2;
	}
	
	

}
