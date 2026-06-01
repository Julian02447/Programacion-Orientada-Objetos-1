package Modelo;

public abstract class FiguraGeometrica {
    protected String nombre;

    public FiguraGeometrica() {
    }

    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}
