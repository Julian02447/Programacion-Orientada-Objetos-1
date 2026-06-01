package Modelo;

public abstract class ObjetoInteractivo {
    protected String nombre;
    protected String descripcion;

    public ObjetoInteractivo() {
    }

    public ObjetoInteractivo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public abstract String usar();

    @Override
    public String toString() {
        return nombre;
    }
}
