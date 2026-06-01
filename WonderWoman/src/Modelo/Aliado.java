package Modelo;

public class Aliado {
    private String nombre;
    private String habilidad;
    private String frase; 

    public Aliado() {
    }

    public Aliado(String nombre, String habilidad, String frase) {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.frase = frase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    // Operaciones
    public String interactuar() {
        return "[" + nombre + " dice]: \"" + frase + "\"";
    }

    @Override
    public String toString() {
        return nombre;
    }
}
