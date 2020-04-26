package es.deusto.spq.clases;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BibliotecarioTest {

	Bibliotecario b;

	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	@Before
	public void setUp() {
		b = new Bibliotecario(10, "Jose", "Garcia");
	}

	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
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
