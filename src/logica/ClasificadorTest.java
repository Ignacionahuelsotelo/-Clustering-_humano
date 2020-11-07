package logica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ClasificadorTest {
	Clasificador c;
	Persona p1;
	Persona p2;
	Persona p3;
	Persona p4;
	Persona p5;

	@Before
	public void setUp() throws Exception {
		c = new Clasificador();

		c.cargarPersona("Melina", 0, 0, 0, 0, 0, null);
		c.cargarPersona("Rororo", 0, 0, 0, 0, 0, null);
		c.cargarPersona("Perrito", 2, 2, 2, 2, 2, null);
		c.cargarPersona("Perro", 3, 3, 3, 3, 3, null);
		c.cargarPersona("Perr", 3, 3, 3, 3, 3, null);

		p1 = new Persona("Melina", 0, 0, 0, 0, 0, null);
		p2 = new Persona("Rororo", 0, 0, 0, 0, 0, null);
		p3 = new Persona("Perrito", 2, 2, 2, 2, 2, null);
		p4 = new Persona("Perro", 3, 3, 3, 3, 3, null);
		p5 = new Persona("Perr", 3, 3, 3, 3, 3, null);
	}

	@Test(expected = NullPointerException.class)
	public void agregarPersonaNullTest() {
		c.agregarPersonas(null);
	}

	@Test
	public void agregarPersonaTest() {
		c.cargarPersona("H", 1, 1, 1, 1, 1, null);
		Persona p = new Persona("H", 1, 1, 1, 1, 1, null);
		assertTrue(c.getGrafo().esUnVertice(p));
		;
	}

	@Test
	public void personaNoAgregadaTest() {
		c.cargarPersona("H", 1, 1, 1, 1, 1, null);
		Persona p = new Persona("M", 1, 1, 1, 1, 1, null);
		assertFalse(c.getGrafo().esUnVertice(p));
		;
	}

	@Test
	public void completarGrafoTest() {
		c.completarGrafo();
		assertTrue(c.getGrafo().esCompleto());
	}

	@Test
	public void dividirGrafoTest() {
		Grafo dividido = c.dividirGrafo();
		assertFalse(BFS.esConexo(dividido));
	}

	@Test
	public void ClasificarGrafoGrupo1Test() {
		ArrayList<Set<Persona>> grupos = c.agruparPersonas();

		Set<Persona> g1 = new HashSet<Persona>();
		g1.add(p1);
		g1.add(p2);

		assertFalse(grupos.get(1).equals(g1));

	}

	@Test
	public void ClasificarGrafoGrupo2Test() {
		ArrayList<Set<Persona>> grupos = c.agruparPersonas();

		Set<Persona> g2 = new HashSet<Persona>();
		g2.add(p3);
		g2.add(p4);
		g2.add(p5);
		assertFalse(grupos.get(0).equals(g2));

	}

}
