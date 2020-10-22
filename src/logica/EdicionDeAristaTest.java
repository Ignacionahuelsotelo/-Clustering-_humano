package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EdicionDeAristaTest {
	Grafo grafo = new Grafo(5);
	Persona p1;
	Persona p2;
	Persona p3;
	Persona p4;
	Persona p5;

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo(5);
		p1 = new Persona("A", 1, 1, 1, 1, 1);
		p2 = new Persona("B", 1, 1, 1, 1, 1);
		p3 = new Persona("C", 1, 1, 1, 1, 1);
		p4  = new Persona("D", 1, 1, 1, 1, 1);
		p5  = new Persona("E", 1, 1, 1, 1, 1);
		grafo.agregarVertice(p1);
		grafo.agregarVertice(p2);
		grafo.agregarVertice(p3);
		grafo.agregarVertice(p4);
		grafo.agregarVertice(p5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest() {
		grafo.agregarArista(p1,p2,-1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest() {
		grafo.agregarArista(p1,p2,5, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		grafo.agregarArista(p2,p1,1, -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest() {
		grafo.agregarArista(p1,p2,1, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopsTest() {
		grafo.agregarArista(p2,p2,1, 1);
	}

	@Test
	public void testExisteArista() {
		grafo.agregarArista(p3,p4,2, 3);
		assertTrue(grafo.existeArista(p3, 3));
		assertFalse(grafo.existeArista(p2, 1));
	}

	@Test
	public void testExisteAristaOpuesta() {
		grafo.agregarArista(p3,p4,2, 3);
		assertTrue(grafo.existeArista(p4, 2));
	}

	@Test
	public void testAristaInexistente() {
		grafo.agregarArista(p3,p4,2, 3);
		assertFalse(grafo.existeArista(p2, 1));
	}

	@Test
	public void eliminarAristaExistente() {
		grafo.agregarArista(p3,p5,2, 4);
		grafo.eliminarArista(p3,p5,2, 4);
		assertFalse(grafo.existeArista(p3, 4));
	}

	@Test
	public void eliminarAristaInexistente() {
		grafo.eliminarArista(p3,p5,2, 4);
		assertFalse(grafo.existeArista(p3, 4));
	}

	@Test
	public void eliminarAristaDosVeces() {
		grafo.agregarArista(p3,p5,2, 4);
		grafo.eliminarArista(p3,p5,2, 4);
		grafo.eliminarArista(p3,p5,2, 4);
		assertFalse(grafo.existeArista(p3, 4));
	}

	@Test
	public void agregarAristaDosVeces() {
		grafo.agregarArista(p3,p5,2, 4);
		grafo.agregarArista(p3,p5,2, 4);
		assertTrue(grafo.existeArista(p3, 4));
	}

}
