package logica;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BFSTest {

	Grafo grafo;
	Persona p1;
	Persona p2;
	Persona p3;
	Persona p4;

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo(3);
		p1 = new Persona("A", 1, 1, 1, 1, 1);
		p2 = new Persona("B", 1, 1, 1, 1, 1);
		p3 = new Persona("C", 1, 1, 1, 1, 1);
		p4  = new Persona("D", 1, 1, 1, 1, 1);
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarVertice(p4);
		grafo.agregarArista(p1, p2, 0, 1);
		grafo.agregarArista(p1, p3, 0, 2);
		grafo.agregarArista(p3, p4, 2, 3);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFS.esConexo(null);
	}

	@Test
	public void testConexo() {
		Set<Integer> alcanzables = BFS.alcanzables(grafo,0);
		int[] esperados = {0,1,2,3};
		
		Assert.iguales(esperados, alcanzables);
		
	}
	
	public void testDesconexo() {
		grafo.eliminarArista(p3, p4, 2, 3);
	}
}




