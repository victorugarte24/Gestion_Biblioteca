package es.deusto.spq.clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.clases.Usuario;

public class UsuarioTest {

	private Usuario u;
	
	@Before
	public void setUp() {
		u = new Usuario("Juan", "López", "user", 232323, "1234");
	}

	@Test
	public void testNombre() {
		u.setNombre("Pepe");
		assertEquals("Pepe", u.getNombre());
	}
	
	@Test
	public void testApellido() {
		u.setApellido("Lopez");
		assertEquals("Lopez", u.getApellido());
	}
	
	@Test
	public void testContrasenya() {
		u.setContrasenya("12345");
		assertEquals("12345", u.getContrasenya());
	}
	
	@Test
	public void testUsuario() {
		u.setUsuario("user1999");
		assertEquals("user1999", u.getUsuario());
	}
	
	@Test
	public void testDNI() {
		u.setDNI(323213);
		assertEquals(323213, u.getDNI());
	}
}
