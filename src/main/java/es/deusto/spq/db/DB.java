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

	public ArrayList<Libro> getLibros(String BD) throws SQLException {
		ArrayList<Libro> array = new ArrayList<Libro>();
		Connection con = initBD(BD);
		Statement stmt = con.createStatement();
		ResultSet RS = stmt.executeQuery("SELECT * FROM libro");
		while(RS.next()) {
			Libro l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7));
			array.add(l);
		}
		return array;
	}

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
	
	public void tomarPrestadoLibro(String titulo, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("UPDATE LIBRO SET PRESTADO = 1 WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	public void devolverLibroPrestado(String titulo, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("UPDATE LIBRO SET PRESTADO = 0 WHERE TITULO = '" + titulo +"'");
		int updatep = update.executeUpdate();
	}
	
	public Libro buscarLibroTitulo(String s, String BD) throws SQLException {
		Libro l = null;
        Connection con = initBD(BD);
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libro WHERE Titulo = '" + s + "'");
     
        while(RS.next()) {
        	   l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7));
        }
        
        return l;
    }
	
	public ArrayList<Libro> buscarLibroAutor(String Autor, String BD) throws SQLException {
        ArrayList<Libro> a = new ArrayList<Libro>();
		
		Connection con = initBD(BD);
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libro WHERE Autor = '" + Autor + "'");
        while(RS.next()) {
        	Libro l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7));
            a.add(l);
        }
        return a;
    }
	
	public Libro buscarLibroISBN(int i, String BD) throws SQLException {
		Libro l = null;
        Connection con = initBD(BD);
        Statement stmt = con.createStatement();
        ResultSet RS = stmt.executeQuery("SELECT * FROM libro WHERE ISBN = '" + i + "'");
        while (RS.next()) {
           	l = new Libro(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6), RS.getString(7));			
		}

        return l;
    }
	
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
	
	public void eliminarUsuario(String Usuario, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("DELETE FROM usuario WHERE Usuario = '" + Usuario + "'");
		int updatep = update.executeUpdate();

    }

	public void eliminarLibro(String Libro, String BD) throws SQLException {
		Connection con = initBD(BD);
		PreparedStatement update = con.prepareStatement("DELETE FROM libro WHERE Titulo = '" + Libro + "'");
		int updatep = update.executeUpdate();

		
    }
	
	
	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		System.out.println(db.anyoNacAutor("Vanesa Redondo", "gestion_biblioteca_db"));
	}

}
