package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

class BibliotecarioTest {
Bibliotecario b;
	
	@Before
	public void setUp() {
		b = new Bibliotecario(10, "Jose", "Garcia");
	}
	
	@Test
	public void testID() {
		b.setID(1);
		assertEquals(1, b.getID());
	}
	
	@Test
	public void testNombre() {
		b.setNombre("Ramon");
		assertEquals("Ramon", b.getNombre());
	}
	
	@Test
	public void testApell() {
		b.setApellido("Jimenez");
		assertEquals("Jimenez", b.getApellido());
	}

}
