package Modelo;

import java.util.ArrayList;

public class WonderWoman {
    private String nombre;
    private String origen;
    private String habilidades;
    private int vida;
    private int ataque;
    private ArrayList<Objeto> equipo;

    public WonderWoman() {
        this.vida = 100;
        this.ataque = 20;
        this.equipo = new ArrayList<>();
    }

    public WonderWoman(String nombre, String origen, String habilidades) {
        this(); 
        this.nombre = nombre;
        this.origen = origen;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public ArrayList<Objeto> getEquipo() {
        return equipo;
    }

    // Operaciones
    public void agregarObjeto(Objeto obj) {
        equipo.add(obj);
        this.ataque += obj.getBonusAtaque();
    }

    public boolean estaViva() {
        return vida > 0;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) vida = 0;
    }

    public String listarEquipo() {
        if (equipo.isEmpty()) return "Sin equipo";
        StringBuilder sb = new StringBuilder();
        for (Objeto o : equipo) {
            sb.append("- ").append(o.getNombre()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nombre + " - " + origen;
    }
}
