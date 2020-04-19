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
import es.deusto.spq.db.DB;
import es.deusto.spq.utils.JLabelGraficoAjustado;

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


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtField;
	private JList bookPanel = new JList();
	private ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
	private File bd;
	private static VentanaPrincipal frame;
	private DB database = new DB();
	private String libroBuscado;

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

		try {
			arrayLibros = database.getLibros();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		init();
	}

	public void init() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/es/deusto/spq/resources/logoS.png"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 92, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		contentPane.setLayout(null);

		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		JLabelGraficoAjustado icono = new JLabelGraficoAjustado("src/main/java/es/deusto/spq/resources/logoS.png", 60, 50);
		icono.setLocation(10, 13);
		navBarPanel.add(icono);
		
		JLabel lblNewLabel_bo = new JLabel("Biblioteca Online");
		lblNewLabel_bo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_bo.setBounds(80, 20, 205, 29);
		navBarPanel.add(lblNewLabel_bo);
		
		final JLabelGraficoAjustado lupa = new JLabelGraficoAjustado("src/main/java/es/deusto/spq/resources/lupaP.png", 20, 20);
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
				
				if(libroBuscado.isEmpty()) {
					cargarLista(arrayLibros);
				}else {
					for (int i = 0; i < arrayLibros.size(); i++) {
						if (libroBuscado.equals(arrayLibros.get(i).getTitulo().toLowerCase())) {
							ArrayList<Libro> a = new ArrayList<Libro>();
							a.add(arrayLibros.get(i));
							cargarLista(a);
						}
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

		cargarLista(arrayLibros);

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
		btnLibro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLibro vl = new VentanaLibro(arrayLibros.get(bookPanel.getSelectedIndex()));
				vl.setVisible(true);
			}
		});

	}


	public void cargarLista(ArrayList<Libro> a) {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		for(Libro l : a) {
			modelo.addElement(l.getTitulo());
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
		bookPanel.setBackground(new Color(90, 64, 17));
	}
}

