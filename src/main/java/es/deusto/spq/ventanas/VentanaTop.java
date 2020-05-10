package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.db.DB;

public class VentanaTop extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList bookPanel = new JList();
			
	public VentanaTop(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logoS.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("TOP 10");
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(label);
		
		DB db = new DB();
		try {
			cargarLista(db.getTop10("gestion_biblioteca_db"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getContentPane().add(panel, BorderLayout.NORTH);
		getContentPane().add(bookPanel, BorderLayout.CENTER);

	}
	
	public void cargarLista(ArrayList<String> a) {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for(String l : a) {
			modelo.addElement(l);
		}		
		bookPanel.setModel(modelo);
		bookPanel.updateUI();
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)bookPanel.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER);  
		bookPanel.setFixedCellHeight(40);
		bookPanel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookPanel.setVisibleRowCount(5);
		bookPanel.setFont(new Font("Rockwell", Font.BOLD, 20));
		bookPanel.setForeground(new Color(0, 0, 0));
		bookPanel.setBackground(Color.LIGHT_GRAY);
	}

	public static void main(String[] args) {
		VentanaTop vt = new VentanaTop();
		vt.setVisible(true);

	}

}
