package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.db.DB;
import es.deusto.spq.interfaces.ILista;
import es.deusto.spq.utils.JLabelGraficoAjustado;

/** Ventana utilizada por el bibliotecario para la administración d ela biblioteca, donde se pueden consultar los libros, el panel de estadísticas,
 * y la ubicación de los libros.
 * @author Victor
 *
 */
public class VentanaAdministracion extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtField;
	private ILista interfazLista;
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
	String Libro;
	String Autor;
	String ISBN;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	String genero;
	String editorial;
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_9;
	private ArrayList<Libro> arrayResultado = new ArrayList<Libro>();

	public VentanaAdministracion() {

		setResizable(false);
		setSize(1200, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		contentPane.setLayout(null);
		
		try {
			arrayLibros = database.getLibros("gestion_biblioteca_db");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		JLabelGraficoAjustado icono = new JLabelGraficoAjustado("src/main/resources/logos/logoS.png", 60, 50);
		icono.setLocation(10, 13);
		navBarPanel.add(icono);
		
		JLabel lblBiblioteca = new JLabel("Biblioteca Online");
		lblBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBiblioteca.setBounds(80, 20, 205, 29);
		navBarPanel.add(lblBiblioteca);
		
		final JLabelGraficoAjustado lupa = new JLabelGraficoAjustado("src/main/resources/lupa/lupaP.png", 20, 20);
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
					}if(arrayResultado.isEmpty()) {
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
		rdbtnISBN.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnISBN.setContentAreaFilled(false);
		rdbtnISBN.setBounds(1045, 167, 109, 23);
		contentPane.add(rdbtnISBN);
		
		rdbtnEditorial = new JRadioButton("Editorial");
		rdbtnEditorial.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnEditorial.setBounds(1045, 193, 109, 23);
		rdbtnEditorial.setContentAreaFilled(false);
		rdbtnEditorial.setSelected(true);
		contentPane.add(rdbtnEditorial);
		
		filtro.add(rdbtnTitulo);
		filtro.add(rdbtnAutor);
		filtro.add(rdbtnISBN);
		filtro.add(rdbtnEditorial);
		
		JLabel lblNewLabel = new JLabel("Libro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 117, 84, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 183, 84, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 248, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		
		lblNewLabel_3 = new JLabel(Libro);
		lblNewLabel_3.setBounds(10, 147, 177, 18);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel(Autor);
		lblNewLabel_4.setBounds(10, 217, 177, 18);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel(ISBN);
		lblNewLabel_5.setBounds(10, 277, 177, 18);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Género:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 315, 84, 13);
		contentPane.add(lblNewLabel_6);	
		
		lblNewLabel_7 = new JLabel(genero);
		lblNewLabel_7.setBounds(10, 345, 177, 18);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_9 = new JLabel(editorial);
		lblNewLabel_9.setBounds(10, 413, 177, 18);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Editorial:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 383, 70, 13);
		contentPane.add(lblNewLabel_8);
		
		JButton botonEstadisticas = new JButton("Estadísticas");
		botonEstadisticas.setBounds(7, 70, 180, 30);
		botonEstadisticas.setForeground(new Color(0,0,0));
		botonEstadisticas.setFocusable(false);
		botonEstadisticas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEstadisticas ve = new VentanaEstadisticas();
				ve.setVisible(true);
			}
		});
		contentPane.add(botonEstadisticas);
		
		bookPanel.addMouseListener(new MouseListener() {
			
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
				Libro = arrayLibros.get(bookPanel.getSelectedIndex()).getTitulo();
				Autor = arrayLibros.get(bookPanel.getSelectedIndex()).getAutor();
				ISBN = Integer.toString(arrayLibros.get(bookPanel.getSelectedIndex()).getISBN());
				genero = arrayLibros.get(bookPanel.getSelectedIndex()).getGenero();
				editorial = arrayLibros.get(bookPanel.getSelectedIndex()).getEditorial();
				lblNewLabel_3.setText(Libro);
				lblNewLabel_4.setText(Autor);
				lblNewLabel_5.setText(ISBN);
				lblNewLabel_7.setText(genero); 
				lblNewLabel_9.setText(editorial); 
				if (e.getClickCount() == 2) {
					VentanaUbicacion vu = new VentanaUbicacion(Libro);
					vu.setVisible(true);
				}

			}
		});
	
	}
}
