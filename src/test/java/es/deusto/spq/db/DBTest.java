package es.deusto.spq.db;

import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.Test;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;

public class DBTest {
	
	private DB db = new DB();
	private Usuario u = new Usuario();
	
	//Anotación, algunos metodos estan probados juntos como eliminar y añadir para evitar fallos en la Base de Datos por el orden de ejecución, es decir duplicar entradas

	@Test
	public void insertarUsuario() throws SQLException {
		db.eliminarUsuario("Victor1", "gestion_biblioteca_db_pruebas");
		u = new Usuario("Victor1", "Vic", "ug", 1, "1234");
		db.insertarUsuario(u, "gestion_biblioteca_db_pruebas");
		assertEquals(true, db.comprobarUsuario("Victor1", "gestion_biblioteca_db_pruebas"));

	}
	
	@Test
	public void numLibrosPublicados() throws SQLException {
		assertEquals(10, db.numLibrosPublicados("Vanesa Redondo", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void anyoNacAutor() throws SQLException {
		assertEquals(1980, db.anyoNacAutor("Vanesa Redondo", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void lugarNacAutor() throws SQLException {
		assertEquals("Salamanca", db.LugarNacAutor("Vanesa Redondo", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void libroAutor() throws SQLException {
		Libro l = new Libro("EL LEGADO DE LOS MALDITOS", "Vanesa Redondo",	356, 4342343, "", 1, null, null);
		assertEquals(l.getAutor(), db.buscarLibroAutor("Vanesa Redondo", "gestion_biblioteca_db_pruebas").get(0).getAutor());
	}
	
	@Test
	public void ubicacionLibro() throws SQLException {
		assertEquals("Planta 3 Pasillo 1 Estanteria 4", db.buscarUbicacionLibro("1793", "gestion_biblioteca_db_pruebas"));
	}
	
	
	@Test
	public void LibroPrestado() throws SQLException {
		db.tomarPrestadoLibro("1793", "gestion_biblioteca_db_pruebas");
		db.devolverLibroPrestado("1793", "gestion_biblioteca_db_pruebas");
		assertEquals(0, db.comprobarLibroPrestado("1793", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void comprobarContrasenyaUsuario() throws SQLException {
		assertEquals("1234", db.comprobarContrasenya("Victor1", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void comprobarContrasenyaBibliotecario() throws SQLException {
		assertEquals("1234", db.comprobarContrasenyaBibliotecario("admin1", "gestion_biblioteca_db_pruebas"));
	}
	
	
	@Test
	public void anyadirLibro() throws SQLException {
		Libro l = new Libro("a", "a", 1, 4321, "", 1, "g", "e");
		db.eliminarLibro("a", "gestion_biblioteca_db_pruebas");
		db.AnyadirLibro(l, "gestion_biblioteca_db_pruebas");
		assertEquals(l.getTitulo(), db.buscarLibroTitulo("a", "gestion_biblioteca_db_pruebas").getTitulo());
	}
	
	@Test
	public void libroISBN() throws SQLException {
		Libro l = new Libro("1793", "Niklas Natt Och Dag", 354, 484841, "", 0, null, null);
		assertEquals(l.getISBN(), db.buscarLibroISBN(484841, "gestion_biblioteca_db_pruebas").getISBN());
	}	

}
