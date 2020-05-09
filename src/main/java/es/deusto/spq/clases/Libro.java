package es.deusto.spq.clases;

import java.util.ArrayList;

public class Libro {

    private String titulo;
    private String autor;
    private int numPags;
    private int ISBN;
    private String sinopsis;
    private int prestado; // 1 prestado, 0 no prestado
    private String genero;
    private String editorial;
    private ArrayList<String> usuarios = new ArrayList<String>();
    private ArrayList<String> opiniones = new ArrayList<String>();
    

	public Libro (String titulo, String autor, int numPags, int ISBN, String sinopsis, int prestado, String genero, String editorial){
		this.titulo = titulo;
		this.autor = autor;
		this.numPags = numPags;
		this.ISBN = ISBN;
		this.sinopsis = sinopsis;
		this.prestado = prestado;
		this.genero = genero;
		this.editorial = editorial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPags() {
		return numPags;
	}

	public void setNumPags(int numPags) {
		this.numPags = numPags;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	public int getPrestado() {
		return prestado;
	}

	public void setPrestado(int prestado) {
		this.prestado = prestado;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public ArrayList<String> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<String> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<String> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(ArrayList<String> opiniones) {
		this.opiniones = opiniones;
	}
	
	public String toString() {
		return "\n"+ this.getTitulo().toUpperCase() + "\nAutor: " + this.getAutor() + "\nNumero de paginas: " + this.getNumPags() + "\nISBN: " + this.getISBN() + "\nSinopsis: "+ this.getSinopsis() + "\nPrestado: "+ this.getPrestado() +"\nGenero: "+ this.getGenero() + "\nEditorial: "+ this.getEditorial() +"\n\n";
	}
}
