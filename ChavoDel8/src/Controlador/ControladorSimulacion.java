package Controlador;

import Modelo.ObjetoInteractivo;
import Modelo.Personaje;
import Modelo.Vecindad;
import Vista.JFSimulacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class ControladorSimulacion implements ActionListener {

    private JFSimulacion frmSimulacion;
    private Vecindad modelo;

    public ControladorSimulacion(JFSimulacion frmSimulacion, Vecindad modelo) {
        this.frmSimulacion = frmSimulacion;
        this.modelo = modelo;

        this.frmSimulacion.btnHablar.addActionListener(this);
        this.frmSimulacion.btnAccionEspecial.addActionListener(this);
        this.frmSimulacion.btnMover.addActionListener(this);
        this.frmSimulacion.btnInteractuar.addActionListener(this);
        this.frmSimulacion.btnUsarObjeto.addActionListener(this);
        this.frmSimulacion.btnLimpiar.addActionListener(this);

        cargarCombos();
    }

    private void cargarCombos() {
        DefaultComboBoxModel<Personaje> modeloPersonajes = new DefaultComboBoxModel<>();
        for (Personaje p : modelo.getPersonajes()) {
            modeloPersonajes.addElement(p);
        }
        frmSimulacion.comboPersonaje.setModel(modeloPersonajes);

        DefaultComboBoxModel<ObjetoInteractivo> modeloObjetos = new DefaultComboBoxModel<>();
        for (ObjetoInteractivo o : modelo.getObjetos()) {
            modeloObjetos.addElement(o);
        }
        frmSimulacion.comboObjeto.setModel(modeloObjetos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmSimulacion.btnHablar) {
            accionHablar();
        }
        if (e.getSource() == frmSimulacion.btnAccionEspecial) {
            accionEspecial();
        }
        if (e.getSource() == frmSimulacion.btnMover) {
            accionMover();
        }
        if (e.getSource() == frmSimulacion.btnInteractuar) {
            accionInteractuar();
        }
        if (e.getSource() == frmSimulacion.btnUsarObjeto) {
            accionUsarObjeto();
        }
        if (e.getSource() == frmSimulacion.btnLimpiar) {
            frmSimulacion.areaLog.setText("Log limpiado.\n\n");
        }
    }

    private Personaje getPersonajeSeleccionado() {
        return (Personaje) frmSimulacion.comboPersonaje.getSelectedItem();
    }

    private ObjetoInteractivo getObjetoSeleccionado() {
        return (ObjetoInteractivo) frmSimulacion.comboObjeto.getSelectedItem();
    }

    private void registrar(String mensaje) {
        frmSimulacion.areaLog.append("▶  " + mensaje + "\n\n");
    }

    private void accionHablar() {
        Personaje p = getPersonajeSeleccionado();
        if (p == null) return;
        registrar("[" + p.getNombre() + "] " + p.hablar());
    }

    private void accionEspecial() {
        Personaje p = getPersonajeSeleccionado();
        if (p == null) return;
        registrar("[Acción Especial] " + p.accionEspecial());
    }

    private void accionMover() {
        Personaje p = getPersonajeSeleccionado();
        if (p == null) return;
        registrar(p.mover());
    }

    private void accionInteractuar() {
        Personaje p = getPersonajeSeleccionado();
        ObjetoInteractivo o = getObjetoSeleccionado();
        if (p == null || o == null) return;
        registrar(p.interactuar(o));
    }

    private void accionUsarObjeto() {
        ObjetoInteractivo o = getObjetoSeleccionado();
        if (o == null) return;
        registrar("[Objeto usado] " + o.usar());
    }
}
