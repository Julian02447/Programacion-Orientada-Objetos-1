package Modelo;

import java.util.ArrayList;


public class Estudiante extends Personaje {

    private int anioEstudio;                   
    private ArrayList<ObjetoMagico> inventario;  

    public Estudiante() {
        super(); 
        this.anioEstudio = 1;
        this.inventario = new ArrayList<>();
    }

    public Estudiante(String nombre, CasaHogwarts casa, int nivelMagia,
                      String habilidadEspecial, int anioEstudio) {
        super(nombre, casa, nivelMagia, habilidadEspecial); 
        this.anioEstudio = anioEstudio;
        this.inventario = new ArrayList<>();
    }

    public int getAnioEstudio() { return anioEstudio; }
    public void setAnioEstudio(int anioEstudio) { this.anioEstudio = anioEstudio; }

    public ArrayList<ObjetoMagico> getInventario() { return inventario; }

    public void agregarObjeto(ObjetoMagico obj) {
        inventario.add(obj);
        setNivelMagia(getNivelMagia() + obj.getBonusMagia()); 
    }

    public String listarInventario() {
        if (inventario.isEmpty()) return "Inventario vacío";
        StringBuilder sb = new StringBuilder();
        for (ObjetoMagico o : inventario) {
            sb.append("- ").append(o.getNombre())
              .append(" (").append(o.getTipo()).append(")")
              .append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getNombre() + " | Casa: " + getCasa() + " | Año " + anioEstudio;
    }
}
