package es.deusto.spq.ventanas;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Ventana_Registro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	Ventana_Registro(){
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/es/deusto/spq/resources/logoS.png"));
		setDefaultCloseOperation(Ventana_Registro.DISPOSE_ON_CLOSE );
		setTitle("Biblioteca Online");
		setSize(570, 470);
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 108, 68, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(56, 149, 68, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(56, 197, 61, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(56, 243, 45, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(56, 283, 96, 13);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Repetir Contrase\u00F1a:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(56, 325, 146, 17);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Biblioteca Online");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_6.setBounds(172, 35, 205, 29);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(122, 374, 131, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Login vi = new Ventana_Login();
				vi.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(326, 374, 120, 29);
		getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(134, 107, 334, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(134, 148, 334, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(134, 196, 334, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setBounds(106, 242, 362, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(162, 282, 306, 21);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField_1.setBounds(212, 326, 256, 21);
		getContentPane().add(passwordField_1);
		
		
		
	}

	public static void main (String [ ] args) {
		Ventana_Registro v = new Ventana_Registro();
		v.setVisible(true);
	}
}