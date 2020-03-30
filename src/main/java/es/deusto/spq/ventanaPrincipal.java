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
import javax.swing.JTextField;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
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
	public ventanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 176, 174));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(new Color(0, 119, 118));
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setFont(new Font("Rockwell", Font.BOLD, 14));
		loginbtn.setBounds(1040, 20, 140, 30);
		loginbtn.setOpaque(false);
		loginbtn.setContentAreaFilled(false);
		loginbtn.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.add(loginbtn);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setBounds(1050, 21, 24, 24);
		JLabel loginIMG = new JLabel();
		loginIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/usuario.png")));
		loginPanel.add(loginIMG);
		navBarPanel.add(loginPanel);
		
		textField = new JTextField();
		textField.setBounds(347, 20, 500, 30);
		navBarPanel.add(textField);
		textField.setColumns(10);
		
		JButton searchbtn = new JButton();
		searchbtn.setOpaque(false);
		searchbtn.setContentAreaFilled(false);
		searchbtn.setBounds(850, 20, 30, 30);
		searchbtn.setLayout(null);
		searchbtn.setFocusable(false);
		JLabel searchIMG = new JLabel();
		searchIMG.setBounds(0, 0, 30, 30);
		searchIMG.setFocusable(false);
		searchIMG.setIcon(new ImageIcon(getClass().getResource("/es/deusto/spq/resources/lupaP.png")));
		searchbtn.add(searchIMG);
		navBarPanel.add(searchbtn);
		
		JPanel bookPanel = new JPanel();
		bookPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		bookPanel.setBounds(197, 62, 800, 711);
		bookPanel.setBackground(new Color(0, 119, 118));
		contentPane.add(bookPanel);
		bookPanel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(781, 0, 17, 709);
		bookPanel.add(scrollBar);
	}
}
