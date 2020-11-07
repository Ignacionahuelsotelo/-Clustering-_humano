package logica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	Persona p1;
	Persona p2;
	Persona p3;

	@Before
	public void setUp() throws Exception {
		p1 = new Persona("A", 1, 1, 1, 1, 1,null);
		p2 = new Persona("B", 1, 1, 1, 1, 1,null);
		p3 = new Persona("C", 1, 1, 3, 4, 1,null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void interesNegativoTest() {
		new Persona("C", -1, 1, 1, 1, 1,null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void interesMayorACincoTest() {
		new Persona("C", 1, 1, 6, 1, 1,null);
	}

	@Test
	public void interesesIguales() {
		assertEquals(0, p1.indiceDeSimilaridad(p2));
	}

	@Test
	public void interesesDiferentes() {
		assertEquals(5, p1.indiceDeSimilaridad(p3));
	}

}
