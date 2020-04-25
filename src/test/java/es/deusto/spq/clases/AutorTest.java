package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

class AutorTest {

	Autor a;
	
	@Before
	public void setUp() {
		a = new Autor("Joanna Rowling",1965,"Inglaterra",23);
	}
	
	@Test
	public void testNombre() {
		a.setNombre("JK");
		assertEquals("JK", a.getNombre());
	}
	
	@Test
	public void testAnyo() {
		a.setanyoNacimiento(1964);
		assertEquals(1964, a.getanyoNacimiento());
	}
	
	@Test
	public void testLugar() {
		a.setlugarNacimiento("Yate");
		assertEquals("Yate", a.getlugarNacimiento());
	}
	
	@Test
	public void testNumLibros() {
		a.setnumLibrosPublicados(21);
		assertEquals(21, a.getnumLibrosPublicados());
	}
}
