package Modelo;

public class Bosque {
    private String    nombre;
    private double    tamañoHectareas;

    public Bosque() {
        this.tamañoHectareas = 100.0;
    }

    public Bosque(String nombre, double tamañoHectareas) {
        this.nombre           = nombre;
        this.tamañoHectareas  = tamañoHectareas;
    }

    public String getNombre()   { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getTamañoHectareas() { return tamañoHectareas; }
    public void setTamañoHectareas(double tamañoHectareas) { this.tamañoHectareas = tamañoHectareas; }


    public String describir() {
        return "Bosque \"" + nombre + "\": " + tamañoHectareas
                + " hectáreas de arboles que se convierte en un lugar oscuro y misterioso.";
    }

    @Override
    public String toString() { return nombre + " (" + tamañoHectareas + " ha)"; }
}
