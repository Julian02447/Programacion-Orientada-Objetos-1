package Modelo;

public class Lenador {
    private String nombre;
    private String herramienta; 

    public Lenador() {
        this.herramienta = "Hacha";
    }

    public Lenador(String nombre, String herramienta) {
        this.nombre      = nombre;
        this.herramienta = herramienta;
    }

    public String getNombre()      { return nombre;      }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getHerramienta() { return herramienta; }
    public void setHerramienta(String herramienta) { this.herramienta = herramienta; }

    // Operaciones
    public String rescatar(Caperucita caperucita, Abuela abuela, Lobo lobo) {
        caperucita.setEnPeligro(false);
        String resultadoLobo   = lobo.serDerrotado();
        String resultadoAbuela = abuela.serRescatada();
        return nombre + " llega con su " + herramienta + " y actúa con valentía." + System.lineSeparator()
                + resultadoLobo + System.lineSeparator()
                + resultadoAbuela + System.lineSeparator()
                + caperucita.getNombre() + " también está a salvo. ¡El bosque recupera su paz!";
    }

    @Override
    public String toString() { return nombre + " (porta: " + herramienta + ")"; }
}
