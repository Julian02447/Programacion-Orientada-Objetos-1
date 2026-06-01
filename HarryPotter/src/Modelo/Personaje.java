package Modelo;

import java.util.ArrayList;

public class Personaje {

    private String nombre;
    private CasaHogwarts casa;
    private int nivelMagia;
    private String habilidadEspecial;
    private int vida;
    private ArrayList<Hechizo> hechizos;

    public Personaje() {
        this.vida = 100;
        this.nivelMagia = 10;
        this.hechizos = new ArrayList<>();
    }

    public Personaje(String nombre, CasaHogwarts casa, int nivelMagia, String habilidadEspecial) {
        this(); 
        this.nombre = nombre;
        this.casa = casa;
        this.nivelMagia = nivelMagia;
        this.habilidadEspecial = habilidadEspecial;
    }

    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public CasaHogwarts getCasa() { return casa; }
    public void setCasa(CasaHogwarts casa) { this.casa = casa; }

    public int getNivelMagia() { return nivelMagia; }
    public void setNivelMagia(int nivelMagia) { this.nivelMagia = nivelMagia; }

    public String getHabilidadEspecial() { return habilidadEspecial; }
    public void setHabilidadEspecial(String habilidadEspecial) { this.habilidadEspecial = habilidadEspecial; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public ArrayList<Hechizo> getHechizos() { return hechizos; }

    public void aprenderHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
        this.nivelMagia += hechizo.getPoder() / 5; 
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) vida = 0;
    }

    public String listarHechizos() {
        if (hechizos.isEmpty()) return "Sin hechizos aprendidos";
        StringBuilder sb = new StringBuilder();
        for (Hechizo h : hechizos) {
            sb.append("- ").append(h.getNombre())
              .append(" (poder: ").append(h.getPoder()).append(")")
              .append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return nombre + " [" + casa + "]";
    }
}
