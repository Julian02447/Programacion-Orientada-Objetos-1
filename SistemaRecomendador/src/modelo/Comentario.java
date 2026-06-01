package modelo;

public class Comentario {
    private Usuario usuario;
    private Pelicula pelicula;
    private String comentarioTexto;

    public Comentario() {
    }

    public Comentario(Usuario usuario, Pelicula pelicula, String comentarioTexto) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.comentarioTexto = comentarioTexto;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }
    public String getComentarioTexto() { return comentarioTexto; }
    public void setComentarioTexto(String comentarioTexto) { this.comentarioTexto = comentarioTexto; }
}
