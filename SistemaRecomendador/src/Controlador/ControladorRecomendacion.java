package Controlador;

import vista.JFSistemaRecomendador;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControladorRecomendacion implements ActionListener {

    private JFSistemaRecomendador frmRecomendador;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Calificacion> calificaciones;
    private ArrayList<Comentario> comentarios;
    private SistemaRecomendador sistema;

    public ControladorRecomendacion(JFSistemaRecomendador frmRecomendador) {
        this.frmRecomendador = frmRecomendador;
        this.usuarios = new ArrayList<>();
        this.peliculas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.sistema = new SistemaRecomendador();

        this.frmRecomendador.btnCalificar.addActionListener(this);
        this.frmRecomendador.btnMostrarCalificacion.addActionListener(this);
        this.frmRecomendador.btnComentar.addActionListener(this);
        this.frmRecomendador.btnVerComentario.addActionListener(this);
        this.frmRecomendador.btnGetRecomendacion.addActionListener(this);
        this.frmRecomendador.btnBuscar.addActionListener(this);

        inicializar();
    }

    private void inicializar() {
        cargarUsuarios();
        cargarPeliculas();
    }

    private void cargarUsuarios() {
        usuarios.add(new Usuario("U1", "German"));
        usuarios.add(new Usuario("U2", "Maria"));
        usuarios.add(new Usuario("U3", "Pedro"));

        DefaultComboBoxModel<Usuario> modeloUsuarios = new DefaultComboBoxModel<>();
        for (Usuario u : usuarios) {
            modeloUsuarios.addElement(u);
        }
        frmRecomendador.cmbUser.setModel(modeloUsuarios);
    }

    private void cargarPeliculas() {
        peliculas.add(new Pelicula("P1",  "Inception",                "Sci-Fi",    "Christopher Nolan",          2010, "148 min"));
        peliculas.add(new Pelicula("P2",  "Interstellar",             "Sci-Fi",    "Christopher Nolan",          2014, "169 min"));
        peliculas.add(new Pelicula("P3",  "Parasite",                 "Drama",     "Bong Joon-ho",               2019, "132 min"));
        peliculas.add(new Pelicula("P4",  "The Dark Knight",          "Action",    "Christopher Nolan",          2008, "152 min"));
        peliculas.add(new Pelicula("P5",  "Titanic",                  "Romance",   "James Cameron",              1997, "195 min"));
        peliculas.add(new Pelicula("P6",  "The Matrix",               "Sci-Fi",    "Lana & Lilly Wachowski",     1999, "136 min"));
        peliculas.add(new Pelicula("P7",  "Forrest Gump",             "Drama",     "Robert Zemeckis",            1994, "142 min"));
        peliculas.add(new Pelicula("P8",  "Avengers: Endgame",        "Action",    "Anthony & Joe Russo",        2019, "181 min"));
        peliculas.add(new Pelicula("P9",  "La La Land",               "Musical",   "Damien Chazelle",            2016, "128 min"));
        peliculas.add(new Pelicula("P10", "Coco",                     "Animation", "Lee Unkrich",                2017, "105 min"));
        peliculas.add(new Pelicula("P11", "Gladiator",                "Action",    "Ridley Scott",               2000, "155 min"));
        peliculas.add(new Pelicula("P12", "The Godfather",            "Crime",     "Francis Ford Coppola",       1972, "175 min"));
        peliculas.add(new Pelicula("P13", "Spirited Away",            "Animation", "Hayao Miyazaki",             2001, "125 min"));
        peliculas.add(new Pelicula("P14", "The Shawshank Redemption", "Drama",     "Frank Darabont",             1994, "142 min"));
        peliculas.add(new Pelicula("P15", "Pulp Fiction",             "Crime",     "Quentin Tarantino",          1994, "154 min"));

        DefaultComboBoxModel<Pelicula> modeloPeliculas = new DefaultComboBoxModel<>();
        for (Pelicula p : peliculas) {
            modeloPeliculas.addElement(p);
        }
        frmRecomendador.cmbPelicula.setModel(modeloPeliculas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRecomendador.btnCalificar) {
            calificar();
        }
        if (e.getSource() == frmRecomendador.btnMostrarCalificacion) {
            mostrarCalificaciones();
        }
        if (e.getSource() == frmRecomendador.btnComentar) {
            comentar();
        }
        if (e.getSource() == frmRecomendador.btnVerComentario) {
            mostrarComentarios();
        }
        if (e.getSource() == frmRecomendador.btnGetRecomendacion) {
            obtenerRecomendacion();
        }
        if (e.getSource() == frmRecomendador.btnBuscar) {
            buscarPelicula();
        }
    }

    // RF4: califica una película — valida duplicados antes
    private void calificar() {
        Usuario usuario = (Usuario) frmRecomendador.cmbUser.getSelectedItem();
        Pelicula pelicula = (Pelicula) frmRecomendador.cmbPelicula.getSelectedItem();
        int puntuacion = Integer.parseInt((String) frmRecomendador.cmbCalificacion.getSelectedItem());

        if (sistema.yaCalificada(usuario, pelicula, calificaciones)) {
            JOptionPane.showMessageDialog(frmRecomendador,
                usuario.getNombre() + " ya calificó \"" + pelicula.getTitulo() + "\".",
                "Calificación duplicada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Calificacion c = new Calificacion(usuario, pelicula, puntuacion);
        calificaciones.add(c);
        pelicula.actualizarPromedio(calificaciones);
        usuario.agregarAlHistorial(pelicula);

        frmRecomendador.AreaCalificacion.append(
            usuario.getNombre() + " calificó \"" + pelicula.getTitulo() +
            "\" con " + puntuacion + "/5\n");
    }

    private void mostrarCalificaciones() {
        StringBuilder sb = new StringBuilder("=== Calificaciones ===\n");
        for (Calificacion c : calificaciones) {
            sb.append(c.getUsuario().getNombre())
              .append(" → \"").append(c.getPelicula().getTitulo())
              .append("\": ").append(c.getPuntuacion()).append("/5\n");
        }
        if (calificaciones.isEmpty()) sb.append("No hay calificaciones aún.\n");
        frmRecomendador.AreaCalificacion.setText(sb.toString());
    }

    // RF4: agrega comentario — valida que el campo no esté vacío
    private void comentar() {
        Usuario usuario = (Usuario) frmRecomendador.cmbUser.getSelectedItem();
        Pelicula pelicula = (Pelicula) frmRecomendador.cmbPelicula.getSelectedItem();
        String texto = frmRecomendador.txtComentario.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(frmRecomendador,
                "Escribe un comentario antes de enviar.",
                "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        comentarios.add(new Comentario(usuario, pelicula, texto));
        frmRecomendador.AreaComentario.append(
            usuario.getNombre() + " sobre \"" + pelicula.getTitulo() + "\": " + texto + "\n");
        frmRecomendador.txtComentario.setText("");
    }

    private void mostrarComentarios() {
        StringBuilder sb = new StringBuilder("=== Comentarios ===\n");
        for (Comentario c : comentarios) {
            sb.append(c.getUsuario().getNombre())
              .append(" sobre \"").append(c.getPelicula().getTitulo())
              .append("\": ").append(c.getComentarioTexto()).append("\n");
        }
        if (comentarios.isEmpty()) sb.append("No hay comentarios aún.\n");
        frmRecomendador.AreaComentario.setText(sb.toString());
    }

    // RF3: delega la lógica de recomendación al Modelo
    private void obtenerRecomendacion() {
        Usuario usuario = (Usuario) frmRecomendador.cmbUser.getSelectedItem();
        if (usuario == null) {
            frmRecomendador.AreaRecomendacion.setText("Selecciona un usuario primero.");
            return;
        }

        usuario.actualizarGenerosPreferidos(calificaciones);
        ArrayList<Pelicula> candidatas = sistema.recomendar(usuario, calificaciones, peliculas);

        if (usuario.getGenerosPreferidos().isEmpty()) {
            frmRecomendador.AreaRecomendacion.setText(
                "[ " + usuario.getNombre() + " ]\n" +
                "Aún no tiene películas con calificación >= 4.\n" +
                "Califica algunas películas primero.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(usuario.getNombre()).append(" ]\n");
        sb.append("Géneros favoritos: ").append(usuario.getGenerosPreferidos()).append("\n\n");

        if (candidatas.isEmpty()) {
            sb.append("¡Ya viste todas las películas disponibles en tus géneros favoritos!");
        } else {
            // Elige una aleatoria entre las candidatas
            Pelicula recomendada = candidatas.get((int)(Math.random() * candidatas.size()));
            sb.append("Recomendación: \"").append(recomendada.getTitulo()).append("\"\n");
            sb.append("Género: ").append(recomendada.getGenero()).append("\n");
            sb.append("Director: ").append(recomendada.getDirector()).append("\n");
            sb.append("Año: ").append(recomendada.getAño()).append("\n");
            sb.append("Duración: ").append(recomendada.getDuracion()).append("\n");
            sb.append("\n(").append(candidatas.size()).append(" opciones disponibles en tus géneros)");
        }
        frmRecomendador.AreaRecomendacion.setText(sb.toString());
    }

    // RF5: busca películas por título, género o director
    private void buscarPelicula() {
        String criterio = frmRecomendador.txtBuscar.getText().trim();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(frmRecomendador,
                "Escribe un título, género o director para buscar.",
                "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ArrayList<Pelicula> resultados = sistema.buscar(criterio, peliculas);
        StringBuilder sb = new StringBuilder("=== Resultados para \"" + criterio + "\" ===\n");
        if (resultados.isEmpty()) {
            sb.append("No se encontraron películas.");
        } else {
            for (Pelicula p : resultados) {
                sb.append("• ").append(p.getTitulo())
                  .append(" (").append(p.getGenero()).append(", ")
                  .append(p.getAño()).append(") - Dir: ")
                  .append(p.getDirector()).append("\n");
            }
        }
        frmRecomendador.AreaRecomendacion.setText(sb.toString());
    }
}
