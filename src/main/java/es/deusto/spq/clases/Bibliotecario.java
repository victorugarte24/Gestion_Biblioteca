package es.deusto.spq.clases;

public class Bibliotecario {
	
	int ID;
	String nombre;
	String apellido;
	
	public Bibliotecario(int ID, String nombre, String apellido) {
		this.ID = ID;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
