package logica;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ConsultaDeVecinosTest {
	Grafo grafo;
	Persona p1;
	Persona p2;
	Persona p3;
	Persona p4;
	Persona p5;

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo();
		p1 = new Persona("A", 1, 1, 1, 1, 1,null);
		p2 = new Persona("B", 1, 1, 1, 1, 1,null);
		p3 = new Persona("C", 1, 1, 1, 1, 1,null);
		p4  = new Persona("D", 1, 1, 1, 1, 1,null);
		p5  = new Persona("E", 1, 1, 1, 1, 1,null);
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarVertice(p4);
		grafo.agregarVertice(p5);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void vacinosNegativosTest() {
		grafo.vecinos(-2).size();
	}

	@Test(expected = IllegalArgumentException.class)
	public void vacinosExcedidosTest() {		
		grafo.vecinos(6).size();
	}

	@Test
	public void todosAisladosTest() {
		assertEquals(0, grafo.vecinos(2).size());
	}

	@Test
	public void verticeUniversalTest() {
		grafo.agregarArista( 1, 0);
		grafo.agregarArista( 1, 2);
		grafo.agregarArista(1, 3);
		Set<Persona> set = grafo.vecinos(1);
		assertEquals(3, set.size());
		assertTrue(set.contains(p1));
		assertTrue(set.contains(p3));
		assertTrue(set.contains(p4));
	}

	@Test
	public void verticeNormal() {
		grafo.agregarArista(1, 3);
		grafo.agregarArista( 2, 3);
		grafo.agregarArista(2, 4);
		Set<Persona> set = grafo.vecinos(3);
		assertEquals(2, set.size());
		assertTrue(set.contains(p2));
		assertTrue(set.contains(p3));
	}

	@Test
	public void noCompletoTest() {
		assertFalse(grafo.esCompleto());
	}
	
	@Test
	public void completoTest() {
		grafo.completarGrafo();
		assertTrue(grafo.esCompleto());
	}
	
	@Test
	public void completoUnicoVertice() {
		Grafo g = new Grafo();
		g.agregarVertice(p1);
		assertTrue(g.esCompleto());
	}
	
}
