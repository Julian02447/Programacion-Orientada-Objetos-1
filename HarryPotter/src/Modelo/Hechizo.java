package Modelo;

public class Hechizo {

    private String nombre;
    private String descripcion;
    private int poder;

    public Hechizo() {}

    public Hechizo(String nombre, String descripcion, int poder) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poder = poder;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getPoder() { return poder; }
    public void setPoder(int poder) { this.poder = poder; }

    @Override
    public String toString() {
        return nombre + " (poder: " + poder + ")";
    }
}
