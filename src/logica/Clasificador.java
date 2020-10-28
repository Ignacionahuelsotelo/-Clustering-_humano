package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Clasificador {
	public Grafo grafo;
	ArrayList <Persona> personas;
	
	public Clasificador () {
		personas = new ArrayList <Persona> ();
		grafo = new Grafo (5);
		
	}
	
	public void agregarPersonas (Persona persona) {
		if (!personas.contains(persona)) {
		personas.add(persona);
		grafo.agregarVertice(persona);	
		}
	}

	public void completarGrafo() {
		grafo = new Grafo(personas.size());
		for (int i = 0; i < personas.size(); i++) {
			grafo.agregarVertice(personas.get(i));
		}
		grafo.completarGrafo();
	}

	//Carga los atributos de las personas y las agrega a personas
	public void cargarPersona (String nombre, int musica, int deporte, int espectaculo, int ciencia, int arte) {
		Persona persona = new Persona (nombre, musica, deporte, espectaculo, ciencia, arte);
		personas.add(persona);	
	}
	
	public Grafo dividirGrafo () {
		completarGrafo();
		Grafo nuevo = AGM.generadoMin(grafo);
		nuevo.eliminarNodoMasPesado();
		return nuevo;
	}
	
	public void agruparPersonas () {
		Grafo nuevo = dividirGrafo();
		Set <Persona> grupo1 = BFS.alcanzables(nuevo, 0);
		Set <Persona> grupo2 = new HashSet<Persona> ();
		for (int i = 0 ; i< personas.size(); i++) {
			if (!grupo1.contains(personas.get(i))) {
				grupo2.add(personas.get(i));
			}
		}
		System.out.println("Grupo1 =" + grupo1.toString());
		System.out.println("Grupo2 =" + grupo2.toString());
		
	}
	
	
	
	
	
	
	
	
	
}


