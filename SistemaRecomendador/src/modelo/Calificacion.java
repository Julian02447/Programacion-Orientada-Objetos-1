package modelo;

public class Calificacion {
    private Usuario usuario;
    private Pelicula pelicula;
    private int puntuacion;

    public Calificacion() {
    }
    
    public Calificacion(Usuario usuario, Pelicula pelicula, int puntuacion) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
    }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
}