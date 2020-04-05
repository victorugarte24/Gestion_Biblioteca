package es.deusto.spq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;

public class DB {

	public static Connection initBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_biblioteca_db?userTimezone=true&serverTimezone=UTC", "root", "admin");
			return con;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertarUsuario(Usuario u) throws SQLException {
		Connection con = initBD();
		Statement stmt = con.createStatement();
		String usuario = u.getUsuario();
		int dni = u.getDNI();
		String nombre = u.getNombre();
		String apellido = u.getApellido();
		String contrasenya = u.getContrasenya();
		String query = "INSERT INTO USUARIOS  VALUES('" + usuario + "', "+ dni + ", '"+ nombre + "', '"+  apellido + "', '"+ contrasenya + "')";
		stmt.execute(query);
	}

	public boolean comprobarUsuario(String usuario) throws SQLException {
		boolean respuesta = false;
		Connection con = initBD();
		Statement stmt = con.createStatement();
		String query = "SELECT COUNT(*) AS total FROM usuarios where usuario = '" + usuario +"'";
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

	public String comprobarContrasenya(String Usuario) throws SQLException {
		String contrasenya = "";
		Connection con = initBD();
		Statement stmt = con.createStatement();
		String query = "SELECT CONTRASENYA FROM usuarios where usuario = '" + Usuario +"'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			contrasenya = RS.getString("Contrasenya");
		}
		return contrasenya;
	}

	public ArrayList<Libro> getLibros() throws SQLException {
		ArrayList<Libro> array = new ArrayList<Libro>();
		Connection con = initBD();
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT * FROM libros");
		while(RS.next()) {
			Libro l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6));
			array.add(l);
		}
		return array;
	}

	public void AnyadirLibro(Libro l) throws SQLException {
		String titulo = l.getTitulo();
		String autor = l.getAutor();
		int numPags = l.getNumPags();
		int ISBN = l.getISBN();
		String sinopsis = l.getSinopsis();
		int prestado = l.getPrestado();

		Connection con = initBD();
		Statement stmt = con.createStatement();
		String query = "INSERT INTO libros VALUES ('" + titulo +"','" + autor + "'," + numPags + "," + ISBN + ",'" + sinopsis + "'," + prestado + ")";
		stmt.execute(query);
	}
	
	public int comprobarLibroPrestado(String titulo) throws SQLException {
		int prestado = 0;
		Connection con = initBD();
		Statement stmt = con.createStatement();
		String query = "SELECT PRESTADO FROM LIBROS WHERE TITULO = '" + titulo +"'";
		ResultSet RS = stmt.executeQuery(query);
		while (RS.next()) {
			prestado = RS.getInt("Prestado");
		}
		return prestado;
	}
	
	public void tomarPrestadoLibro(String titulo) throws SQLException {
		Connection con = initBD();
		PreparedStatement update = con.prepareStatement("UPDATE LIBROS SET PRESTADO = 1 WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	public void devolverLibroPrestado(String titulo) throws SQLException {
		Connection con = initBD();
		PreparedStatement update = con.prepareStatement("UPDATE LIBROS SET PRESTADO = 0 WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	public Libro buscarLibro(String s) throws SQLException {
        Connection con = initBD();
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libros WHERE Titulo = '" + s + "'");
        Libro l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(0));
        return l;
    }

	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		Usuario u = new Usuario("Mikel", "Lopez", "dhsd", 3213213, "1234");
		Libro l = new Libro("La", "Victor", 3, 4444, "", 0);
		db.tomarPrestadoLibro("Cronicas de la Torre");
	}

}
