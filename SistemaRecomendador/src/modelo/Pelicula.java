package modelo;

import java.util.ArrayList;
public class Pelicula {
    private String idPelicula;
    private String titulo;
    private String genero;
    private String director;
    private int año;
    private String duracion;
    private double calificacionPromedio;

    public Pelicula() {
    }

    public Pelicula(String idPelicula, String titulo, String genero,String director, int año, String duracion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.calificacionPromedio = 0.0;
    }

    public String getIdPelicula() { return idPelicula; }
    public void setIdPelicula(String idPelicula) { this.idPelicula = idPelicula; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    public double getCalificacionPromedio() { return calificacionPromedio; }

    public void actualizarPromedio(ArrayList<Calificacion> calificaciones) {
        double suma = 0;
        int count = 0;
        for (Calificacion c : calificaciones) {
            if (c.getPelicula().equals(this)) {
                suma += c.getPuntuacion();
                count++;
            }
        }
        this.calificacionPromedio = (count > 0) ? suma / count : 0.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pelicula)) return false;
        Pelicula otra = (Pelicula) obj;
        return this.idPelicula.equals(otra.idPelicula);
    }

    @Override
    public int hashCode() {
        return idPelicula.hashCode();
    }

    @Override
    public String toString() {
        return titulo + " - " + genero;
    }
}