package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AGMTest {

	AGM agm;
	Grafo grafo;
	Persona p0;
	Persona p1;
	Persona p2;
	Persona p3;

	@Before
	public void setUp() throws Exception {
		
		grafo = new Grafo(3);
		p0 = new Persona("A", 5, 5, 5, 5, 5);
		p1 = new Persona("B", 4, 4, 4, 4, 4);
		p2 = new Persona("C", 0, 0, 0, 0, 0);
		p3  = new Persona("D", 2, 2, 2, 2, 2);
		grafo.agregarVertice(p0);
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.completarGrafo();

		agm = new AGM(grafo);
	}

	@Test
	public void test() {
		Grafo minimo = agm.generadoMin();
		assertFalse(minimo.existeArista(0, 2));
	}

}
