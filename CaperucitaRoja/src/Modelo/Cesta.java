package Modelo;

import java.util.ArrayList;

public class Cesta {
    private String color;
    private ArrayList<TipoComida> contenido;

    public Cesta() {
        this.color     = "Marrón";
        this.contenido = new ArrayList<>();
    }

    public Cesta(String color) {
        this();
        this.color = color;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public ArrayList<TipoComida> getContenido() { return contenido; }

    // Operaciones
    public void agregarComida(TipoComida comida) {
        contenido.add(comida);
    }

    public String listarContenido() {
        if (contenido.isEmpty()) return "La cesta está vacía.";
        StringBuilder sb = new StringBuilder();
        for (TipoComida c : contenido) {
            sb.append("- ").append(c.name()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Cesta [" + color + "] con " + contenido.size() + " artículo(s)";
    }
}
