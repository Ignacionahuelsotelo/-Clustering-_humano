package logica;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class Assert {

	public static void iguales(Persona[] esperados, Set<Persona> alcanzables) {
		assertEquals(esperados.length,alcanzables.size());		
		for(Persona element : esperados) {
			assertTrue(alcanzables.contains(element));
		}
	}

}
