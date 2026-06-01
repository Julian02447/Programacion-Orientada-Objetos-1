package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorEstudiante implements ActionListener {

    private JFrameEstudiante frmEstudiante;
    private Estudiante jugador;                   
    private ArrayList<Hechizo> hechizosDisponibles; 

    public ControladorEstudiante(JFrameEstudiante frmEstudiante) {
        this.frmEstudiante = frmEstudiante;
        this.jugador = null; 
        this.hechizosDisponibles = new ArrayList<>();
        this.frmEstudiante.btnGuardar.addActionListener(this);
        this.frmEstudiante.btnAgregarObjeto.addActionListener(this);
        this.frmEstudiante.btnLearnHechizo.addActionListener(this);
        this.frmEstudiante.btnExplorar.addActionListener(this);
        this.frmEstudiante.btnStartDuelo.addActionListener(this);

        cargarHechizosDisponibles(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmEstudiante.btnGuardar) {
            guardarEstudiante();
        }
        if (e.getSource() == frmEstudiante.btnAgregarObjeto) {
            agregarObjeto();
        }
        if (e.getSource() == frmEstudiante.btnLearnHechizo) {
            aprenderHechizo();
        }
        if (e.getSource() == frmEstudiante.btnExplorar) {
            explorarLocacion();
        }
        if (e.getSource() == frmEstudiante.btnStartDuelo) {
            iniciarDuelo();
        }
    }


    private void guardarEstudiante() {
        String nombre    = frmEstudiante.txtNombre.getText();
        String habilidad = frmEstudiante.txtHabilidad.getText();
        String anioTxt   = frmEstudiante.txtAnio.getText();
        CasaHogwarts casa = (CasaHogwarts) frmEstudiante.cmbCasa.getSelectedItem();

        if (nombre.isEmpty() || habilidad.isEmpty() || anioTxt.isEmpty()) {
            frmEstudiante.AreaResultsEstu.setText("Todos los campos son obligatorios.");
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioTxt);
            if (anio < 1 || anio > 7) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            frmEstudiante.AreaResultsEstu.setText("El año debe ser un número del 1 al 7.");
            return;
        }

        jugador = new Estudiante(nombre, casa, 15, habilidad, anio);

        frmEstudiante.AreaResultsEstu.setText(
                "¡Estudiante registrado!" + System.lineSeparator()
                + "Nombre:           " + jugador.getNombre()           + System.lineSeparator()
                + "Casa:             " + jugador.getCasa()             + System.lineSeparator()
                + "Habilidad:        " + jugador.getHabilidadEspecial()+ System.lineSeparator()
                + "Año de estudio:   " + anio                          + System.lineSeparator()
                + "Vida inicial:     " + jugador.getVida()             + System.lineSeparator()
                + "Nivel de magia:   " + jugador.getNivelMagia());
    }

    private void agregarObjeto() {
        if (jugador == null) {
            frmEstudiante.AreaResultsEstu.setText("Primero debes guardar al estudiante.");
            return;
        }

        TipoObjeto tipo = (TipoObjeto) frmEstudiante.cmbObjeto.getSelectedItem();
        ObjetoMagico obj = crearObjeto(tipo);
        jugador.agregarObjeto(obj);

        frmEstudiante.AreaResultsEstu.setText(
                "Objeto mágico agregado: " + obj.getNombre() + System.lineSeparator()
                + "Efecto: "              + obj.getEfecto()  + System.lineSeparator()
                + "Bonus de magia: +"     + obj.getBonusMagia() + System.lineSeparator()
                + "Nivel de magia actual: " + jugador.getNivelMagia() + System.lineSeparator()
                + System.lineSeparator()
                + "--- Inventario actual ---" + System.lineSeparator()
                + jugador.listarInventario());
    }

    private void aprenderHechizo() {
        if (jugador == null) {
            frmEstudiante.AreaResultsEstu.setText("Primero debes guardar al estudiante.");
            return;
        }

        int indice = jugador.getHechizos().size() % hechizosDisponibles.size();
        Hechizo hechizo = hechizosDisponibles.get(indice);

        if (jugador.getHechizos().contains(hechizo)) {
            frmEstudiante.AreaResultsEstu.setText("¡Ya conoces todos los hechizos disponibles!");
            return;
        }

        jugador.aprenderHechizo(hechizo);

        frmEstudiante.AreaResultsEstu.setText(
                "¡Hechizo aprendido: " + hechizo.getNombre() + "!" + System.lineSeparator()
                + "Descripción: "      + hechizo.getDescripcion() + System.lineSeparator()
                + "Poder: "            + hechizo.getPoder()        + System.lineSeparator()
                + "Nivel de magia:    " + jugador.getNivelMagia()   + System.lineSeparator()
                + System.lineSeparator()
                + "--- Hechizos aprendidos ---" + System.lineSeparator()
                + jugador.listarHechizos());
    }

    private void explorarLocacion() {
        if (jugador == null) {
            frmEstudiante.AreaResultsEstu.setText("Primero debes guardar al estudiante.");
            return;
        }

        Locacion loc = (Locacion) frmEstudiante.cmbLocacion.getSelectedItem();

        if (loc == Locacion.BIBLIOTECA) {
            jugador.setNivelMagia(jugador.getNivelMagia() + 5);
        }

        frmEstudiante.AreaResultsEstu.setText(
                jugador.getNombre() + " explora: " + loc + System.lineSeparator()
                + System.lineSeparator()
                + loc.getDescripcion() + System.lineSeparator()
                + System.lineSeparator()
                + "Nivel de magia actual: " + jugador.getNivelMagia());
    }

    private void iniciarDuelo() {
        if (jugador == null) {
            frmEstudiante.AreaResultsEstu.setText("Debes guardar al estudiante antes de iniciar el duelo.");
            return;
        }
        if (jugador.getHechizos().isEmpty()) {
            frmEstudiante.AreaResultsEstu.setText("Debes aprender al menos un hechizo antes de duelos.");
            return;
        }

        JFrameDuelo vistaDuelo = new JFrameDuelo();
        ControladorDuelo ctrlDuelo = new ControladorDuelo(vistaDuelo, jugador);
        vistaDuelo.setVisible(true);
    }


    private void cargarHechizosDisponibles() {
        hechizosDisponibles.add(new Hechizo("Expelliarmus",
                "Desarma al oponente arrebatándole la varita", 25));
        hechizosDisponibles.add(new Hechizo("Stupefy",
                "Aturde al oponente dejándolo inconsciente temporalmente", 30));
        hechizosDisponibles.add(new Hechizo("Expecto Patronum",
                "Invoca un patronus que protege y causa daño a criaturas oscuras", 40));
        hechizosDisponibles.add(new Hechizo("Wingardium Leviosa",
                "Levita objetos y disocia el equilibrio del rival", 10));
        hechizosDisponibles.add(new Hechizo("Lumos Maxima",
                "Ilumina el entorno y ciega momentáneamente al oponente", 15));
    }

    private ObjetoMagico crearObjeto(TipoObjeto tipo) {
        switch (tipo) {
            case VARITA:
                return new ObjetoMagico("Varita de Saúco", tipo,
                        "La varita más poderosa del mundo mágico", 20);
            case ESCOBA:
                return new ObjetoMagico("Nimbus 2000", tipo,
                        "Escoba de alta velocidad para Quidditch y desplazamientos", 10);
            case POCION:
                return new ObjetoMagico("Poción Multijugos", tipo,
                        "Permite asumir la apariencia de otro personaje por una hora", 15);
            default:
                return new ObjetoMagico("Objeto desconocido", tipo, "Sin efecto", 0);
        }
    }
}
