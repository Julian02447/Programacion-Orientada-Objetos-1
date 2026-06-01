    package Controlador;
    
import Modelo.*;
import Vista.JFrameCombate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ControladorCombate implements ActionListener {

    private JFrameCombate frmCombate;
    private Combate modelo;            
    private WonderWoman heroina;        
    private ArrayList<Enemigo> ListaEnemigos;
    private ArrayList<Aliado>  ListaAliados;

    public ControladorCombate(JFrameCombate frmCombate, WonderWoman heroina) {
        this.frmCombate = frmCombate;
        this.heroina    = heroina;
        this.modelo     = new Combate();
        this.modelo.setHeroina(heroina);
        this.ListaEnemigos = new ArrayList<>();
        this.ListaAliados  = new ArrayList<>();
        this.frmCombate.btnAtacar.addActionListener(this);
        this.frmCombate.btnInteractuar.addActionListener(this);
        this.frmCombate.btnSigRonda.addActionListener(this);

        inicializar();
    }

    private void inicializar() {
        cargarEnemigos();
        cargarAliados();
        actualizarStats();
        frmCombate.txtRonda.setText(String.valueOf(modelo.getNumRonda()));
        frmCombate.btnSigRonda.setEnabled(false); 
    }

    private void cargarEnemigos() {
        ListaEnemigos.add(new Enemigo("Soldado Alemán",         TipoEnemigo.SOLDADO, 40,  10));
        ListaEnemigos.add(new Enemigo("General Ludendorff",     TipoEnemigo.SOLDADO, 65,  15));
        ListaEnemigos.add(new Enemigo("Ares - Dios de la Guerra", TipoEnemigo.ARES,  100, 25));

        DefaultComboBoxModel<Enemigo> modeloEnemigos = new DefaultComboBoxModel<>();
        for (Enemigo e : ListaEnemigos) {
            modeloEnemigos.addElement(e);
        }
       frmCombate.cmbEnemigo.setModel(modeloEnemigos);
    }

    private void cargarAliados() {
        ListaAliados.add(new Aliado("Steve Trevor",
                "Piloto y espía aliado",
                "¡Diana, juntos podemos detenerlos! ¡No te rindas!"));
        ListaAliados.add(new Aliado("Antiope",
                "Entrenadora y guerrera amazona",
                "¡Lucha con el corazón de una amazona! ¡La victoria es tuya!"));
        ListaAliados.add(new Aliado("Etta Candy",
                "Asistente de inteligencia",
                "¡Confía en ti misma, Wonder Woman! ¡Eres la más poderosa!"));

        DefaultComboBoxModel<Aliado> modeloAliados = new DefaultComboBoxModel<>();
        for (Aliado a : ListaAliados) {
            modeloAliados.addElement(a);
        }
        frmCombate.cmbAliado.setModel(modeloAliados);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmCombate.btnAtacar) {
            atacar();
        }
        if (e.getSource() == frmCombate.btnInteractuar) {
            interactuarConAliado();
        }
        if (e.getSource() == frmCombate.btnSigRonda) {
            pasarRonda();
        }
    }

    private void atacar() {
        Enemigo enemigo = (Enemigo) frmCombate.cmbEnemigo.getSelectedItem();
        if (enemigo == null) return;

        if (!enemigo.estaVivo()) {
            frmCombate.AreaResultsCombate.append("Este enemigo ya fue derrotado. Selecciona otro." + System.lineSeparator());
            return;
        }

        modelo.setEnemigo(enemigo); 

        // WW ataca
        String resultadoAtaque = modelo.atacar();
        frmCombate.AreaResultsCombate.append(resultadoAtaque + System.lineSeparator());

        // Enemigo contraataca
        String resultadoContra = modelo.contraatacar();
        frmCombate.AreaResultsCombate.append(resultadoContra + System.lineSeparator());

        actualizarStats();

        if (modelo.haTerminado()) {
            cerrarRonda();
        }
    }

    private void interactuarConAliado() {
        Aliado aliado = (Aliado) frmCombate.cmbAliado.getSelectedItem();
        if (aliado == null) return;

        frmCombate.AreaResultsCombate.append(System.lineSeparator());
        frmCombate.AreaResultsCombate.append(aliado.interactuar());
        frmCombate.AreaResultsCombate.append(System.lineSeparator());
        frmCombate.AreaResultsCombate.append(System.lineSeparator());
    }


    private void cerrarRonda() {
        frmCombate.btnAtacar.setEnabled(false);
        frmCombate.AreaResultsCombate.append(System.lineSeparator());
        frmCombate.AreaResultsCombate.append("--- Fin de la Ronda " + modelo.getNumRonda() + " ---");
        frmCombate.AreaResultsCombate.append(System.lineSeparator());

        if (modelo.ganoCombate()) {
            frmCombate.AreaResultsCombate.append("¡¡VICTORIA!! " + heroina.getNombre() + " ha derrotado a "
                    + modelo.getEnemigo().getNombre() + ".");
            frmCombate.AreaResultsCombate.append(System.lineSeparator());
            frmCombate.btnSigRonda.setEnabled(true); 
        } else {
            frmCombate.AreaResultsCombate.append("DERROTA. " + heroina.getNombre() + " ha caído en combate.");
            frmCombate.AreaResultsCombate.append(System.lineSeparator());
            frmCombate.btnSigRonda.setEnabled(false);
            frmCombate.btnInteractuar.setEnabled(false);
        }
    }

    private void pasarRonda() {
        modelo.siguienteRonda();
        frmCombate.txtRonda.setText(String.valueOf(modelo.getNumRonda()));
        frmCombate.AreaResultsCombate.append(System.lineSeparator());
        frmCombate.AreaResultsCombate.append("=== Nueva Ronda: " + modelo.getNumRonda() + " ===");
        frmCombate.AreaResultsCombate.append(System.lineSeparator());
        frmCombate.btnAtacar.setEnabled(true);
        frmCombate.btnSigRonda.setEnabled(false);
    }

    private void actualizarStats() {
        frmCombate.txtVidaWW.setText(String.valueOf(heroina.getVida()));
        frmCombate.txtAtaqueWW.setText(String.valueOf(heroina.getAtaque()));

        Enemigo enemigo = (Enemigo) frmCombate.cmbEnemigo.getSelectedItem();
        if (enemigo != null) {
            frmCombate.txtVidaEnemigo.setText(String.valueOf(enemigo.getVida()));
        }
    }
}
