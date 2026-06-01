package Modelo;

import java.util.ArrayList;

public class Vecindad {
    private ArrayList<Personaje> personajes;
    private ArrayList<ObjetoInteractivo> objetos;

    public Vecindad() {
        this.personajes = new ArrayList<>();
        this.objetos = new ArrayList<>();
        cargarDatos();
    }

    // Carga los personajes y objetos predefinidos
    private void cargarDatos() {
        personajes.add(new Chavo());
        personajes.add(new Quico());
        personajes.add(new DonRamon());
        personajes.add(new Florinda());

        objetos.add(new Barril());
        objetos.add(new Casa(1, "Don Ramón y La Chilindrina"));
        objetos.add(new Casa(2, "Doña Florinda y Quico"));
        objetos.add(new Casa(3, "Doña Clotilde"));
    }

    public void agregarPersonaje(Personaje p) {
        personajes.add(p);
    }

    public void agregarObjeto(ObjetoInteractivo obj) {
        objetos.add(obj);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public ArrayList<ObjetoInteractivo> getObjetos() {
        return objetos;
    }

    public String mostrarPersonajes() {
        StringBuilder sb = new StringBuilder();
        for (Personaje p : personajes) {
            sb.append("• ").append(p.getNombre())
              .append(" | Edad: ").append(p.getEdad())
              .append(" | Rol: ").append(p.getRol())
              .append("\n");
        }
        return sb.toString();
    }

    public String mostrarObjetos() {
        StringBuilder sb = new StringBuilder();
        for (ObjetoInteractivo o : objetos) {
            sb.append("• ").append(o.getNombre())
              .append(": ").append(o.getDescripcion())
              .append("\n");
        }
        return sb.toString();
    }
}
