package modelo;

public class Proyecto {

    private String nombre;
    private String tipo;
    private Producto producto;

    public Proyecto() {
    }

    public Proyecto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void addProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
