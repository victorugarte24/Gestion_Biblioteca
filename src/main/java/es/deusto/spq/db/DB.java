package es.deusto.spq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;

public class DB {

	public static Connection initBD(String BD) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BD +"?userTimezone=true&serverTimezone=UTC", "root", "admin");
			return con;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodo inserta un usuario en la base de datos
	 * 
	 * @param u Usuario a insertar en la base de datos
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void insertarUsuario(Usuario u, String BD) throws SQLException {
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String usuario = u.getUsuario();
		int dni = u.getDNI();
		String nombre = u.getNombre();
		String apellido = u.getApellido();
		String contrasenya = u.getContrasenya();
		String query = "INSERT INTO USUARIO  VALUES('" + usuario + "', "+ dni + ", '"+ nombre + "', '"+  apellido + "', '"+ contrasenya + "')";
		stmt.execute(query);
	}
	
	/**
	 * Este metodo recibe un usuario en base a su nickname
	 * 
	 * @param usuario Nickname del usuario a buscar en la base de datos
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el usuario encontrado en la base de datos o null si el usuario no se ha encontrado
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public Usuario getUsuario(String usuario, String BD) throws SQLException {
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		Usuario u = null;
		String query = "SELECT * FROM Usuario where usuario = '" + usuario + "'";
		ResultSet RS = stmt.executeQuery(query);
		while(RS.next()){
			u = new Usuario(RS.getString(1), RS.getString(2), RS.getString(3), RS.getInt(4), RS.getString(5));
		}
		
		return u;
	}

	/**
	 * Este metodo sirve para comprobar si el usuario existe o no existe
	 * 
	 * @param usuario Este parametro es el nombre de usuario
	 * @param BD Nombre de la base de datos a utilizar
	 * @return retorna el resultado booleano (0 o 1) que nos indica si el usuario existe o no
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public boolean comprobarUsuario(String usuario, String BD) throws SQLException {
		boolean respuesta = false;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT COUNT(*) AS total FROM usuario where usuario = '" + usuario +"'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			if( RS.getInt("total") > 0 ) {
				respuesta = true;//El usuario existe
			} else {
				respuesta = false; //El usuario no existe
			}
		}
		return respuesta;
	}

	/**
	 * Este metodo sirve para comprobar si la contraseña introducida es correcta
	 * 
	 * @param Usuario Este parametro es el nombre de usuario
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la contraseña
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public String comprobarContrasenya(String Usuario, String BD) throws SQLException {
		String contrasenya = "";
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT CONTRASENYA FROM usuario where usuario = '" + Usuario +"'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			contrasenya = RS.getString("Contrasenya");
		}
		return contrasenya;
	}

	/**
	 * Este metodo recopila todos los libros guardados en la base de datos
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el conjunto de libros en la base de datos en formato arrayList
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<Libro> getLibros(String BD) throws SQLException {
		ArrayList<Libro> array = new ArrayList<Libro>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT * FROM libro");
		while(RS.next()) {
			Libro l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7), RS.getString(8));
			array.add(l);
		}
		return array;
	}
	
	/**
	 * Este metodo recopila los titulos de todos los libros guardados en la base de datos
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el conjunto de titulos en la base de datos en formato de arrayList de Strings  
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<String> getTituloLibros(String BD) throws SQLException {
		ArrayList<String> array = new ArrayList<String>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT Titulo FROM libro");
		while(RS.next()) {
			array.add(RS.getString(1));
		}
		return array;
	}

	/**
	 * Este metodo anyade un libro a la base de datos 
	 * 
	 * @param l Libro a guardar en la base de datos
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void AnyadirLibro(Libro l, String BD) throws SQLException {
		String titulo = l.getTitulo();
		String autor = l.getAutor();
		int numPags = l.getNumPags();
		int ISBN = l.getISBN();
		String sinopsis = l.getSinopsis();
		int prestado = l.getPrestado();
		String genero = l.getGenero();

		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "INSERT INTO libro VALUES ('" + titulo +"','" + autor + "'," + numPags + "," + ISBN + ",'" + sinopsis + "'," + prestado + "'," + genero + ")";
		stmt.execute(query);
	}
	
	/**
	 * Este metodo compurueba el estado de un libro en cuanto a si esta prestado o no
	 * 
	 * @param titulo Titulo del libro a comprobar
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve 1 o 0 en funcion si el libro esta prestado o no. Por defecto devuelve 0
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public int comprobarLibroPrestado(String titulo, String BD) throws SQLException {
		int prestado = 0;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT PRESTADO FROM LIBRO WHERE TITULO = '" + titulo +"'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			prestado = RS.getInt("Prestado");
		}
		return prestado;
	}
	
	/**
	 * Este metodo actualiza el estado del libro poniendolo a "prestado" (prestado = 1)
	 * 
	 * @param titulo Titulo del libro a actualizar
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */ 
	public void tomarPrestadoLibro(String titulo, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("UPDATE LIBRO SET PRESTADO = 1 WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	/**
	 * Este metodo actualiza el estado del libro poniendolo a "no prestado" (prestado = 0)
	 * 
	 * @param titulo Titulo del libro a actualizar
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void devolverLibroPrestado(String titulo, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("UPDATE LIBRO SET PRESTADO = 0 WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	/**
	 * Este metodo busca un libro en la base de datos con el mismo titulo que el string pasado por parametro
	 * 
	 * @param titulo Titulo del libro por el que se desea filtrar
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el libro con el titulo igual que el primer parametro 
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public Libro buscarLibroTitulo(String titulo, String BD) throws SQLException {
		Libro l = null;
        Connection con = initBD(BD);
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libro WHERE Titulo = '" + titulo + "'");
     
        while(RS.next()) {
        	   l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7), RS.getString(8));
        }
        
        return l;
    }
	
	/**
	 * Este metodo busca libros en la base de datos con el mismo autor que el string pasado por parametro
	 * 
	 * @param Autor Autor del libro por el que se desea filtrar
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve los libros en formato de arrayList con el autor igual que el primer parametro
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<Libro> buscarLibroAutor(String Autor, String BD) throws SQLException {
        ArrayList<Libro> a = new ArrayList<Libro>();
		
		Connection con = initBD(BD);
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libro WHERE Autor = '" + Autor + "'");
        while(RS.next()) {
        	Libro l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7), RS.getString(8));
            a.add(l);
        }
        return a;
    }
	
	/**
	 * Este metodo busca un libro en la base de datos con el mismo ISBN que el int pasado por parametro
	 * 
	 * @param i ISBN del libro por el que se desea filtrar
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el libro con el ISBN igual que el primer parametro
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public Libro buscarLibroISBN(int i, String BD) throws SQLException {
		Libro l = null;
        Connection con = initBD(BD);
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libro WHERE ISBN = '" + i + "'");
        while (RS.next()) {
           	l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7), RS.getString(8));			
		}

        return l;
    }
	
	/**
	 * Este metodo recopila la contraseña del bibliotecario deseado
	 * 
	 * @param IDbibliotecario ID del bibliotecario del que se desea la contrasenya
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la cotrasenya del bibliotecario con el ID igual que el primer parametro
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public String comprobarContrasenyaBibliotecario(String IDbibliotecario, String BD) throws SQLException {
		String contrasenya = "";
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT CONTRASENYA FROM bibliotecario where ID = '" + IDbibliotecario +"'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			contrasenya = RS.getString("Contrasenya");
		}
		return contrasenya;
	}
	
	/**
	 * Este metodo recopila la ubicacion del libro deseado
	 * 
	 * @param Titulo Titulo del libro del que se desea la ubicacion
	 * @param BD Nombre de la bd a utilizar
	 * @return Devuelve la ubicacion del libro con el titulo igual que el primer parametro en formato string
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public String buscarUbicacionLibro(String Titulo, String BD) throws SQLException {
		String ubicacion = "";
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT Ubicacion FROM libro_ubicacion WHERE Libro = '" + Titulo + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			ubicacion = RS.getString("Ubicacion");
		}
		
        return ubicacion;
    }
	
	/**
	 * Este metodo recopila el anyo de nacimiento del autor deseado
	 * 
	 * @param Autor Nombre del autor del que se desea el anyo de nacimiento
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el anyo de nacimiento del autor con el nombre igual al primer parametro en formato int
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public int anyoNacAutor(String Autor, String BD) throws SQLException {
		int anyo = 0;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT AnyoNacimiento FROM autor WHERE Nombre = '" + Autor + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			anyo = RS.getInt("AnyoNacimiento");
		}
        return anyo;
    }
	
	/**
	 * Este metodo recopila el lugar de nacimiento del autor deseado
	 * 
	 * @param Autor Nombre del autor del que se desea el lugar de nacimiento
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el lugar de nacimiento del autor con el nombre igual que el primer parametro en formato string
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public String LugarNacAutor(String Autor, String BD) throws SQLException {
		String Lugar = "";
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT LugarNacimiento FROM autor WHERE Nombre = '" + Autor + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			Lugar = RS.getString("LugarNacimiento");
		}
        return Lugar;
    }
	
	/**
	 * Este metodo recopila en numero de libros publicados del autor deseado
	 * 
	 * @param Autor Nombre del autor del que se desea la cantidad de libros publicados
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la cantidad de libros publicados por el autor con el nombre igual que el primer parametro en formato int
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public int numLibrosPublicados(String Autor, String BD) throws SQLException {
		int numLibrosPublicados = 0;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT NumLibrosPublicados FROM autor WHERE Nombre = '" + Autor + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			numLibrosPublicados = RS.getInt("NumLibrosPublicados");
		}
        return numLibrosPublicados;
    }
	
	/**
	 * Este metodo elimina un usuario de la base de datos
	 * 
	 * @param Usuario Nickname del usuario a eliminar
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void eliminarUsuario(String Usuario, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("DELETE FROM usuario WHERE Usuario = '" + Usuario + "'");
		int updatep = update.executeUpdate();

    }

	/**
	 * Este metodo elimina un libro de la base de datos
	 * 
	 * @param Libro Titulo del libro a eliminar
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void eliminarLibro(String Libro, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("DELETE FROM libro WHERE Titulo = '" + Libro + "'");
		int updatep = update.executeUpdate();
    }
	
	
	/**
	 * Este método consulta los ISBN de los libros de los que se tienen opiniones guardadas.
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve arrayList con los ISBN en formato Integer
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<Integer> getOpISBN(String BD) throws SQLException{
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ArrayList<Integer> ISBN = new ArrayList<Integer>();
		
		String query = "SELECT ISBN from opinion";
		ResultSet RS = stmt.executeQuery(query);
		while(RS.next()) {
			ISBN.add((Integer) RS.getInt(1));
		}
		
		return ISBN;
	}
	
	
	/**
	 * Este metodo inserta las opiniones en la base de datos para un libro del que no se tiene registro de opiniones
	 * 
	 * @param l Libro del que se desea insertar la opinion
	 * @param usuarios ArrayList de usuarios que han opinado sobre el libro
	 * @param opiniones ArrayList de opiniones que se han realizado sobre el libro
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void insertarOpiniones(Libro l, ArrayList<String> usuarios, ArrayList<String> opiniones, String BD) throws SQLException {
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String users = "";
		String opinions = "";
		for(String s : usuarios) {
			users = users + (s+"/");
		}
		for(String s : opiniones) {
			opinions = opinions  + (s+"/");
		}
		
		String query = "INSERT INTO opinion VALUES ('" + l.getISBN() + "','" + users + "','" + opinions + "')";
		stmt.execute(query);
	}
	
	
	/**
	 * Este metodo inserta las opiniones en la base de datos para un libro con registro anterior de opiniones
	 * 
	 * @param l Libro del que se desea insertar la opinion
	 * @param usuarios ArrayList de usuarios que han opinado sobre el libro
	 * @param opiniones ArrayList de opiniones que se han realizado sobre el libro
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void modificarOpiniones(Libro l, ArrayList<String> usuarios, ArrayList<String> opiniones, String BD) throws SQLException {
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String users = "";
		String opinions = "";
		for(String s : usuarios) {
			users = users + (s+"/");
		}
		for(String s : opiniones) {
			opinions = opinions  + (s+"/");
		}
		
		String query = "UPDATE opinion SET Usuarios = '" + users + "', Opiniones = '" + opinions + "' WHERE ISBN = '" + l.getISBN() + "'";
		stmt.execute(query);
	}
	
	/**
	 * Este metodo consigue la lista de usuarios que han opinado sobre un libro en concreto
	 * 
	 * @param l Libro del que se desea obtener las opiniones
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve un arrayList de Strings con los nombres de los usuarios que han opinado sobre el libro 
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<String> getOpUsuarios(Libro l, String BD) throws SQLException {
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String[] users = {};
		ArrayList<String> usuarios = new ArrayList<String>();
		
		String query = "SELECT Usuarios FROM opinion WHERE ISBN= '" + l.getISBN() + "'";
		ResultSet RS = stmt.executeQuery(query);
		while(RS.next()) {
			users = RS.getString("Usuarios").split("/");
		}
		
		for(String s : users) {
			usuarios.add(s);
		}
		
		return usuarios;
	}
	
	/**
	 * Este metodo consigue la lista de opiniones sobre un libro en concreto
	 * 
	 * @param l Libro del que se desea obtener las opiniones
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve un arrayList de Strings con los nombres de los usuarios que han opinado sobre el libro
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<String> getOpOpiniones(Libro l, String BD) throws SQLException {
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String[] opinions = {};
		ArrayList<String> opiniones = new ArrayList<String>();
		
		String query = "SELECT Opiniones FROM opinion WHERE ISBN= '" + l.getISBN() + "'";
		ResultSet RS = stmt.executeQuery(query);
		while(RS.next()) {
			opinions = RS.getString("Opiniones").split("/");
		}
		
		for(String s : opinions) {
			opiniones.add(s);
		}
		
		return opiniones;
	}
	
	/**
	 * Este metodo modifica la cantidad de likes de un libro
	 * 
	 * @param titulo Titulo del libro del que se desea modificar la cantidad de likes
	 * @param likes Numero de likes actualizado
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void darLike(String titulo,int likes, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("UPDATE LIKES_DISLIKES SET LIKES = " + likes + " WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	/**
	 * Este metodo modifica la cantidad de dislikes de un libro
	 * 
	 * @param titulo Titulo del libro del que se desea modificar la cantidad de dislikes
	 * @param dislikes Numero de dislikes actualizado
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void darDislike(String titulo, int dislikes, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("UPDATE LIKES_DISLIKES SET DISLIKES = " + dislikes + " WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	/**
	 * Este metodo obtiene la cantidad de likes de un libro
	 * 
	 * @param titulo Titulo del libro del que se desea obtener la cantidad de likes
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el numero de likes del libro con el titulo igual al primer parametro
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public int getLikes(String titulo, String BD) throws SQLException {
		int likes = 0;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT LIKES FROM LIKES_DISLIKES WHERE TITULO = '" + titulo + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			likes = RS.getInt("Likes");
		}
        return likes;
    }
	
	/**
	 * Este metodo obtiene la cantidad de dislikes de un libro
	 * 
	 * @param titulo Titulo del libro del que se desea obtener la cantidad de dislikes
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el numero de dislikes del libro con el titulo igual al primer parametro
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public int getDislikes(String titulo, String BD) throws SQLException {
		int dislikes = 0;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT DISLIKES FROM LIKES_DISLIKES WHERE TITULO = '" + titulo + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			dislikes = RS.getInt("Dislikes");
		}
        return dislikes;
        
    }
	
	/**
	 * Este metodo recopila los primeros 10 libros con mejores notas
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve los titulos del top 10 de libros con mayor cantidad de likes en formato de arrayList
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<String> getTop10(String BD) throws SQLException {
		ArrayList<String> array = new ArrayList<String>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT Titulo FROM likes_dislikes ORDER BY likes DESC LIMIT 10");
		while(RS.next()) {
			array.add(RS.getString("Titulo"));
		}
		return array;
	}
	
	/**
	 * Este metodo recopila la lista de likes de todos los libros
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la lista de likes de todos los libros en formato arrayList de Integers
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<Integer> getListaLikes(String BD) throws SQLException {
		ArrayList<Integer> array = new ArrayList<>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT Likes FROM likes_dislikes");
		while(RS.next()) {
			array.add(RS.getInt("Likes"));
		}
		return array;
	}
	
	/**
	 * Este metodo recopila la lista de dislikes de todos los libros
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la lista de dislikes de todos los libros en formato arrayList de Integers
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<Integer> getListaDislikes(String BD) throws SQLException {
		ArrayList<Integer> array = new ArrayList<>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT Dislikes FROM likes_dislikes");
		while(RS.next()) {
			array.add(RS.getInt("Dislikes"));
		}
		return array;
	}
	
	/**
	 * Este metodo recopila la lista de todos los usuarios guardados en la base de datos
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la lista de todos los usuarios en formato de arrayList de Usuarios
	 * @throws SQLException Si hay algun problema de acceso a la base de datos 
	 */
	public ArrayList<Usuario> getListaUsuarios(String BD) throws SQLException {
		ArrayList<Usuario> array = new ArrayList<>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		Usuario u = null;
		String query = "SELECT * FROM Usuario";
		ResultSet RS = stmt.executeQuery(query);
		while(RS.next()){
			u = new Usuario(RS.getString(1), RS.getString(2), RS.getString(3), RS.getInt(4), RS.getString(5));
			array.add(u);
		}
		
		return array;
	}
	
	/**
	 * Este metodo recopila la lista de IDs de todos los administradores guardados en la base de datos
	 * 
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve la lista de todos los administradores en formato arrayList de String
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public ArrayList<String> getListaAdministradores(String BD) throws SQLException {
		ArrayList<String> array = new ArrayList<>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT * FROM bibliotecario";
		ResultSet RS = stmt.executeQuery(query);
		while(RS.next()){
			array.add(RS.getString("ID"));
		}
		return array;
	}	
	
	/**
	 * Este metodo inserta en la base de datos el like o dislike de un usuario para un libro concreto
	 * 
	 * @param Libro Titulo del libro en el que se desea modificar los likes/dislikes
	 * @param usuario Nickname del usuario que ejecuta la accion de dar like/dar dislike
	 * @param likeDislike Like o dislike (like = 0, dislike = 1)
	 * @param BD Nombre de la base de datos a utilizar
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public void insertarLikeDislikeUsuarioLibro(String Libro, String usuario, int likeDislike, String BD) throws SQLException { //Like = 0 Dislike = 1
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "INSERT INTO USUARIO_LIKE_DISLIKE_LIBRO VALUES('" + Libro + "', '" + usuario + "', '"+ likeDislike +  "')";
		stmt.execute(query);
	}
	
	/**
	 * Este metodo recopila el valor de likes/dislikes de un libro en concreto y de un usuario en concreto 
	 * 
	 * @param Libro Titulo del libro del que se desea recopilar el valor
	 * @param usuario Nickname del usuario por el que se desea filtrar el valor
	 * @param BD Nombre de la base de datos a utilizar
	 * @return Devuelve el valor del like/dislike del usuario seleccionado en el libro seleccionado (like = 1, dislike = 2, por defecto = 0)
	 * @throws SQLException Si hay algun problema de acceso a la base de datos
	 */
	public int devolverLikeDislikeUsuarioLibro(String Libro, String usuario, String BD) throws SQLException { //Like = 1 Dislike = 2
		int likeDislike = 0;
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		String query = "SELECT LIKE_DISLIKE FROM USUARIO_LIKE_DISLIKE_LIBRO WHERE TITULO = '" + Libro + "'" + "AND USUARIO = '" + usuario + "'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			likeDislike = RS.getInt("Like_Dislike");
		}
        return likeDislike;
		
	}
	
	public static void main(String[] args) throws SQLException {
		DB db = new DB();
	}

}
