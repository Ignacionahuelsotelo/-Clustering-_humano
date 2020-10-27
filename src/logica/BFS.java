package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS<T> {

	private static ArrayList<Persona> pendientes;
	private static boolean[] marcados;
	

	
	public static boolean esConexo(Grafo g) {
		if(g==null)
			throw new IllegalArgumentException("Se intento consultar un grafo null");
		
		Persona origen = g.vertices().get(0);
		Set<Persona> alcanzables = alcanzables(g,origen);
		
		return alcanzables.size() == g.tamanio();
	}


	public static Set<Persona> alcanzables(Grafo grafo, Persona origen) {
		Set<Persona> alcanzados = new HashSet<Persona>();
		inicializar(grafo,origen);
		
		while (pendientes.size()>0) {
			Persona actual = pendientes.get(0);
			marcados[grafo.obtenerIndice(actual)]=true;
			agregarVecinosPendientes(grafo, actual);
			alcanzados.add(actual);
			pendientes.remove(0);
		}
		return alcanzados;
	}


	private static void agregarVecinosPendientes(Grafo grafo, Persona actual) {
		int i = grafo.vertices().indexOf(actual);
		for (Persona vecino : grafo.vecinos(i)) {
			if(!marcados[grafo.obtenerIndice(vecino)] && !pendientes.contains(vecino)) {
				pendientes.add(vecino);
			}
		}
	
	}


	private static void inicializar(Grafo grafo, Persona origen) {
		pendientes= new ArrayList<Persona>();
		pendientes.add(origen);
		marcados = new boolean[grafo.vertices().size()];
		
	}

}
