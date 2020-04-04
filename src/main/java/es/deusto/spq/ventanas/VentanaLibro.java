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
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaLibro extends JFrame{
	/**
	 *
	 */
	private final JPanel contentPane;
	private final JScrollPane scrollpane1;
	private final JTextArea textarea1;
	static VentanaLibro frame;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaLibro();
					frame.setSize(1200, 800);
					frame.setVisible(true);

				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLibro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
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

		final JButton logobtn = new JButton();
		logobtn.setBounds(40, 5, 50, 60);
		logobtn.setBorder(null);
		logobtn.setFocusPainted(false);
		logobtn.setFocusable(false);
		logobtn.setContentAreaFilled(false);
		logobtn.setIcon(new ImageIcon(VentanaLibro.class.getResource("/es/deusto/spq/resources/logoS.png")));
		navBarPanel.add(logobtn);

		final JButton btnAtras = new JButton("Atras");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnAtras.setFocusPainted(false);
		btnAtras.setBounds(1040, 20, 140, 30);
		btnAtras.setOpaque(false);
		btnAtras.setContentAreaFilled(false);
		btnAtras.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal p = new VentanaPrincipal();
				p.setVisible(true);
				frame.dispose();
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

		// Título
		final JLabel label1 = new JLabel("Título: ");
		label1.setBounds(20, 10, 150, 50);
		final Font fuente2 = new Font("Book Antiqua", 3, 20);
		label1.setFont(fuente2);
		label1.setForeground(Color.WHITE);
		bookPanel.add(label1);

		// Autor
		final JLabel label2 = new JLabel("Autor: ");
		label2.setBounds(20, 75, 150, 50);
		label2.setFont(fuente2);
		label2.setForeground(Color.WHITE);
		bookPanel.add(label2);

		// Número de páginas
		final JLabel label3 = new JLabel("Nº de Páginas: ");
		label3.setBounds(20, 140, 150, 50);
		label3.setFont(fuente2);
		label3.setForeground(Color.WHITE);
		bookPanel.add(label3);

		// ISBN
		final JLabel label4 = new JLabel("ISBN: ");
		label4.setBounds(20, 205, 150, 50);
		label4.setFont(fuente2);
		label4.setForeground(Color.WHITE);
		bookPanel.add(label4);

		// Sinopsis
		final JLabel label5 = new JLabel("Sinopsis: ");
		label5.setBounds(20, 270, 150, 50);
		label5.setFont(fuente2);
		label5.setForeground(Color.WHITE);
		bookPanel.add(label5);
		textarea1=new JTextArea();
		textarea1.setEditable(false);
		scrollpane1=new JScrollPane(textarea1);
		scrollpane1.setBounds(20, 320, 600, 90);
		bookPanel.add(scrollpane1);

	}
}
