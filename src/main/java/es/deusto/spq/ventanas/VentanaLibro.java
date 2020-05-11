package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;
import es.deusto.spq.utils.JLabelGraficoAjustado;

public class VentanaLibro extends JFrame{

	private final JPanel contentPane;
	private Usuario usuario;
	static VentanaLibro frame;
	String titulolibro;
	private JLabelGraficoAjustado dislike;
	private JLabelGraficoAjustado like;
	
	public VentanaLibro(Libro libro, Usuario u) {
		usuario = u;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logoS.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		final JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(1040, 20, 140, 30);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnAtras.setFocusPainted(false);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(btnAtras);
		btnAtras.setFocusable(false);
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal v1 = new VentanaPrincipal(u);
				v1.setVisible(true);
				dispose();
			}
		});

		final JPanel atrasPanel = new JPanel();
		atrasPanel.setBounds(1050, 18, 26, 30);
		atrasPanel.setOpaque(false);
		atrasPanel.setBorder(null);
		atrasPanel.setLayout(null);
		final JLabel atrasIMG = new JLabel();
		atrasPanel.add(atrasIMG);
		navBarPanel.add(atrasPanel);
		
		JLabel lblBiblioteca = new JLabel("Biblioteca Online");
		lblBiblioteca.setBounds(80, 20, 205, 29);
		lblBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 24));
		navBarPanel.add(lblBiblioteca);
		
		JLabelGraficoAjustado icono = new JLabelGraficoAjustado("src/main/resources/logoS.png", 60, 50);
		icono.setBounds(10, 13, 60, 50);
		navBarPanel.add(icono);

		final JPanel bookPanel = new JPanel();
		bookPanel.setLayout(null);
		bookPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		bookPanel.setBounds(197, 62, 800, 711);
		bookPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(bookPanel);
		

		//Cabecera
		final JLabel cabecera = new JLabel("Información sobre el libro:");
		cabecera.setBounds(262, 11, 270, 50);
		Font fuente2 = new Font("Book Antiqua", 3, 20);
		cabecera.setFont(new Font("Tahoma", Font.BOLD, 20));
		cabecera.setForeground(Color.BLACK);
		bookPanel.add(cabecera);
		
		// Título
		final JLabel label1 = new JLabel("Título: ");
		label1.setBounds(20, 110, 150, 50);
		label1.setFont(fuente2);
		label1.setForeground(Color.WHITE);
		bookPanel.add(label1);
		
		// ResultadoTítulo
		titulolibro = libro.getTitulo();
		final JLabel label11 = new JLabel(titulolibro);
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
				final String AutorLibro = libro.getAutor();
				final JLabel label22 = new JLabel(AutorLibro);
				label22.setBounds(90, 175, 400, 50);
				label22.setFont(fuente2);
				label22.setForeground(Color.WHITE);
				bookPanel.add(label22);
				//Botón InformaciónAutor
				final JButton botonAutor = new JButton("Más información");
				botonAutor.setBounds(325, 175, 200, 50);
				botonAutor.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
				botonAutor.setForeground(Color.BLACK);
				botonAutor.setContentAreaFilled(false);
				botonAutor.setBorder(new LineBorder(new Color (0,0,0),3));
				botonAutor.setFocusable(false);
				bookPanel.add(botonAutor);
				
				botonAutor.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
						System.out.println(AutorLibro);
						VentanaAutor v12 = new VentanaAutor(AutorLibro, libro, u);
						v12.setVisible(true);
						dispose();	
					 }catch (Exception e2) {
						 JOptionPane.showMessageDialog(frame, "Autor no encontrado");
					 }
						
					}});

				
		//Género
		final JLabel labelGenero = new JLabel("Género: ");
		labelGenero.setBounds(20, 240, 230, 50);
		labelGenero.setFont(fuente2);
		labelGenero.setForeground(Color.WHITE);
		bookPanel.add(labelGenero);
		
		//ResultadoGenero
		String genero = libro.getGenero();
		final JLabel labelGeneroRes = new JLabel(genero);
		labelGeneroRes.setBounds(110, 240, 230, 50);
		labelGeneroRes.setFont(fuente2);
		labelGeneroRes.setForeground(Color.WHITE);
		bookPanel.add(labelGeneroRes);
				
		// Número de páginas
		final JLabel label3 = new JLabel("Nº de Páginas: ");
		label3.setBounds(20, 305, 150, 50);
		label3.setFont(fuente2);
		label3.setForeground(Color.WHITE);
		bookPanel.add(label3);
		
		// ResultadoNºPáginas
		String numeroPaginas = Integer.toString(libro.getNumPags());
		final JLabel label33 = new JLabel(numeroPaginas);
		label33.setBounds(170, 305, 400, 50);
		label33.setFont(fuente2);
		label33.setForeground(Color.WHITE);
		bookPanel.add(label33);

		// ISBN
		final JLabel label4 = new JLabel("ISBN: ");
		label4.setBounds(20, 370, 150, 50);
		label4.setFont(fuente2);
		label4.setForeground(Color.WHITE);
		bookPanel.add(label4);
		
		// ResultadoISBN
		String numeroISBN = Integer.toString(libro.getISBN());
		final JLabel label44 = new JLabel(numeroISBN);
		label44.setBounds(95, 370, 400, 50);
		label44.setFont(fuente2);
		label44.setForeground(Color.WHITE);
		bookPanel.add(label44);

		// Sinopsis
		final JLabel label5 = new JLabel("Sinopsis: ");
		label5.setBounds(20, 435, 150, 50);
		label5.setFont(fuente2);
		label5.setForeground(Color.WHITE);
		bookPanel.add(label5);
		
		
		// ResultadoSinopsis
		String sinopsisLibro = libro.getSinopsis();
		final JLabel label55 = new JLabel(sinopsisLibro);
		label55.setBounds(150, 435, 400, 50);
		label55.setFont(fuente2);
		label55.setForeground(Color.WHITE);
		bookPanel.add(label55);
		
		
		// Botón Reservar
		final JButton botonR = new JButton("Reservar Libro");
		botonR.setBounds(60, 550, 200, 50);
		botonR.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botonR.setForeground(Color.BLACK);
		botonR.setContentAreaFilled(false);
		botonR.setBorder(new LineBorder(new Color (0,0,0),3));
		botonR.setFocusable(false);
		bookPanel.add(botonR);
		
		DB db = new DB();
		
		botonR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (db.comprobarLibroPrestado(titulolibro, "gestion_biblioteca_db") == 0) {
						db.tomarPrestadoLibro(titulolibro, "gestion_biblioteca_db");
						JOptionPane.showMessageDialog(null, "Libro Reservado");
					}
					else {
						JOptionPane.showMessageDialog(null, "El libro no esta disponible para ser prestado.");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 

			}
		});
		
		JLabelGraficoAjustado fotoAutor = new JLabelGraficoAjustado("src/main/resources/libro.jpg", 170, 175);
		fotoAutor.setLocation(600, 50);
		bookPanel.add(fotoAutor);
		
		like = new JLabelGraficoAjustado("src/main/resources/like.jpg", 65, 65);
		like.setLocation(550, 538);
		like.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dislike.setVisible(false);
				try {
					int likes = db.getLikes(titulolibro, "gestion_biblioteca_db");
					likes = likes + 1;
					db.darLike(titulolibro, likes, "gestion_biblioteca_db");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		bookPanel.add(like);

		dislike = new JLabelGraficoAjustado("src/main/resources/dislike.jpg", 65, 65);
		dislike.setLocation(650, 538);
		dislike.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				like.setVisible(false);
				try {
					int dislikes = db.getDislikes(titulolibro, "gestion_biblioteca_db");
					dislikes = dislikes + 1;
					db.darDislike(titulolibro, dislikes, "gestion_biblioteca_db");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		bookPanel.add(dislike);
		
		JButton btnOpinion = new JButton("Ver Opiniones");
		btnOpinion.setForeground(Color.BLACK);
		btnOpinion.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		btnOpinion.setFocusable(false);
		btnOpinion.setContentAreaFilled(false);
		btnOpinion.setBorder(new LineBorder(new Color (0,0,0),3));
		btnOpinion.setBounds(298, 639, 200, 50);
		bookPanel.add(btnOpinion);
		
		btnOpinion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaOpiniones v2 = new VentanaOpiniones(libro, usuario);
				v2.setVisible(true);
			}
		});

	}
	
	public static void main (String [ ] args) {
		Usuario u = new Usuario("u", "s", "f", 323, "13123");
		Libro l = new Libro("", "", 3, 3, "", 0, "", "");
		VentanaLibro v = new VentanaLibro(l, u);
		v.setVisible(true);
	}
}