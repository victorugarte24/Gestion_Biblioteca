package es.deusto.spq;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setSize(1200, 800);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 92, 26));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		JButton logobtn = new JButton();
		logobtn.setBounds(40, 5, 50, 60);
		logobtn.setBorder(null);
		logobtn.setFocusPainted(false);
		logobtn.setFocusable(false);
		logobtn.setContentAreaFilled(false);		
		logobtn.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/es/deusto/spq/resources/logoS.png")));
		navBarPanel.add(logobtn);		
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setForeground(Color.LIGHT_GRAY);
		loginbtn.setFont(new Font("Rockwell", Font.BOLD, 14));
		loginbtn.setFocusPainted(false);
		loginbtn.setBounds(1040, 20, 140, 30);
		loginbtn.setOpaque(false);
		loginbtn.setContentAreaFilled(false);
		loginbtn.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(loginbtn);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setBounds(1050, 18, 26, 28);
		loginPanel.setBorder(null);
		JLabel loginIMG = new JLabel();
		loginIMG.setBounds(1050, 20, 24, 26);
		loginIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/user.png")));
		loginPanel.add(loginIMG);
		navBarPanel.add(loginPanel);
		
		textField = new JTextField();
		textField.setBounds(347, 20, 500, 30);
		navBarPanel.add(textField);
		textField.setColumns(10);
		
		JButton searchbtn = new JButton();
		searchbtn.setOpaque(false);
		searchbtn.setContentAreaFilled(false);
		searchbtn.setBounds(855, 20, 30, 30);
		searchbtn.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		searchbtn.setBorder(null);
		searchbtn.setFocusable(true);
		/*
		JLabel searchIMG = new JLabel();
		searchIMG.setBounds(0, 0, 30, 30);
		searchIMG.setFocusable(false);
		searchIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		searchbtn.add(searchIMG);*/
		navBarPanel.add(searchbtn);
		
		JScrollPane bookPanel = new JScrollPane();
		bookPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		bookPanel.setBounds(197, 62, 800, 711);
		bookPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(bookPanel);
		bookPanel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(780, 0, 17, 709);
		bookPanel.add(scrollBar);
	}
}
