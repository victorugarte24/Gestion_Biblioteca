package es.deusto.spq.clases;

public class Autor {

    private String Nombre;
    private int anyoNacimiento;
    private String lugarNacimiento;
    private int numLibrosPublicados;

    public Autor() {

    }

    public Autor(String Nombre, int anyoNacimiento, String lugarNacimiento, int numLibrosPublicados) {
        this.Nombre = Nombre;
        this.anyoNacimiento = anyoNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.numLibrosPublicados = numLibrosPublicados;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
        return "Autor [Nombre=" + Nombre + ", anyoNacimiento=" + anyoNacimiento
                + ", lugarNacimiento=" + lugarNacimiento + ", numLibrosPublicados=" + numLibrosPublicados + "]";
    }

}