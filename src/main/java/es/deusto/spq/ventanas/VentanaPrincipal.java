package es.deusto.spq.ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.db.DB;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtField;
	private JTextArea bookPanel;
	private ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
	private File bd;
	private static VentanaPrincipal frame;
	private DB database = new DB();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaPrincipal();
					frame.setSize(1200, 800);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VentanaPrincipal() {
		Libro l = new Libro("Romeo y Julieta","William Shakespeare",150,1999999,"aaa", 0);
		Libro l2 = new Libro("El senyor de los Anillos","J.R.R. Tolkien",300,2000000,"aab", 0);
		Libro l3 = new Libro("Cronicas de la Torre","Laura Gallego Garcia",200,2000001,"aac", 0);
		
		try {
			database.AnyadirLibro(l);
			database.AnyadirLibro(l2);
			database.AnyadirLibro(l3);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "No se ha podido añadir a la BD");
			e.printStackTrace();
		}
		
		try {
			arrayLibros = database.getLibros();
			
			JOptionPane.showMessageDialog(this, "Libros cargados");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Libros no cargados");
			e.printStackTrace();
		}
		
		init();
	}
	
	public void init() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 92, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		JButton logobtn = new JButton();
		logobtn.setBounds(40, 5, 50, 60);
		logobtn.setBorder(null);
		logobtn.setFocusPainted(false);
		logobtn.setFocusable(false);
		logobtn.setContentAreaFilled(false);		
		//logobtn.setIcon(new ImageIcon(getClass().getResource("resources/logoS.png")));
		navBarPanel.add(logobtn);		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInicio v = new VentanaInicio();
				v.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnSalir.setFocusPainted(false);
		btnSalir.setBounds(1040, 20, 140, 30);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(btnSalir);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setBounds(1050, 17, 26, 29);
		loginPanel.setBorder(null);
		JLabel loginIMG = new JLabel();
		loginIMG.setBounds(1050, 20, 24, 26);
		//loginIMG.setIcon(new ImageIcon(getClass().getResource("/resources/flechaB.png")));
		loginPanel.add(loginIMG);
		navBarPanel.add(loginPanel);
		
		txtField = new JTextField();
		txtField.setBounds(347, 20, 500, 30);
		navBarPanel.add(txtField);
		txtField.setColumns(10);
		
		JButton searchbtn = new JButton();
		searchbtn.setOpaque(false);
		searchbtn.setContentAreaFilled(false);
		searchbtn.setBounds(855, 20, 30, 30);
		//searchbtn.setIcon(new ImageIcon(getClass().getResource("/resources/lupaP.png")));
		searchbtn.setBorder(null);
		searchbtn.setFocusable(true);
		navBarPanel.add(searchbtn);
	
		bookPanel = new JTextArea(arrayLibros.size(),1);
		bookPanel.setFont(new Font("Rockwell", Font.BOLD, 20));
		bookPanel.setForeground(new Color(0, 0, 0));
		filtrarLibros();
		bookPanel.setEditable(false);
		bookPanel.setBackground(new Color(90, 64, 17));
		
		
		JScrollPane scroll = new JScrollPane(bookPanel);
		scroll.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scroll.setBounds(197, 62, 800, 715);
		contentPane.add(scroll);
			
	}
	
	public void filtrarLibros() {
		for(Libro l : arrayLibros) {
			bookPanel.append("\n   " + l.getTitulo() + "\n");
		}
	}
}


