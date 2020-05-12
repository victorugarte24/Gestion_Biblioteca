package es.deusto.spq.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;
import es.deusto.spq.utils.JLabelGraficoAjustado;

public class VentanaAutor extends JFrame{

	private final JPanel contentPane;
	private Usuario usuario;
	static VentanaLibro frame;

	public VentanaAutor(String autor, Libro libro, Usuario u) {
		usuario = u;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
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
				VentanaLibro v1 = new VentanaLibro(libro, usuario);
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
		atrasIMG.setBounds(1, 5, 25, 25);
		atrasPanel.add(atrasIMG);
		navBarPanel.add(atrasPanel);

		JLabel lblBiblioteca = new JLabel("Biblioteca Online");
		lblBiblioteca.setBounds(80, 20, 205, 29);
		lblBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 24));
		navBarPanel.add(lblBiblioteca);

		JLabelGraficoAjustado icono = new JLabelGraficoAjustado("src/main/resources/logos/logoS.png", 60, 50);
		icono.setBounds(10, 13, 60, 50);
		navBarPanel.add(icono);

		final JPanel bookPanel = new JPanel();
		bookPanel.setLayout(null);
		bookPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		bookPanel.setBounds(197, 62, 800, 711);
		bookPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(bookPanel);


		//Cabecera
		final JLabel cabecera = new JLabel("Información sobre el autor");
		cabecera.setBounds(262, 11, 320, 50);
		Font fuente2 = new Font("Book Antiqua", 3, 20);
		cabecera.setFont(new Font("Tahoma", Font.BOLD, 20));
		cabecera.setForeground(Color.BLACK);
		bookPanel.add(cabecera);

		// Nombre
		final JLabel label1 = new JLabel("Nombre: ");
		label1.setBounds(20, 110, 150, 50);
		label1.setFont(fuente2);
		label1.setForeground(Color.WHITE);
		bookPanel.add(label1);

		// ResultadoNombre
		DB db = new DB();


		final JLabel label11 = new JLabel(autor);
		//final JLabel label11 = new JLabel("Prueba");
		label11.setBounds(125, 110, 400, 50);
		label11.setFont(fuente2);
		label11.setForeground(Color.WHITE);
		bookPanel.add(label11);


		// Anyo Nacimiento
		final JLabel label3 = new JLabel("Año de nacimiento: ");
		label3.setBounds(20, 175, 400, 50);
		label3.setFont(fuente2);
		label3.setForeground(Color.WHITE);
		bookPanel.add(label3);

		// ResultadoAnyoNacimiento
		String anyoNacimiento = null;
		try {
			anyoNacimiento = Integer.toString(db.anyoNacAutor(autor, "gestion_biblioteca_db"));
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		final JLabel label33 = new JLabel(anyoNacimiento);
		//final JLabel label33 = new JLabel("Prueba");
		label33.setBounds(220, 175, 150, 50);
		label33.setFont(fuente2);
		label33.setForeground(Color.WHITE);
		bookPanel.add(label33);

		// Lugar nacimiento
		final JLabel label4 = new JLabel("Lugar de nacimiento: ");
		label4.setBounds(20, 240, 400, 50);
		label4.setFont(fuente2);
		label4.setForeground(Color.WHITE);
		bookPanel.add(label4);

		// ResultadoLugarNacimiento
		String lugarNacimiento = null;
		try {
			lugarNacimiento = db.LugarNacAutor(autor, "gestion_biblioteca_db");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		final JLabel label44 = new JLabel(lugarNacimiento);
		//final JLabel label44 = new JLabel("Prueba");
		label44.setBounds(240, 240, 400, 50);
		label44.setFont(fuente2);
		label44.setForeground(Color.WHITE);
		bookPanel.add(label44);

		// Nº libros publicados
		final JLabel label5 = new JLabel("Nº libros publicados: ");
		label5.setBounds(20, 305, 400, 50);
		label5.setFont(fuente2);
		label5.setForeground(Color.WHITE);
		bookPanel.add(label5);

		String librosPublicados = null;
		try {
			librosPublicados = Integer.toString(db.numLibrosPublicados(autor, "gestion_biblioteca_db"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		final JLabel label55 = new JLabel(librosPublicados);
		label55.setBounds(230, 305, 400, 50);
		label55.setFont(fuente2);
		label55.setForeground(Color.WHITE);
		bookPanel.add(label55);
		
		JLabelGraficoAjustado fotoAutor = new JLabelGraficoAjustado("src/main/resources/usuario/icono-perfil.png", 160, 165);
		fotoAutor.setLocation(550, 110);
		bookPanel.add(fotoAutor);


	}
	/*
	public static void main (String [ ] args) {
		VentanaAutor v = new VentanaAutor("Vanesa Redondo");
		v.setVisible(true);
	}*/
}