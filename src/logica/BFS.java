package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS<T> {

	private static ArrayList<Persona> lista;
	private static boolean[] marcados;
	

	
	public static boolean esConexo(Grafo g) {
		if(g==null)
			throw new IllegalArgumentException("Se intento consultar un grafo null");
		
		Persona origen = g.vertices().get(0);
		Set<Persona> alcanzables = alcanzables(g,origen);
		
		return alcanzables.size() == g.tamanio();
	}


	public static Set<Persona> alcanzables(Grafo grafo, Persona origen) {
		Set<Persona> ret = new HashSet<Persona>();
		inicializar(grafo,origen);
		
		while (lista.size()>0) {
			Persona actual = lista.get(0);
			marcados[grafo.vertices().indexOf(actual)]=true;
			agregarVecinosPendientes(grafo, actual);
			ret.add(actual);
			lista.remove(0);
		}
		return ret;
	}


	private static void agregarVecinosPendientes(Grafo grafo, Persona actual) {
		int i = grafo.vertices().indexOf(actual);
		ArrayList<Persona> vertices = grafo.vertices();
		for (Persona vecino : grafo.vecinos(i)) {
			if(!marcados[vertices.indexOf(vecino)] && !lista.contains(vecino)) {
				lista.add(vecino);
			}
		}
	
	}


	private static void inicializar(Grafo grafo, Persona origen) {
		lista= new ArrayList<Persona>();
		lista.add(origen);
		marcados = new boolean[grafo.vertices().size()];
		
	}

}
