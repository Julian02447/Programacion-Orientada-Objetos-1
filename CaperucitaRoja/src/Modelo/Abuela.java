package Modelo;

public class Abuela {
    private String nombre;
    private int    edad;
    private String estadoSalud;
    private boolean rescatada;

    public Abuela() {
        this.edad        = 70;
        this.estadoSalud = "Delicada";
        this.rescatada   = false;
    }

    public Abuela(String nombre, int edad, String estadoSalud) {
        this();
        this.nombre      = nombre;
        this.edad        = edad;
        this.estadoSalud = estadoSalud;
    }

    public String getNombre()     { return nombre;      }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad()          { return edad;        }
    public void setEdad(int edad) { this.edad = edad;   }

    public String getEstadoSalud() { return estadoSalud; }
    public void setEstadoSalud(String estadoSalud) { this.estadoSalud = estadoSalud; }

    public boolean isRescatada()  { return rescatada;   }
    public void setRescatada(boolean rescatada) { this.rescatada = rescatada; }


    public String serEnganiada(Lobo lobo) {
        return nombre + " abre la puerta creyendo que es su nieta y es capturada por el lobo." +System.lineSeparator()+lobo.disfrazarse();
    }

    public String serRescatada() {
        this.rescatada   = true;
        this.estadoSalud = "Recuperándose";
        return "¡" + nombre + " ha sido rescatada! Su estado de salud: " + estadoSalud + ".";
    }

    @Override
    public String toString() { return nombre + " (edad " + edad + ")"; }
}
