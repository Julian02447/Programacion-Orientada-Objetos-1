package Modelo;

public class Profesor extends Personaje {

    private String materia;
    private String frase;

    public Profesor() {
        super();
    }

    public Profesor(String nombre, CasaHogwarts casa, int nivelMagia,
                    String habilidadEspecial, String materia, String frase) {
        super(nombre, casa, nivelMagia, habilidadEspecial);
        this.materia = materia;
        this.frase = frase;
    }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getFrase() { return frase; }
    public void setFrase(String frase) { this.frase = frase; }

    public String interactuar() {
        return "[" + getNombre() + " - " + materia + "]: \"" + frase + "\"";
    }

    public String ensenar(Estudiante estudiante, Hechizo hechizo) {
        estudiante.aprenderHechizo(hechizo);
        return getNombre() + " le ha enseñado '" + hechizo.getNombre()
                + "' a " + estudiante.getNombre() + ".";
    }

    @Override
    public String toString() {
        return "Prof. " + getNombre() + " [" + materia + "]";
    }
}
