package Controlador;

import Modelo.*;
import Vista.JFrameDuelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ControladorDuelo implements ActionListener {

    private JFrameDuelo frmDuelo;
    private Duelo modelo;             
    private Estudiante jugador;        

    private ArrayList<Profesor> ListaProfesores;

    public ControladorDuelo(JFrameDuelo frmDuelo, Estudiante jugador) {
        this.frmDuelo = frmDuelo;
        this.jugador  = jugador;
        this.modelo   = new Duelo();
        this.modelo.setJugador(jugador);
        this.ListaProfesores = new ArrayList<>();
        this.frmDuelo.btnAtacar.addActionListener(this);
        this.frmDuelo.btnInteractuar.addActionListener(this);
        this.frmDuelo.btnSigRonda.addActionListener(this);

        inicializar();
    }

    private void inicializar() {
        cargarProfesores();   
        cargarHechizos();     
        actualizarStats();
        frmDuelo.txtRonda.setText(String.valueOf(modelo.getNumRonda()));
        frmDuelo.btnSigRonda.setEnabled(false);
    }

    private void cargarProfesores() {
        ListaProfesores.add(new Profesor(
                "Severus Snape", CasaHogwarts.SLYTHERIN, 90,
                "Maestro de las Artes Oscuras",
                "Pociones",
                "No es necesario llamarme 'señor', Potter."));

        ListaProfesores.add(new Profesor(
                "Albus Dumbledore", CasaHogwarts.GRYFFINDOR, 100,
                "El mago más poderoso del mundo",
                "Director de Hogwarts",
                "El amor es la magia más poderosa que existe."));

        ListaProfesores.add(new Profesor(
                "Minerva McGonagall", CasaHogwarts.GRYFFINDOR, 80,
                "Animaga experta en transformaciones",
                "Transformaciones",
                "Las reglas de Hogwarts existen por una razón."));

        ListaProfesores.add(new Profesor(
                "Gilderoy Lockhart", CasaHogwarts.RAVENCLAW, 30,
                "Famoso (aunque incompetente) escritor",
                "Defensa contra las Artes Oscuras",
                "¡Por supuesto que puedo manejar esto!"));

        DefaultComboBoxModel<Profesor> modeloProfesores = new DefaultComboBoxModel<>();
        for (Profesor p : ListaProfesores) {
            modeloProfesores.addElement(p);
        }
        frmDuelo.cmbOponentes.setModel(modeloProfesores); 
    }

    private void cargarHechizos() {
        DefaultComboBoxModel<Hechizo> modeloHechizos = new DefaultComboBoxModel<>();
        for (Hechizo h : jugador.getHechizos()) {
            modeloHechizos.addElement(h);
        }
        frmDuelo.cmbHechizo.setModel(modeloHechizos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmDuelo.btnAtacar) {
            lanzarHechizo();
        }
        if (e.getSource() == frmDuelo.btnInteractuar) {
            interactuarConProfesor();
        }
        if (e.getSource() == frmDuelo.btnSigRonda) {
            pasarRonda();
        }
    }

    private void lanzarHechizo() {
        Profesor oponente = (Profesor) frmDuelo.cmbOponentes.getSelectedItem();
        Hechizo  hechizo  = (Hechizo)  frmDuelo.cmbHechizo.getSelectedItem();

        if (oponente == null || hechizo == null) return;

        if (!oponente.estaVivo()) {
            frmDuelo.AreaResultsDuelo.append(oponente.getNombre()
                    + " ya fue derrotado. Selecciona otro oponente." + System.lineSeparator());
            return;
        }

        modelo.setOponente(oponente);

        String resultadoAtaque = modelo.atacar(hechizo);
        frmDuelo.AreaResultsDuelo.append(resultadoAtaque + System.lineSeparator());

        String resultadoContra = modelo.contraatacar();
        frmDuelo.AreaResultsDuelo.append(resultadoContra + System.lineSeparator());

        actualizarStats();

        if (modelo.haTerminado()) {
            cerrarRonda();
        }
    }

    private void interactuarConProfesor() {
        Profesor oponente = (Profesor) frmDuelo.cmbOponentes.getSelectedItem();
        if (oponente == null) return;

        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
        frmDuelo.AreaResultsDuelo.append(oponente.interactuar()); 
        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
    }

    private void cerrarRonda() {
        frmDuelo.btnAtacar.setEnabled(false);
        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
        frmDuelo.AreaResultsDuelo.append("--- Fin de la Ronda " + modelo.getNumRonda() + " ---");
        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());

        if (modelo.ganoDuelo()) {
            frmDuelo.AreaResultsDuelo.append("¡¡VICTORIA!! " + jugador.getNombre()
                    + " ha derrotado a " + modelo.getOponente().getNombre() + ".");
            frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
            frmDuelo.btnSigRonda.setEnabled(true);
        } else {
            frmDuelo.AreaResultsDuelo.append("DERROTA. " + jugador.getNombre()
                    + " ha sido vencido en el duelo.");
            frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
            frmDuelo.btnSigRonda.setEnabled(false);
            frmDuelo.btnInteractuar.setEnabled(false);
        }
    }

    private void pasarRonda() {
        modelo.siguienteRonda();
        frmDuelo.txtRonda.setText(String.valueOf(modelo.getNumRonda()));
        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
        frmDuelo.AreaResultsDuelo.append("=== Nueva Ronda: " + modelo.getNumRonda() + " ===");
        frmDuelo.AreaResultsDuelo.append(System.lineSeparator());
        frmDuelo.btnAtacar.setEnabled(true);
        frmDuelo.btnSigRonda.setEnabled(false);
    }

    private void actualizarStats() {
        frmDuelo.txtVidaJugador.setText(String.valueOf(jugador.getVida()));
        frmDuelo.txtNivelMagia.setText(String.valueOf(jugador.getNivelMagia()));

        Profesor oponente = (Profesor) frmDuelo.cmbOponentes.getSelectedItem();
        if (oponente != null) {
            frmDuelo.txtVidaOponente.setText(String.valueOf(oponente.getVida()));
        }
    }
}
