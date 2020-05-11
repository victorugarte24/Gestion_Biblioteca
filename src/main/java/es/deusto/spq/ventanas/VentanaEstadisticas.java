package es.deusto.spq.ventanas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import es.deusto.spq.clases.Libro;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class VentanaEstadisticas extends JFrame{
	
	int seleccion;
	
	public VentanaEstadisticas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logoS.png"));
		setSize(650,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estadísticas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(236, 43, 149, 29);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libros", "Likes", "Dislikes", "Usuarios", "Administradores", "Opiniones"}));
		comboBox.setBounds(485, 100, 120, 25);
		comboBox.setFocusable(false);
		comboBox.addActionListener(new 	ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccion = comboBox.getSelectedIndex();
				
				switch (seleccion) {
				  case 0:
					  
				    break;
				  case 1:
				    
				    break;
				  case 2:
				    
				    break;
				  case 3:
				    
				    break;
				  case 4:
				   
				    break;
				  case 5:
				    
				    break;
				  case 6:
				    
				    break;
				}
			}
		});
		getContentPane().add(comboBox);
		
		JList list = new JList();
		DefaultListModel modelo = new DefaultListModel<String>();	
		list.setModel(modelo);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(20, 140, 600, 300);
		getContentPane().add(scrollPane);


	}
	public static void main (String [ ] args) {
		VentanaEstadisticas v = new VentanaEstadisticas();
		v.setVisible(true);
	}
}
