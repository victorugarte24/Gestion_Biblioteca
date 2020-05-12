package es.deusto.spq.ventanas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class VentanaEstadisticas extends JFrame{
	
	int seleccion;
	DB db = new DB();
	ArrayList<String> arrayLibros = new ArrayList<>();
	ArrayList<Integer> arrayLikes = new ArrayList<>();
	ArrayList<Integer> arrayDislikes = new ArrayList<>();
	ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
	ArrayList<String> arrayAdministradores = new ArrayList<>();
	JList list = new JList();
	DefaultListModel modelo = new DefaultListModel<String>();
	
	public VentanaEstadisticas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
		setSize(650,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estadísticas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(236, 43, 149, 29);
		getContentPane().add(lblNewLabel);
	
		list.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(20, 140, 600, 300);
		getContentPane().add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libros", "Likes", "Dislikes", "Usuarios", "Administradores"}));
		comboBox.setBounds(485, 100, 120, 25);
		comboBox.setFocusable(false);
		comboBox.addActionListener(new 	ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccion = comboBox.getSelectedIndex();
				
				switch (seleccion) {
				  case 0:
					  modelo.removeAllElements();
					  cargarLibros();
				    break;
				  case 1:
					  modelo.removeAllElements();
					  cargarLikes();
				    break;
				  case 2:
					  modelo.removeAllElements();
					  cargarDislikes();
				    break;
				  case 3:
					  modelo.removeAllElements();
					  cargarUsuarios();
				    break;
				  case 4:
					  modelo.removeAllElements();
					  cargarAdministradores();
				    break;
				}
			}
		});
		getContentPane().add(comboBox);
		
		try {
			arrayLibros = db.getTituloLibros("gestion_biblioteca_db");
			arrayLikes = db.getListaLikes("gestion_biblioteca_db");
			arrayDislikes = db.getListaDislikes("gestion_biblioteca_db");
			arrayUsuarios = db.getListaUsuarios("gestion_biblioteca_db");
			arrayAdministradores = db.getListaAdministradores("gestion_biblioteca_db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cargarLibros();
	}
	
	public void cargarLibros() {	
		int c = 0;
		for(int i = 0; i < arrayLibros.size(); i++) {
			c = i + 1;
			modelo.addElement(" " + c + ". " + arrayLibros.get(i));
		}
	}
	
	public void cargarLikes() {
		int c = 0;
		for(int i = 0; i < arrayLibros.size(); i++) {
			c = i + 1;
			modelo.addElement(" " + c + ". " + arrayLibros.get(i) + " -- Likes: " + Integer.toString(arrayLikes.get(i)));
		}
	}
	
	public void cargarDislikes() {
		int c = 0;		
		for(int i = 0; i < arrayLibros.size(); i++) {
			c = i + 1;
			modelo.addElement(" " + c + ". " + arrayLibros.get(i) + " -- Dislikes: " + Integer.toString(arrayDislikes.get(i)));
		}
	}
	
	public void cargarUsuarios() {
		int c = 0;		
		for(int i = 0; i < arrayUsuarios.size(); i++) {
			c = i + 1;
			modelo.addElement(" " + c + ". " + arrayUsuarios.get(i).toString());
		}
	}
	
	public void cargarAdministradores() {
		int c = 0;		
		for(int i = 0; i < arrayAdministradores.size(); i++) {
			c = i + 1;
			modelo.addElement(" " + c + ". " + arrayAdministradores.get(i));
		}
	}
	
	public static void main (String [ ] args) {
		VentanaEstadisticas v = new VentanaEstadisticas();
		v.setVisible(true);
	}
}
