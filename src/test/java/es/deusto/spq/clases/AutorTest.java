package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AutorTest {
    private Autor a; 

	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	}
	
	@Before
	public void setUp() {
		a = new Autor();
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
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
