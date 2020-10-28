package logica;

public class ClusteringConsola {

	public static void main(String[] args) {
		Persona p1 = new Persona("Melina", 0, 0, 0, 0, 0);
		Persona p2 = new Persona("Rororo", 0, 0, 0, 0, 0);
		Persona p3 = new Persona("Perrito", 2, 2, 2, 2, 2);
		Persona p4 = new Persona("Perro", 3,3,3,3,3);
		Persona p5 = new Persona("Perr",3,3,3,3,3);
	
		Clasificador cl = new Clasificador ();
		cl.agregarPersonas(p1);
		cl.agregarPersonas(p2);
		cl.agregarPersonas(p3);
		cl.agregarPersonas(p4);
		cl.agregarPersonas(p5);
		cl.grafo.completarGrafo();
		cl.agruparPersonas();

	}

}
