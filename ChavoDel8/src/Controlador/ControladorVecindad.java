package Controlador;

import Modelo.ObjetoInteractivo;
import Modelo.Personaje;
import Modelo.Vecindad;
import Vista.JFVecindad;
import Vista.JFSimulacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControladorVecindad implements ActionListener {

    private JFVecindad frmVecindad;
    private Vecindad modelo;

    public ControladorVecindad(JFVecindad frmVecindad) {
        this.frmVecindad = frmVecindad;
        this.modelo = new Vecindad();
        this.frmVecindad.btnSimular.addActionListener(this);
        this.frmVecindad.listPersonajes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    mostrarDetallePersonaje();
                }
            }
        });

        this.frmVecindad.listObjetos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    mostrarDetalleObjeto();
                }
            }
        });

        cargarListas();
    }

    private void cargarListas() {
    
        DefaultListModel<Personaje> modeloPersonajes = new DefaultListModel<>();
        for (Personaje p : modelo.getPersonajes()) {
            modeloPersonajes.addElement(p);
        }
        frmVecindad.listPersonajes.setModel(modeloPersonajes);

        DefaultListModel<ObjetoInteractivo> modeloObjetos = new DefaultListModel<>();
        for (ObjetoInteractivo o : modelo.getObjetos()) {
            modeloObjetos.addElement(o);
        }
        frmVecindad.listObjetos.setModel(modeloObjetos);
    }

    private void mostrarDetallePersonaje() {
        Personaje p = frmVecindad.listPersonajes.getSelectedValue();
        if (p == null) return;
        frmVecindad.lblNombre.setText("Nombre: " + p.getNombre());
        frmVecindad.lblEdad.setText("Edad: " + p.getEdad() + " años");
        frmVecindad.lblPersonalidad.setText("Personalidad: " + p.getPersonalidad());
        frmVecindad.lblRol.setText("Rol: " + p.getRol());
    }

    private void mostrarDetalleObjeto() {
        ObjetoInteractivo o = frmVecindad.listObjetos.getSelectedValue();
        if (o == null) return;
        frmVecindad.lblObjNombre.setText("Objeto: " + o.getNombre());
        frmVecindad.lblObjDescripcion.setText("<html>Descripción: " + o.getDescripcion() + "</html>");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVecindad.btnSimular) {
            abrirSimulacion();
        }
    }

    private void abrirSimulacion() {
        JFSimulacion frmSimulacion = new JFSimulacion();
        ControladorSimulacion ctrlSim = new ControladorSimulacion(frmSimulacion, modelo);
        frmSimulacion.setVisible(true);
    }
}
