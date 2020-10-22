package logica;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class Assert {

	public static void iguales(int[] esperados, Set<Integer> alcanzables) {
		assertEquals(esperados.length,alcanzables.size());		
		for(int element:esperados) {
			assertTrue(alcanzables.contains(element));
		}
	}

}
