package es.deusto.spq.db;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;

public class DBTest {
	
	private DB db = new DB();
	private Usuario u = new Usuario();
	Libro l = new Libro("1793", "Niklas Natt Och Dag", 354, 484841, "", 0, null, null);
	
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
	
	@Test
	public void darDislike() throws SQLException {
		db.darDislike("1793", 5, "gestion_biblioteca_db_pruebas");
		assertEquals(5, db.getDislikes("1793", "gestion_biblioteca_db_pruebas"));
	}	
	
	@Test
	public void darLike() throws SQLException {
		db.darLike("1793", 5, "gestion_biblioteca_db_pruebas");
		assertEquals(5, db.getLikes("1793", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getOpUsuarios() throws SQLException {
		ArrayList<String> usuarios = new ArrayList<>();
		usuarios.add("usuario1");
		assertEquals(usuarios, db.getOpUsuarios(l, "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getOpOpiniones() throws SQLException {
		ArrayList<String> opiniones = new ArrayList<>();
		opiniones.add("Buen Libro");
		assertEquals(opiniones, db.getOpOpiniones(l, "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void devolverLikeDislikeUsuario() throws SQLException {
		assertEquals(1, db.devolverLikeDislikeUsuarioLibro("1793", "usuario1", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getTop10() throws SQLException {
		ArrayList<String> top10 = new ArrayList<>();
		top10 = db.getTop10("gestion_biblioteca_db_pruebas");
		assertEquals(top10, db.getTop10("gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getListaAdministradores() throws SQLException {
		ArrayList<String> administradores = new ArrayList<>();
		administradores.add("admin1");
		assertEquals(administradores, db.getListaAdministradores("gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getListaLikes() throws SQLException {
		ArrayList<Integer> likes = new ArrayList<>();
		likes = db.getListaLikes("gestion_biblioteca_db_pruebas");
		assertEquals(likes, db.getListaLikes("gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getListaDisLikes() throws SQLException {
		ArrayList<Integer> dislikes = new ArrayList<>();
		dislikes = db.getListaDislikes("gestion_biblioteca_db_pruebas");
		assertEquals(dislikes, db.getListaDislikes("gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getTitulolibros() throws SQLException {
		ArrayList<String> libros = new ArrayList<>();
		libros.add("1793");
		libros.add("a");
		libros.add("Croata");
		libros.add("Cronicas de la Torre");
		libros.add("El cuerpo humano");
		libros.add("El legado de los malditos");
		libros.add("El senyor de los Anillos");
		libros.add("El silencio de la lengua");
		libros.add("La cara norte del corazón");
		libros.add("La chica de nieve");
		libros.add("La madre de Frankenstein");	
		libros.add("Loba negra");	
		libros.add("Reina roja");	
		libros.add("Romeo y Julieta");	
		libros.add("Sidi");	
		libros.add("Un cuento perfecto");			
		libros.add("Y Julia retó a los dioses");
		assertEquals(libros, db.getTituloLibros("gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getUsuario() throws SQLException {
		assertEquals(null, db.getUsuario("usuarionnoexiste", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getOpISBN() throws SQLException {
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(484841);
		assertEquals(lista, db.getOpISBN("gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void modificarOpiniones() throws SQLException {
		Libro l = new Libro("a", "", 0, 4321, "", 0, "", "");
		ArrayList<String> usuarios = new ArrayList<>();
		usuarios.add("usuario1");
		ArrayList<String> opiniones = new ArrayList<>();
		db.modificarOpiniones(l, usuarios, opiniones,"gestion_biblioteca_db_pruebas");
		assertArrayEquals(opiniones.toArray(), db.getOpOpiniones(l, "gestion_biblioteca_db_pruebas").toArray());
	}
	
	/*
	@Test
	public void insertarOpiniones() throws SQLException {
		ArrayList<String> usuarios = new ArrayList<>();
		usuarios.add("usuario1");
		ArrayList<String> opiniones = new ArrayList<>();
		usuarios.add("AAAAA");
		Libro l = new Libro("prueba", "Niklas Natt Och Dag", 354, 484841, "", 0, null, null);
		db.insertarOpiniones(l, usuarios, opiniones, "gestion_biblioteca_db_pruebas");
		assertEquals("Buen Libro", db.getOpOpiniones(l, "gestion_biblioteca_db_pruebas"));
		
	} 
	
	@Test
	public void insertarLikeDislikeUsuario() throws SQLException {
		assertEquals(1, db.devolverLikeDislikeUsuarioLibro("1793", "usuario1", "gestion_biblioteca_db_pruebas"));
	}
	
	@Test
	public void getListaUsuarios() throws SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("usuario", "Victor", "Ugarte", 123232, "12345"));
		usuarios.add(new Usuario("usuario1", "Victor", "Ugarte", 434242, "1234"));
		usuarios.add(new Usuario("Vic", "ug", "Victor1", 1, "1234"));
		usuarios.add(new Usuario("Victor1", "Vic", "ug", 1, "1234"));
		assertEquals(usuarios, db.getListaUsuarios("gestion_biblioteca_db_pruebas"));
	}
	
		@Test
	public void getUsuario1() throws SQLException {
		Usuario u = new Usuario("usuario1", "Victor", "Ugarte", 12344, "11111");
		String usuario = "Usuario: usuario1 Nombre: Victor Apellido: Ugarte";
		Usuario z = db.getUsuario("usuario1", "gestion_biblioteca_db_pruebas");
		assertEquals(u, z);
	}
		
	*/
}
