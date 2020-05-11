package es.deusto.spq.ventanas;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaEstadisticas extends JFrame{
	
	public VentanaEstadisticas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logoS.png"));
		setSize(650,500);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		
	}
	public static void main (String [ ] args) {
		VentanaEstadisticas v = new VentanaEstadisticas();
		v.setVisible(true);
	}
}
