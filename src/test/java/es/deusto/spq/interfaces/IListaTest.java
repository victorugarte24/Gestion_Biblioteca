package es.deusto.spq.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import es.deusto.spq.clases.Libro;
import es.deusto.spq.db.DB;


class IListaTest {
	
	private ILista interfaz;
	private DB database = new DB();
	private ArrayList<Libro> array = new ArrayList<Libro>();
	private JList lista = new JList<String>();
	
	@Before
	public void setUp() {
		 try {
			array = database.getLibros("gestion_biblioteca_db");
			System.out.println("BD cargada");
		 } catch (SQLException e) {
			System.out.println("BD no cargada");
		}
	}
	
	@Test
	public void actualizarLista() {
		ILista.cargarLista(lista, array);
		
		assertEquals(array.size(), lista.getModel().getSize());
		
	}
}
