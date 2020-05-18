package es.deusto.spq.clases;

/**
 * Esta clase hace referencia a los usuarios de la aplicacion
 * @author sergio
 *
 */
public class Usuario {

    private String Nombre;
    private String Apellido;
    private String Usuario;
    private int DNI;
    private String Contrasenya;

    public Usuario() {

    }

    /**
     * @param Usuario - Nick del usuario
     * @param Nombre - Nombre del usuario
     * @param Apellido  Apellido del usuario
     * @param DNI - DNI del usuario
     * @param Contrasenya - Contrasenya que usa el usuario en la aplicacion
     */
    public Usuario(String Usuario,String Nombre, String Apellido, int DNI, String Contrasenya) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Contrasenya = Contrasenya;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
	}

	public String getContrasenya() {
		return Contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		Contrasenya = contrasenya;
	}
	
	public void tomarPrestadoLibro() {
		
	}

	@Override
    public String toString() {
        return "Usuario: " + Usuario + " Nombre: " + Nombre + " Apellido: " + Apellido;
    }
}

