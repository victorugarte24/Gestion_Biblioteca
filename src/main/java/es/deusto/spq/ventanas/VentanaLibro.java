package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.db.DB;

public class VentanaLibro extends JFrame{
	/**
	 *
	 */
	private final JPanel contentPane;
	
	static VentanaLibro frame;
	String Titulolibro;

	public VentanaLibro(Libro libro) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/es/deusto/spq/resources/logoS.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/es/deusto/spq/resources/logoS.png"));
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		contentPane.setBackground(new Color(127, 92, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		final JButton btnAtras = new JButton("Atras");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnAtras.setFocusPainted(false);
		btnAtras.setBounds(1040, 20, 140, 30);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(btnAtras);
		btnAtras.setFocusable(false);
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal p = new VentanaPrincipal();
				p.setVisible(true);
				dispose();
			}
		});

		final JPanel atrasPanel = new JPanel();
		atrasPanel.setOpaque(false);
		atrasPanel.setBounds(1050, 16, 26, 30);
		atrasPanel.setBorder(null);
		final JLabel atrasIMG = new JLabel();
		atrasIMG.setBounds(1050, 20, 24, 26);
		atrasIMG.setIcon(new ImageIcon(VentanaLibro.class.getResource("/es/deusto/spq/resources/flechaB.png")));
		atrasPanel.add(atrasIMG);
		navBarPanel.add(atrasPanel);

		final JScrollPane bookPanel = new JScrollPane();
		bookPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		bookPanel.setBounds(197, 62, 800, 711);
		bookPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(bookPanel);
		bookPanel.setLayout(null);

		//Cabecera
		final JLabel cabezera = new JLabel("Información sobre el libro");
		cabezera.setBounds(200, 10, 400, 50);
		Font fuente2 = new Font("Book Antiqua", 3, 20);
		cabezera.setFont(fuente2);
		cabezera.setForeground(Color.WHITE);
		bookPanel.add(cabezera);
		
		// Título
		final JLabel label1 = new JLabel("Título: ");
		label1.setBounds(20, 110, 150, 50);
		label1.setFont(fuente2);
		label1.setForeground(Color.WHITE);
		bookPanel.add(label1);
		
		// ResultadoTítulo
		Titulolibro = libro.getTitulo();
		final JLabel label11 = new JLabel(Titulolibro);
		label11.setBounds(95, 110, 400, 50);
		label11.setFont(fuente2);
		label11.setForeground(Color.WHITE);
		bookPanel.add(label11);

		// Autor
		final JLabel label2 = new JLabel("Autor: ");
		label2.setBounds(20, 175, 150, 50);
		label2.setFont(fuente2);
		label2.setForeground(Color.WHITE);
		bookPanel.add(label2);
		
		// ResultadoAutor
		String AutorLibro = libro.getAutor();
		final JLabel label22 = new JLabel(AutorLibro);
		label22.setBounds(95, 175, 400, 50);
		label22.setFont(fuente2);
		label22.setForeground(Color.WHITE);
		bookPanel.add(label22);

		// Número de páginas
		final JLabel label3 = new JLabel("Nº de Páginas: ");
		label3.setBounds(20, 240, 150, 50);
		label3.setFont(fuente2);
		label3.setForeground(Color.WHITE);
		bookPanel.add(label3);
		
		// ResultadoNºPáginas
		String numeroPaginas = Integer.toString(libro.getNumPags());
		final JLabel label33 = new JLabel(numeroPaginas);
		label33.setBounds(165, 240, 150, 50);
		label33.setFont(fuente2);
		label33.setForeground(Color.WHITE);
		bookPanel.add(label33);

		// ISBN
		
		final JLabel label4 = new JLabel("ISBN: ");
		label4.setBounds(20, 305, 150, 50);
		label4.setFont(fuente2);
		label4.setForeground(Color.WHITE);
		bookPanel.add(label4);
		
		// ResultadoISBN
		String numeroISBN = Integer.toString(libro.getISBN());
		final JLabel label44 = new JLabel(numeroISBN);
		label44.setBounds(95, 305, 400, 50);
		label44.setFont(fuente2);
		label44.setForeground(Color.WHITE);
		bookPanel.add(label44);

		// Sinopsis
		final JLabel label5 = new JLabel("Sinopsis: ");
		label5.setBounds(20, 370, 150, 50);
		label5.setFont(fuente2);
		label5.setForeground(Color.WHITE);
		bookPanel.add(label5);
		
		
		// ResultadoSinopsis
		String sinopsisLibro = libro.getSinopsis();
		final JLabel label55 = new JLabel(sinopsisLibro);
		label55.setBounds(95, 370, 400, 50);
		label55.setFont(fuente2);
		label55.setForeground(Color.WHITE);
		bookPanel.add(label55);
		
		
		// Botón Reservar
		final JButton botonR = new JButton("Reservar Libro");
		botonR.setBounds(20, 550, 200, 50);
		botonR.setFont(fuente2);
		botonR.setForeground(Color.BLUE);
		bookPanel.add(botonR);
		botonR.setFocusable(false);

		botonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB db = new DB();
				try {
					if (db.comprobarLibroPrestado(Titulolibro) == 0) {
						db.tomarPrestadoLibro(Titulolibro);
						JOptionPane.showMessageDialog(null, "Libro Reservado");
					}
					else {
						JOptionPane.showMessageDialog(null, "El libro esta en manos de otro usuario. No se puede tomar prestado.");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 

			}
		});

	}
}