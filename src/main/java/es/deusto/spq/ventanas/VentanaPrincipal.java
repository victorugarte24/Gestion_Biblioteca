package es.deusto.spq.ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;
import es.deusto.spq.interfaces.ILista;
import es.deusto.spq.utils.JLabelGraficoAjustado;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private ILista interfazLista;
	private JTextField txtField;
	private JList bookPanel = new JList();
	private ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
	private static VentanaPrincipal frame;
	private DB database = new DB();
	private String libroBuscado;
	private ButtonGroup filtro;
	private JRadioButton rdbtnAutor;
	private JRadioButton rdbtnTitulo;
	private JRadioButton rdbtnISBN;
	private JRadioButton rdbtnEditorial;
	private ArrayList<Libro> arrayResultado = new ArrayList<Libro>();
	private Usuario usuario;

	public VentanaPrincipal(Usuario u) {
		try {
			arrayLibros = database.getLibros("gestion_biblioteca_db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		usuario = u;
		init();
	}

	public void init() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logoS.png"));
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		contentPane.setLayout(null);

		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		JLabelGraficoAjustado icono = new JLabelGraficoAjustado("src/main/resources/logoS.png", 60, 50);
		icono.setLocation(10, 13);
		navBarPanel.add(icono);
		
		JLabel lblBiblioteca = new JLabel("Biblioteca Online");
		lblBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBiblioteca.setBounds(80, 20, 205, 29);
		navBarPanel.add(lblBiblioteca);
		
		final JLabelGraficoAjustado lupa = new JLabelGraficoAjustado("src/main/resources/lupaP.png", 20, 20);
		lupa.setLocation(870, 25);
		lupa.addMouseListener(new MouseListener() {
			
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
				
				libroBuscado = txtField.getText().toLowerCase();
				arrayResultado.clear();
				
				if(libroBuscado.isEmpty()) {
					for(Libro l : arrayLibros) {
						arrayResultado.add(l);
					}
					ILista.cargarLista(bookPanel, arrayResultado);
				}else {
					if(rdbtnTitulo.isSelected()==true) {
						for (int i = 0; i < arrayLibros.size(); i++) {
							if (libroBuscado.toLowerCase().equals(arrayLibros.get(i).getTitulo().toLowerCase())) {
								arrayResultado.add(arrayLibros.get(i));
							}
						} ILista.cargarLista(bookPanel, arrayResultado);
					} else if(rdbtnAutor.isSelected()==true) {
						for (int i = 0; i < arrayLibros.size(); i++) {
							if(libroBuscado.toLowerCase().equals(arrayLibros.get(i).getAutor().toLowerCase())) {
								arrayResultado.add(arrayLibros.get(i));
							}
						} ILista.cargarLista(bookPanel, arrayResultado); 
					}else if(rdbtnISBN.isSelected()==true) {
						for (int i = 0; i < arrayLibros.size(); i++) {
							if(Integer.parseInt(libroBuscado) == arrayLibros.get(i).getISBN()) {
								arrayResultado.add(arrayLibros.get(i));
							}
						} ILista.cargarLista(bookPanel, arrayResultado);
					}else if(rdbtnEditorial.isSelected()==true) {
						for (int i = 0; i < arrayLibros.size(); i++) {
							if(libroBuscado.toLowerCase().equals(arrayLibros.get(i).getEditorial().toLowerCase())) {
								arrayResultado.add(arrayLibros.get(i));
							}
						} ILista.cargarLista(bookPanel, arrayResultado);
					}
					
					
					if(arrayResultado.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "No se han encontrado resultados."); 							
					}
				}	
			}
		});
		
		navBarPanel.add(lupa);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin v = new VentanaLogin();
				v.setVisible(true);
				dispose();
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

		txtField = new JTextField();
		txtField.setBounds(347, 20, 500, 30);
		navBarPanel.add(txtField);
		txtField.setColumns(10);

		for(Libro l : arrayLibros) {
			arrayResultado.add(l);
		}
		ILista.cargarLista(bookPanel, arrayResultado);

		JScrollPane scroll = new JScrollPane(bookPanel);
		scroll.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scroll.setBounds(197, 62, 800, 650);
		contentPane.add(scroll);
		
		JButton btnLibro = new JButton("Más información");
		btnLibro.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnLibro.setBounds(507, 725, 180, 30);
		btnLibro.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnLibro.setContentAreaFilled(false);
		btnLibro.setForeground(new Color(0,0,0));
		btnLibro.setFocusable(false);
		contentPane.add(btnLibro);
		
		JLabel lblFiltro = new JLabel("Filtrar por:");
		lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFiltro.setBounds(1015, 81, 169, 24);
		contentPane.add(lblFiltro);
		
		filtro = new ButtonGroup();
		
		rdbtnAutor = new JRadioButton("Autor");
		rdbtnAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnAutor.setBounds(1045, 141, 109, 23);
		rdbtnAutor.setContentAreaFilled(false);
		contentPane.add(rdbtnAutor);
		
		rdbtnTitulo = new JRadioButton("Titulo");
		rdbtnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTitulo.setBounds(1045, 117, 109, 23);
		rdbtnTitulo.setContentAreaFilled(false);
		rdbtnTitulo.setSelected(true);
		contentPane.add(rdbtnTitulo);
		
		rdbtnISBN = new JRadioButton("ISBN");
		rdbtnISBN.setBounds(1045, 165, 109, 23);
		rdbtnISBN.setContentAreaFilled(false);
		contentPane.add(rdbtnISBN);
		
		rdbtnEditorial = new JRadioButton("Editorial");
		rdbtnEditorial.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnEditorial.setBounds(1045, 189, 109, 23);
		rdbtnEditorial.setContentAreaFilled(false);
		rdbtnEditorial.setSelected(true);
		contentPane.add(rdbtnEditorial);
		
		filtro.add(rdbtnTitulo);
		filtro.add(rdbtnAutor);
		filtro.add(rdbtnISBN);
		filtro.add(rdbtnEditorial);
		
		btnLibro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaLibro ventanaLibro = new VentanaLibro(arrayResultado.get(bookPanel.getSelectedIndex()), usuario);
					ventanaLibro.setVisible(true);
					dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "No se ha seleccionado ningún libro.");
				}
				
			}
		});
		
		JButton top10 = new JButton("TOP 10");
		top10.setBounds(7, 75, 180, 30);
		top10.setForeground(new Color(0,0,0));
		top10.setFocusable(false);
		top10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTop vt = new VentanaTop();
				vt.setVisible(true);
			}
		});
		contentPane.add(top10);
	}
}

