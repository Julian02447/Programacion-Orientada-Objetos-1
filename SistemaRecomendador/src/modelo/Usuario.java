package modelo;

import java.util.ArrayList;
public class Usuario {

    private String idUsuario;
    private String nombre;
    private ArrayList<Pelicula> historialVisto;
    private ArrayList<String> generosPreferidos;

    public Usuario() {
        this.historialVisto = new ArrayList<>();
        this.generosPreferidos = new ArrayList<>();
    }

    public Usuario(String idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.historialVisto = new ArrayList<>();
        this.generosPreferidos = new ArrayList<>();
    }

    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Pelicula> getHistorialVisto() { return historialVisto; }
    public ArrayList<String> getGenerosPreferidos() { return generosPreferidos; }

    public void agregarAlHistorial(Pelicula p) {
        if (!historialVisto.contains(p)) {
            historialVisto.add(p);
        }
    }

    public void actualizarGenerosPreferidos(ArrayList<Calificacion> calificaciones) {
        generosPreferidos.clear();
        for (Calificacion c : calificaciones) {
            if (c.getUsuario().equals(this) && c.getPuntuacion() >= 4) {
                String genero = c.getPelicula().getGenero();
                if (!generosPreferidos.contains(genero)) {
                    generosPreferidos.add(genero);
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Usuario)) return false;
        Usuario otro = (Usuario) obj;
        return this.idUsuario.equals(otro.idUsuario);
    }

    @Override
    public int hashCode() {
        return idUsuario.hashCode();
    }

    @Override
    public String toString() {
        return nombre;
    }
}
