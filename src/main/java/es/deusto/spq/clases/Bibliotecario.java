package es.deusto.spq.clases;

/** Clase para la creación de los bibliotecarios
 * @author Victor
 *
 */
public class Bibliotecario {
	
	int ID;
	String nombre;
	String apellido;
	
	/** Crea un bibliotecario con los distintos parametros que lo forman.
	 * @param ID  ID del bibliotecario
	 * @param nombre Nombre del bibliotecario
	 * @param apellido Apellido del bibliotecario
	 */
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
