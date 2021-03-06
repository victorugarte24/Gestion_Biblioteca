package es.deusto.spq.ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.clases.Usuario;
import es.deusto.spq.db.DB;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class VentanaOpiniones extends JFrame{
	static VentanaOpiniones frame;
	private JPanel contentPane;
	private JPanel panelInput;
	private JTextPane textPaneInput;
	private JScrollPane scrollPaneOpinion;
	private JButton btnPublicar;
	private DB database = new DB();
	private Libro libro;
	private Usuario usuario;
	private JTextPane textPaneOpinion = new JTextPane();
	
	public VentanaOpiniones(Libro l, Usuario u) {
		libro = l;
		usuario = u;
		
		try {
			libro.setUsuarios(database.getOpUsuarios(libro, "gestion_biblioteca_db"));
			libro.setOpiniones(database.getOpOpiniones(libro, "gestion_biblioteca_db"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e1) {
		}
		
		Init();
	}
	
	public void Init() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
		setTitle("Biblioteca Online");	
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();	
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(100, 100, 1200, 800);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panelInput = new JPanel();
		panelInput.setBackground(Color.LIGHT_GRAY);
		panelInput.setBorder(new LineBorder(Color.GRAY, 3, true));
		panelInput.setBounds(-3, 481, 900, 93);
		contentPane.add(panelInput);
		panelInput.setLayout(null);
		
		JScrollPane scrollPaneIput = new JScrollPane();
		scrollPaneIput.setAutoscrolls(true);
		scrollPaneIput.setBounds(21, 29, 709, 35);
		
		textPaneInput = new JTextPane();
		textPaneInput.setBounds(0, 0, 86, 20);
		scrollPaneIput.setViewportView(textPaneInput);
		panelInput.add(scrollPaneIput);
		
		btnPublicar = new JButton("Publicar");
		btnPublicar.setForeground(Color.BLACK);
		btnPublicar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnPublicar.setFocusable(false);
		btnPublicar.setContentAreaFilled(false);
		btnPublicar.setBorder(new LineBorder(new Color (0,0,0),3));
		btnPublicar.setBounds(753, 25, 122, 43);
		panelInput.add(btnPublicar);
		
		
		btnPublicar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String o = textPaneInput.getText();
				if(o.length()<=100) {
					ArrayList<Integer> isbn = new ArrayList<Integer>();
					try {
						isbn = database.getOpISBN("gestion_biblioteca_db");
					} catch (SQLException e2) {
						System.out.println("ISBN no cargadas");
						e2.printStackTrace();
					}
					
					if(isbn.contains(libro.getISBN())) {
						if(libro.getUsuarios().contains(usuario.getUsuario())) {
							int i = libro.getUsuarios().indexOf(usuario.getUsuario());
							System.out.println(i);
							
							libro.getUsuarios().remove(i);
							libro.getOpiniones().remove(i);
							
							libro.getUsuarios().add(usuario.getUsuario());
							libro.getOpiniones().add(o);				
							
							try {
								database.modificarOpiniones(libro, libro.getUsuarios(), libro.getOpiniones(), "gestion_biblioteca_db");
								textPaneOpinion.setText(generarOpiniones(libro.getUsuarios(), libro.getOpiniones()));
								textPaneInput.setText("");
							} catch (SQLException e1) {
								e1.printStackTrace();
								textPaneInput.setText("");
							}
						}else{
							libro.getUsuarios().add(usuario.getUsuario());
							libro.getOpiniones().add(o);
							try {
								database.modificarOpiniones(libro, libro.getUsuarios(), libro.getOpiniones(), "gestion_biblioteca_db");
								textPaneOpinion.setText(generarOpiniones(libro.getUsuarios(), libro.getOpiniones()));
								textPaneInput.setText("");
							} catch (SQLException e1) {
								e1.printStackTrace();
								textPaneInput.setText("");
							}
						}
					}else{
						libro.getUsuarios().add(usuario.getUsuario());
						libro.getOpiniones().add(o);
						
						try {
							database.insertarOpiniones(libro, libro.getUsuarios(), libro.getOpiniones(), "gestion_biblioteca_db");
							textPaneOpinion.setText(generarOpiniones(libro.getUsuarios(), libro.getOpiniones()));
							textPaneInput.setText("");
						} catch (SQLException e1) {
							e1.printStackTrace();
							textPaneInput.setText("");
						}
					}
				}else{
					JOptionPane.showMessageDialog(frame, "La opinión no puede tener más de 100 caracteres.");
					textPaneInput.setText("");
				}
			}
		});
		
		textPaneOpinion.setBorder(new LineBorder(new Color(128, 128, 128), 4, true));
		textPaneOpinion.setFont(new Font("Rockwell", Font.PLAIN, 16));
		textPaneOpinion.setEditable(false);
		textPaneOpinion.setBackground(Color.WHITE);
		textPaneOpinion.setBounds(0, 0, 894, 438);
		if(libro.getUsuarios().isEmpty()) {
			textPaneOpinion.setText("No hay opiniones acerca de este libro.");
		} else {
			textPaneOpinion.setText(generarOpiniones(libro.getUsuarios(), libro.getOpiniones()));
		}
		
		scrollPaneOpinion = new JScrollPane(textPaneOpinion);
		scrollPaneOpinion.setBorder(new LineBorder(new Color(128, 128, 128), 0));
		scrollPaneOpinion.setBackground(Color.GRAY);
		scrollPaneOpinion.setBounds(0, 44, 894, 438);
		contentPane.add(scrollPaneOpinion);
		
		JLabel lblTitulo = new JLabel(libro.getTitulo());
		lblTitulo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(-3, 0, 897, 45);
		contentPane.add(lblTitulo);
	}
	
	
	public String generarOpiniones(ArrayList<String> u, ArrayList<String> o) {
		String r = "";
		int i = 0;
		
		while (i < u.size()) {
			String s = "\n    " + u.get(i) + ": " + o.get(i) + "\n";
			r += s;
			i++;
		}
		
		return r;
	}
}
