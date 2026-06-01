package Modelo;

public class Lobo {
    private String  nombre;
    private boolean disfrazado;

    public Lobo() {
        this.disfrazado = false;
    }

    public Lobo(String nombre, int velocidad) {
        this();
        this.nombre    = nombre;
    }

    public String getNombre()   { return nombre;    }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isDisfrazado() { return disfrazado; }

    // Operaciones
    public String hablar() {
        return nombre + ": \"¿A dónde vas, niña? El bosque es peligroso... deja que te acompañe.\"";
    }

    public String correr() {
        return nombre + " corre por el atajo hacia la cabaña de la abuela. ¡Llega primero!";
    }

    public String disfrazarse() {
        this.disfrazado = true;
        return nombre + " se disfraza de abuela: se mete en la cama y espera a Caperucita.";
    }

    public String serDerrotado() {
        this.disfrazado = false;
        return nombre + " es vencido por el Leñador. Su vientre es abierto y rellenado de piedras. ¡El bosque está a salvo!";
    }

    @Override
    public String toString() { return nombre + (disfrazado ? " [disfrazado]" : ""); }
}
