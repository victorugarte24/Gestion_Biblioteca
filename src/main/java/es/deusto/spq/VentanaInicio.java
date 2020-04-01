package es.deusto.spq;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class VentanaInicio extends JFrame{
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setSize(1200, 800);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaInicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 92, 26));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel navBarPanel = new JPanel();
		navBarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		navBarPanel.setBounds(-5, -5, 1203, 70);
		navBarPanel.setBackground(new Color(90, 64, 17));
		contentPane.add(navBarPanel);
		navBarPanel.setLayout(null);
		
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
		
		JLabel logolbl = new JLabel("");
		logolbl.setIcon(new ImageIcon(VentanaInicio.class.getResource("/es/deusto/spq/resources/logoP.png")));
		logolbl.setBounds(297, 120, 600, 600);
		contentPane.add(logolbl);
		
	}
}
