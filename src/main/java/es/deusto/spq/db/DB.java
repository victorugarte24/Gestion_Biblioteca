package es.deusto.spq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.deusto.spq.clases.Usuario;

public class DB {
	
	public void insertarUsuario(Usuario u) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_biblioteca_db?userTimezone=true&serverTimezone=UTC", "root", "admin");
			Statement stmt = con.createStatement();
			String usuario = u.getUsuario();
			int dni = u.getDNI();
			String nombre = u.getNombre();
			String apellido = u.getApellido();
			String contrasenya = u.getContrasenya();
			String query = "INSERT INTO USUARIOS  VALUES('" + usuario + "', "+ dni + ", '"+ nombre + "', '"+  apellido + "', '"+ contrasenya + "')";
			stmt.execute(query);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean comprobarUsuario(String usuario) throws SQLException {
		boolean respuesta = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_biblioteca_db?userTimezone=true&serverTimezone=UTC", "root", "admin");
			Statement stmt = con.createStatement();
			System.out.println("Conectado a la Base de datos");
			String query = "SELECT COUNT(*) AS total FROM usuarios where usuario = '" + usuario +"'";
			ResultSet RS = stmt.executeQuery(query);
			while (RS.next()) {
				if( RS.getInt("total") > 0 ) {
					respuesta = true;//El usuario existe
				} else {
					respuesta = false; //El usuario no existe
				}
			}
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public String comprobarContrasenya(String Usuario) throws SQLException {
		String contrasenya = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_biblioteca_db?userTimezone=true&serverTimezone=UTC", "root", "admin");
			Statement stmt = con.createStatement();
			String query = "SELECT CONTRASENYA FROM usuarios where usuario = '" + Usuario +"'";
			ResultSet RS = stmt.executeQuery(query);
			while (RS.next()) {
				contrasenya = RS.getString("Contrasenya");
			}
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contrasenya;
	}


	public static void main(String[] args) throws SQLException {
		DB db = new DB();
		Usuario u = new Usuario("Mikel", "Lopez", "blackwidow", 3213213, "1234");
		System.out.println(db.comprobarContrasenya("usuario1"));
	}

}
