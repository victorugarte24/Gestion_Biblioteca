package es.deusto.spq.ventanas;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import es.deusto.spq.clases.Libro;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtField;
	private JTextArea bookPanel;
	private ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
	private File bd;
	private static VentanaPrincipal frame;

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
		cargarlibros();
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
		logobtn.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/logoS.png")));
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
		loginIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/flechaB.png")));
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
		searchbtn.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
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
	
	
	public void cargarlibros() {
		bd = new File((getClass().getResource("/es/deusto/spq/BD.txt")).getPath());
		try {
			FileReader fr = new FileReader(bd);
			BufferedReader br = new BufferedReader(fr);
			String l;
			
			try {
				while( (l=br.readLine()) !=null) {
					String[] f = l.split(",");
					Libro b = new Libro(f[0],f[1], Integer.parseInt(f[2]), Integer.parseInt(f[3]), f[4]);
					System.out.println(b);
					arrayLibros.add(b);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Archivo no encontrado.");
		}
	}
	
	public void filtrarLibros() {
		for(Libro l : arrayLibros) {
			bookPanel.append("\n   " + l.getTitulo() + "\n");
		}
	}
}

