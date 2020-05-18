package es.deusto.spq.clases;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.clases.Usuario;

public class UsuarioTest {

	private Usuario u;
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	@Before
	public void setUp() {
		u = new Usuario("Juan", "López", "user", 232323, "1234");
	}

	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
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
	
	@Test
	public void metodoToString() {
		u.setNombre("Pepe");
		u.setApellido("Lopez");
		u.setContrasenya("12345");
		u.setUsuario("user1999");
		System.out.println(u.toString());
		assertEquals("Usuario: user1999 Nombre: Pepe Apellido: Lopez", u.toString());
	}
}
