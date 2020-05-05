package es.deusto.spq.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import es.deusto.spq.clases.Libro;

public interface ILista {

	public static void cargarLista(JList bookPanel, ArrayList<Libro> a){
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for(Libro l : a) {
			modelo.addElement(l.getTitulo());
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
	
}
