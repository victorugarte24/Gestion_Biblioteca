package es.deusto.spq;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;



import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private boolean escrito1;
	private boolean escrito2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setSize(1200, 800);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
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
		logobtn.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/es/deusto/spq/resources/logoS.png")));
		navBarPanel.add(logobtn);		
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setForeground(Color.LIGHT_GRAY);
		loginbtn.setFont(new Font("Rockwell", Font.BOLD, 14));
		loginbtn.setFocusPainted(false);
		loginbtn.setBounds(1040, 20, 140, 30);
		loginbtn.setOpaque(false);
		loginbtn.setContentAreaFilled(false);
		loginbtn.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(loginbtn);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setBounds(1050, 18, 26, 28);
		loginPanel.setBorder(null);
		JLabel loginIMG = new JLabel();
		loginIMG.setBounds(1050, 20, 24, 26);
		loginIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/user.png")));
		loginPanel.add(loginIMG);
		navBarPanel.add(loginPanel);
		
		textField = new JTextField();
		textField.setBounds(347, 20, 500, 30);
		navBarPanel.add(textField);
		textField.setColumns(10);
		
		JButton searchbtn = new JButton();
		searchbtn.setOpaque(false);
		searchbtn.setContentAreaFilled(false);
		searchbtn.setBounds(855, 20, 30, 30);
		searchbtn.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		searchbtn.setBorder(null);
		searchbtn.setFocusable(true);
		/*
		JLabel searchIMG = new JLabel();
		searchIMG.setBounds(0, 0, 30, 30);
		searchIMG.setFocusable(false);
		searchIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		searchbtn.add(searchIMG);*/
		navBarPanel.add(searchbtn);
		
		JScrollPane bookPanel = new JScrollPane();
		bookPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		bookPanel.setBounds(197, 62, 800, 711);
		bookPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(bookPanel);
		bookPanel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(780, 0, 17, 709);
		bookPanel.add(scrollBar);
		
		// Buscar por título
		final JLabel label1 = new JLabel("Buscar por título:");
		label1.setBounds(20, 10, 150, 50);
		Font fuente2 = new Font("Book Antiqua", 3, 15);
		label1.setFont(fuente2);
		label1.setForeground(Color.WHITE);
		bookPanel.add(label1);
		final JTextField texto1 = new JTextField("Ej: Don Quijote");
		texto1.setBounds(100, 50, 150, 30);
		escrito1 = false;
		texto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito1 == false) {
					texto1.setText("");
					escrito1 = true;
				}
			}
		});		

		bookPanel.add(texto1);

		final JButton boton1 = new JButton("Buscar");
		boton1.setOpaque(false);
		boton1.setContentAreaFilled(false);
		boton1.setBounds(250, 50, 50, 30);
		boton1.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		boton1.setBorder(null);
		boton1.setFocusable(true);
		bookPanel.add(boton1);

		// Detalles por libro
		final JLabel label2 = new JLabel("Obtener detalles del libro:");
		label2.setBounds(20, 10, 190, 190);
		Font fuente1 = new Font("Book Antiqua", 3, 15);
		label2.setFont(fuente1);
		label2.setForeground(Color.WHITE);
		bookPanel.add(label2);
		final JTextField texto2 = new JTextField("Ej: Don Quijote");
		texto2.setBounds(100, 125, 150, 30);
		escrito2 = false;
		texto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito2 == false) {
					texto2.setText("");
					escrito2 = true;
				}
			}
		});		
		
		bookPanel.add(texto2);

		final JButton boton2 = new JButton("Obtener");
		boton2.setOpaque(false);
		boton2.setContentAreaFilled(false);
		boton2.setBounds(250, 50, 50, 180);
		boton2.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		boton2.setBorder(null);
		boton2.setFocusable(true);
		boton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				VentanaLibro v = new VentanaLibro();
							v.setSize(1200, 800);
							v.setVisible(true);
							v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							v.setTitle("Libro");
							dispose();
			}
		}
		);
		bookPanel.add(boton2);


	}
}
