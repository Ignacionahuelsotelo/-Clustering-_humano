package logica;

import java.util.ArrayList;
import java.util.Set;

public class ClusteringConsola {

	public static void main(String[] args) {
		Clasificador cl = new Clasificador ();
		
		cl.cargarPersona("Melina", 0, 0, 0, 0, 0,null);
		cl.cargarPersona("Rororo", 0, 0, 0, 0, 0,null);
		cl.cargarPersona("Perrito", 2, 2, 2, 2, 2,null);
		cl.cargarPersona("Perro", 3,3,3,3,3,null);
		cl.cargarPersona("Perr",3,3,3,3,3,null);
	
		
		ArrayList<Set<Persona>> grupos = cl.agruparPersonas();
	
		Set<Persona> grupo1= grupos.get(0);
		Set<Persona> grupo2= grupos.get(1);
		System.out.println("Grupo1 =" + grupo1.toString());
		System.out.println("Grupo2 =" + grupo2.toString());

	}

}
