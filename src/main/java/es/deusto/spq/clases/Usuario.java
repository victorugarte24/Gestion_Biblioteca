package es.deusto.spq.usuario;

public class Usuario {

    private int id;
    private String Nombre;
    private String Apellido;
    private String Usuario;
    private String DNI;
    private String Contrasenya;

    public Usuario() {

    }

    public Usuario(String Nombre, String Apellido, String Usuario, String DNI, String Contrasenya) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.DNI = DNI;
        this.setContrasenya(Contrasenya);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
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
        return "ID: " + id + "Usuario: " + Usuario + "Nombre" + Nombre + "Apellido: " + Apellido;
    }
}
