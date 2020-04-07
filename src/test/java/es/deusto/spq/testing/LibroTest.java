package es.deusto.spq.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.clases.Libro;

public class LibroTest {
	
	Libro l;

	@Before
	public void setUp() {
		l = new Libro("La casa de papel", "Juan Ramon García", 2324, 23232313, "Nada", 0);
	}
	
	@Test
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
