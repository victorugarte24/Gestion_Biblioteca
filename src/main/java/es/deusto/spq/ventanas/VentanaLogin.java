package es.deusto.spq.ventanas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import es.deusto.spq.db.DB;
import es.deusto.spq.utils.JLabelGraficoAjustado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class VentanaLogin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	
	public VentanaLogin(){
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logoS.png"));
		setDefaultCloseOperation(VentanaLogin.DISPOSE_ON_CLOSE );
		setTitle("Biblioteca Online");
		setSize(600, 400);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);

		JLabelGraficoAjustado icono = new JLabelGraficoAjustado("src/main/resources/logoP.png", 160, 135);
		icono.setLocation(380, 110);
		getContentPane().add(icono);

		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB database = new DB();
				try {

					if (rdbtnNewRadioButton.isSelected() == true) { //Login Bibliotecario
						if (database.comprobarContrasenyaBibliotecario(textField_1.getText()).equals(passwordField.getText())) {
							JOptionPane.showMessageDialog(null, "Usuario Correcto");
							dispose();
							VentanaAdministración va = new VentanaAdministración();
							va.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
						}
					}
					else if (rdbtnNewRadioButton_1.isSelected() == true) { //Login Usuario
						if (database.comprobarContrasenya(textField_1.getText()).equals(passwordField.getText())) {
							JOptionPane.showMessageDialog(null, "Usuario Correcto");
							dispose();
							VentanaPrincipal vp = new VentanaPrincipal();
							vp.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione el tipo de usuario");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(68, 318, 141, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(380, 318, 128, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vr = new VentanaRegistro();
				vr.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(195, 131, 141, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(81, 134, 74, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(81, 204, 96, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Biblioteca Online");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(193, 37, 205, 29);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(195, 204, 141, 21);
		getContentPane().add(passwordField);
		
		rdbtnNewRadioButton = new JRadioButton("Bibliotecario");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(346, 270, 103, 21);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_1.setSelected(false);

			}
		});
		getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("Usuario");
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(473, 270, 103, 21);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);

			}
		});
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione el tipo de usuario:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(81, 270, 255, 17);
		getContentPane().add(lblNewLabel_3);
		
	}

	public static void main (String [ ] args) {
		VentanaLogin v = new VentanaLogin();
		v.setVisible(true);
	}
}

