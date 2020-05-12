package es.deusto.spq.ventanas;

import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import es.deusto.spq.db.DB;
import es.deusto.spq.utils.JLabelGraficoAjustado;

import java.awt.Color;
import java.awt.Font;

public class VentanaUbicacion extends JFrame{
	
	String Ubicacion = "";
	JLabelGraficoAjustado mapa;
	String Pasillo;
	
	public VentanaUbicacion(String Titulo) {
		setResizable(false);
		setSize(700, 680);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/logos/logoS.png"));
		this.setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Biblioteca Online");
		getContentPane().setLayout(null);
		
		DB db = new DB();
		
		try {
			Ubicacion = db.buscarUbicacionLibro(Titulo, "gestion_biblioteca_db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Ubicación:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(90, 176, 91, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Ubicacion);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(173, 175, 445, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Biblioteca Online");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(230, 43, 240, 29);
		getContentPane().add(lblNewLabel_2);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("Título:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(90, 122, 70, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(Titulo);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(140, 120, 466, 17);
		getContentPane().add(lblNewLabel_4);
		
		Pasillo = cortarPalabra(Ubicacion);
		
		switch (Pasillo){
		case "1":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas1.jpg", 500, 350);
			break;
		case "2":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas2.jpg", 500, 350);
			break;
		case "3":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas3.jpg", 500, 350);
			break;
		case "4":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas4.jpg", 500, 350);
			break;
		case "5":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas5.jpg", 500, 350);
			break;
		case "6":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas6.jpg", 500, 350);
			break;
		case "7":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas1.jpg", 500, 350);
			break;
		case "8":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas2.jpg", 500, 350);
			break;
		case "9":
			mapa = new JLabelGraficoAjustado("src/main/resources/ubicacion/bibliotecapas3.jpg", 500, 350);
			break;
		} 
		
		mapa.setLocation(90, 240);
		getContentPane().add(mapa);
		

	}

	public String cortarPalabra (String Ubicacion){ 
		String s = "";
		String[] arrOfStr = Ubicacion.split(" ", 5);
		s = arrOfStr[3];
		return s;
	} 

	public static void main (String [ ] args) {
		VentanaUbicacion v = new VentanaUbicacion("1793");
		v.setVisible(true);
	}
}
