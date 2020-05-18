package es.deusto.spq.clases;

/** Clase para la creación de los autores
 * @author Victor
 *
 */
public class Autor {

	private String nombre;
	private int anyoNacimiento;
	private String lugarNacimiento;
	private int numLibrosPublicados;

	public Autor() {

	}

	/** Crea un autor con los distintos parametros que lo forman.
	 * @param Nombre Nombre del autor
	 * @param anyoNacimiento Año de nacimiento del autor
	 * @param lugarNacimiento Lugar de nacimiento del autor
	 * @param numLibrosPublicados Número de Libros publicados por autor 
	 */
    public Autor(String Nombre, int anyoNacimiento, String lugarNacimiento, int numLibrosPublicados) {
        this.nombre = Nombre;
        this.anyoNacimiento = anyoNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.numLibrosPublicados = numLibrosPublicados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }


    public int getanyoNacimiento() {
        return anyoNacimiento;
    }

    public void setanyoNacimiento(int anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    public String getlugarNacimiento() {
        return lugarNacimiento;
    }

    public void setlugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getnumLibrosPublicados() {
        return numLibrosPublicados;
    }

    public void setnumLibrosPublicados(int numLibrosPublicados) {
        this.numLibrosPublicados = numLibrosPublicados;
    }

    @Override
    public String toString() {
        return "Autor [Nombre=" + nombre + ", anyoNacimiento=" + anyoNacimiento
                + ", lugarNacimiento=" + lugarNacimiento + ", numLibrosPublicados=" + numLibrosPublicados + "]";
    }

}