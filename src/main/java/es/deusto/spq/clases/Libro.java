package es.deusto.spq;

public class Libro {
	private String titulo= "";
	private String autor= "";
	private int numPags=0;
	private int ISBN=0;
	private String sinopsis= "";
	
	public Libro (String titulo, String autor, int numPags, int ISBN, String sinopsis){
		this.titulo = titulo;
		this.autor = autor;
		this.numPags = numPags;
		this.ISBN = ISBN;
		this.sinopsis = sinopsis;
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
}
