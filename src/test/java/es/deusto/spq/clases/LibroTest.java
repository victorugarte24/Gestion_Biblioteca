package es.deusto.spq.clases;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.clases.Libro;

public class LibroTest {
	
	Libro l;
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	@Before
	public void setUp() {
		l = new Libro("La casa de papel", "Juan Ramon García", 2324, 23232313, "Nada", 0);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
	public void cambiarTitulo() {
		l.setTitulo("La casa");
		assertEquals("La casa", l.getTitulo());
	}
	
	@Test
	public void cambiarAutor() {
		l.setAutor("Pedro Jimenez");
		assertEquals("Pedro Jimenez", l.getAutor());
	}
	
	@Test
	public void cambiarNumPags() {
		l.setNumPags(245);
		assertEquals(245, l.getNumPags());
	}
	
	@Test
	public void cambiarISBN() {
		l.setISBN(23213323);
		assertEquals(23213323, l.getISBN());
	}
	
	@Test
	public void cambiarSinopsis() {
		l.setSinopsis("No hay");
		assertEquals("No hay", l.getSinopsis());
	}
	
	@Test
	public void cambiarPrestado() {
		l.setPrestado(1);
		assertEquals(1, l.getPrestado());
	}
	


}
