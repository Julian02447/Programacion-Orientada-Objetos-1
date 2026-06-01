package modelo;

import java.util.*;
public class SistemaRecomendador {

    public ArrayList<Pelicula> recomendar(Usuario usuario,
        ArrayList<Calificacion> calificaciones,
        ArrayList<Pelicula> peliculas) {
        HashSet<String> generosFavoritos = new HashSet<>();
        HashSet<String> peliculasCalificadas = new HashSet<>();

        for (Calificacion c : calificaciones) {
            if (c.getUsuario().equals(usuario)) {
                peliculasCalificadas.add(c.getPelicula().getIdPelicula());
                if (c.getPuntuacion() >= 4) {
                    generosFavoritos.add(c.getPelicula().getGenero());
                }
            }
        }

        ArrayList<Pelicula> candidatas = new ArrayList<>();
        for (Pelicula p : peliculas) {
            if (generosFavoritos.contains(p.getGenero())
                    && !peliculasCalificadas.contains(p.getIdPelicula())) {
                candidatas.add(p);
            }
        }
        return candidatas;
    }

    // RF5: busca películas por título, género o director (insensible a mayúsculas)
    public ArrayList<Pelicula> buscar(String criterio, ArrayList<Pelicula> peliculas) {
        ArrayList<Pelicula> resultados = new ArrayList<>();
        String criterioLower = criterio.toLowerCase().trim();
        for (Pelicula p : peliculas) {
            if (p.getTitulo().toLowerCase().contains(criterioLower)
                    || p.getGenero().toLowerCase().contains(criterioLower)
                    || p.getDirector().toLowerCase().contains(criterioLower)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public boolean yaCalificada(Usuario usuario, Pelicula pelicula,
            ArrayList<Calificacion> calificaciones) {
        for (Calificacion c : calificaciones) {
            if (c.getUsuario().equals(usuario) && c.getPelicula().equals(pelicula)) {
                return true;
            }
        }
        return false;
    }
}
