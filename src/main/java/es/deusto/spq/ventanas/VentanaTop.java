package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import es.deusto.spq.utils.JLabelGraficoAjustado;


/** Genera una ventana en la que se muestran los 10 libros con más likes.
 * @author Victor
 *
 */
public class VentanaTop extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JList bookPanel = new JList();
	String like1;
	String like2;
	String like3;
	String like4;
	String like5;
	String like6;
	String like7;
	String like8;
	String like9;
	String like10;
	DefaultListModel<String> modelo;
			
	public VentanaTop(){
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
		setSize(650,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 650, 47);
		JLabel label = new JLabel("TOP 10");
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(label);

		DB db = new DB();
		try {
			cargarLista(db.getTop10("gestion_biblioteca_db"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		bookPanel.setBounds(150, 47, 300, 425);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().add(bookPanel, BorderLayout.CENTER);
		
		try {
			like1 = Integer.toString(db.getLikes(modelo.get(0), "gestion_biblioteca_db"));
			like2 = Integer.toString(db.getLikes(modelo.get(1), "gestion_biblioteca_db"));
			like3 = Integer.toString(db.getLikes(modelo.get(2), "gestion_biblioteca_db"));
			like4 = Integer.toString(db.getLikes(modelo.get(3), "gestion_biblioteca_db"));
			like5 = Integer.toString(db.getLikes(modelo.get(4), "gestion_biblioteca_db"));
			like6 = Integer.toString(db.getLikes(modelo.get(5), "gestion_biblioteca_db"));
			like7 = Integer.toString(db.getLikes(modelo.get(6), "gestion_biblioteca_db"));
			like8 = Integer.toString(db.getLikes(modelo.get(7), "gestion_biblioteca_db"));
			like9 = Integer.toString(db.getLikes(modelo.get(8), "gestion_biblioteca_db"));
			like10 = Integer.toString(db.getLikes(modelo.get(9), "gestion_biblioteca_db"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("1.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 56, 45, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(26, 96, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 140, 45, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("4.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(26, 180, 45, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("5.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(26, 220, 45, 13);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("6.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(26, 260, 45, 13);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("7.");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(26, 300, 45, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("8.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(26, 340, 45, 13);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("9.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(26, 380, 45, 13);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("10.");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(26, 420, 45, 13);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Likes: " + like1);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(480, 62, 80, 13);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Likes: "+ like2);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(480, 96, 80, 13);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Likes: "+ like3);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(480, 140, 80, 13);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Likes: "+ like4);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(480, 180, 80, 13);
		getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Likes: "+ like5);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(480, 220, 80, 13);
		getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Likes: "+ like6);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_15.setBounds(480, 260, 80, 13);
		getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Likes: "+ like7);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(480, 300, 80, 13);
		getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Likes: "+ like8);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_17.setBounds(480, 340, 80, 13);
		getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Likes: "+ like9);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(480, 380, 80, 13);
		getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Likes: "+ like10);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_19.setBounds(480, 420, 80, 13);
		getContentPane().add(lblNewLabel_19);
	
	}
	
	/** Carga en el modelo la lista de libros que pertenencen al top 10 y que se visualizará en la ventana.
	 * @param a arraylist que posee los libros que pertenecen al top 10.
	 */
	public void cargarLista(ArrayList<String> a) {
		modelo = new DefaultListModel<String>();
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
	
	public static void main (String [ ] args) {
		VentanaTop v = new VentanaTop();
		v.setVisible(true);
	}
}
