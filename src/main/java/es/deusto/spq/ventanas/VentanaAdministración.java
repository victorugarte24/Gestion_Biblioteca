package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import es.deusto.spq.clases.Libro;
import es.deusto.spq.utils.JLabelGraficoAjustado;

public class VentanaAdministración extends JFrame{
	private JTextField textField;

	
	public VentanaAdministración() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/es/deusto/spq/resources/logoS.png"));
		setDefaultCloseOperation(VentanaAdministración.DISPOSE_ON_CLOSE );
		setTitle("Biblioteca Online");
		setResizable(false);
		this.getContentPane().setBackground(Color.lightGray);
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		
		JPanel navBarPanel = new JPanel();
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBackground(Color.WHITE);
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
				//Buscar Libro
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
		getContentPane().setLayout(null);

		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnSalir.setFocusPainted(false);
		btnSalir.setBounds(1040, 20, 140, 30);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(btnSalir);

		
		getContentPane().add(navBarPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(385, 19, 453, 30);
		navBarPanel.add(textField);
		textField.setColumns(10);
		
		//JLabelGraficoAjustado footer = new JLabelGraficoAjustado("src/main/java/es/deusto/spq/resources/Footer.jpg", 1200, 150);
		//footer.setLocation(-5, 622);
		//getContentPane().add(footer, BorderLayout.SOUTH);
		
	}

	public static void main (String [ ] args) {
		VentanaAdministración v = new VentanaAdministración();
		v.setVisible(true);
	}
}
