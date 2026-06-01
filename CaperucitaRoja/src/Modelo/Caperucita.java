package Modelo;

public class Caperucita {
    private String nombre;
    private String colorCapa;
    private Cesta  cesta;
    private boolean enPeligro;

    public Caperucita() {
        this.colorCapa  = "Roja";
        this.cesta      = new Cesta();
        this.enPeligro  = false;
    }

    public Caperucita(String nombre, String colorCapa) {
        this();
        this.nombre    = nombre;
        this.colorCapa = colorCapa;
    }

    public String getNombre()    { return nombre;    }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getColorCapa() { return colorCapa; }
    public void setColorCapa(String colorCapa) { this.colorCapa = colorCapa; }

    public Cesta getCesta()      { return cesta;     }
    public void setCesta(Cesta cesta) { this.cesta = cesta; }

    public boolean isEnPeligro() { return enPeligro; }
    public void setEnPeligro(boolean enPeligro) { this.enPeligro = enPeligro; }

    public String caminarAlBosque() {
        return nombre + " toma su cesta y empieza a caminar por el bosque hacia la cabaña de su abuela.";
    }

    public String hablarConLobo(Lobo lobo) {
        this.enPeligro = true;
        return nombre + " se encuentra con " + lobo.getNombre()
                + " en el camino. El lobo la saluda con una sonrisa engañosa.";
    }

    public String llegarACabania(Abuela abuela) {
        return nombre + " llega a la cabaña y llama a la puerta: \"¡Abuelita, soy yo, "
                + nombre + "! Te traigo comida en mi cesta.\"";
    }

    @Override
    public String toString() { return nombre + " (Capa " + colorCapa + ")"; }
}
