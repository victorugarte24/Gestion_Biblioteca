package es.deusto.spq.clases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.clases.Libro;

public class LibroTest {
	
	Libro l;
	ArrayList<String> opiniones;
	ArrayList<String> usuarios;
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	@Before
	public void setUp() {
		l = new Libro("La casa de papel", "Juan Ramon García", 2324, 23232313, "Genero", 0, "Novela", "Pancarta");
		opiniones = new ArrayList<>();
		opiniones.add("opinion");
		usuarios = new ArrayList<>();
		usuarios.add("usuario");
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
	
	@Test
	public void cambiarGenero() {
		l.setGenero("No hay");
		assertEquals("No hay", l.getGenero());
		
	}
	
	@Test
	public void cambiarOpiniones() {
		l.setOpiniones(opiniones);
		assertEquals("opinion", l.getOpiniones().get(0));
		
	}
	
	@Test
	public void cambiarEditorial() {
		l.setEditorial("Editorial");
		assertEquals("Editorial", l.getEditorial());
		
	}
	
	@Test
	public void cambiarUsuario() {
		l.setUsuarios(usuarios);
		assertEquals("usuario", l.getUsuarios().get(0));
	}
	
	@Test
	public void metodoToString() {
		l.setTitulo("La casa");
		l.setAutor("Pedro Jimenez");
		l.setNumPags(245);
		l.setISBN(23213323);
		l.setSinopsis("No hay");
		l.setPrestado(1);
		l.setEditorial("Editorial");
		assertEquals("LA CASA\n" + "Autor: Pedro Jimenez\n" + "Numero de paginas: 245\n" + "ISBN: 23213323\n" + "Sinopsis: No hay\n" + "Prestado: 1\n" + "Genero: Novela\n" + "Editorial: Editorial", l.toString());
	}
}
