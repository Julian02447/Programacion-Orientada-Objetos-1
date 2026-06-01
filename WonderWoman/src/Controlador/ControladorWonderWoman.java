package Controlador;

import Modelo.*;
import Vista.JFrameWonderWoman;
import Vista.JFrameCombate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorWonderWoman implements ActionListener {

    private JFrameWonderWoman frmWonderWoman;
    private WonderWoman heroina; 

    public ControladorWonderWoman(JFrameWonderWoman frmWonderWoman) {
        this.frmWonderWoman = frmWonderWoman;
        this.heroina = null; 
        this.frmWonderWoman.btnGuardar.addActionListener(this);
        this.frmWonderWoman.btnAgregarObjeto.addActionListener(this);
        this.frmWonderWoman.btnIniciarCombate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmWonderWoman.btnGuardar) {
            guardarWonderWoman();
        }
        if (e.getSource() == frmWonderWoman.btnAgregarObjeto) {
            agregarEquipo();
        }
        if (e.getSource() == frmWonderWoman.btnIniciarCombate) {
            iniciarCombate();
        }
    }


    private void guardarWonderWoman() {
        String nombre      = frmWonderWoman.txtNombre.getText();
        String origen      = frmWonderWoman.txtOrigen.getText();
        String habilidades = frmWonderWoman.txtHabilidades.getText();

        if (nombre.isEmpty() || origen.isEmpty() || habilidades.isEmpty()) {
            frmWonderWoman.AreaResultsWW.setText("Todos los campos son obligatorios.");
            return;
        }

        heroina = new WonderWoman(nombre, origen, habilidades);

        frmWonderWoman.AreaResultsWW.setText(
                "¡Heroína registrada!" + System.lineSeparator()
                + "Nombre: "     + heroina.getNombre()      + System.lineSeparator()
                + "Origen: "     + heroina.getOrigen()      + System.lineSeparator()
                + "Habilidades: "+ heroina.getHabilidades() + System.lineSeparator()
                + "Vida inicial: "+ heroina.getVida()        + System.lineSeparator()
                + "Ataque base:  "+ heroina.getAtaque());
    }

    private void agregarEquipo() {
        if (heroina == null) {
            frmWonderWoman.AreaResultsWW.setText("Primero debes guardar a Wonder Woman.");
            return;
        }

        TipoObjeto tipo = (TipoObjeto) frmWonderWoman.cmbObjeto.getSelectedItem();
        Objeto obj = crearObjeto(tipo); 
        heroina.agregarObjeto(obj);

        frmWonderWoman.AreaResultsWW.setText(
                "Equipo agregado: " + obj.getNombre() + System.lineSeparator()
                + "Efecto: "        + obj.getEfecto()   + System.lineSeparator()
                + "Bonus de ataque: +" + obj.getBonusAtaque() + System.lineSeparator()
                + "Ataque total: "  + heroina.getAtaque() + System.lineSeparator()
                + System.lineSeparator()
                + "--- Equipo actual ---" + System.lineSeparator()
                + heroina.listarEquipo());
    }

    private void iniciarCombate() {
        if (heroina == null) {
            frmWonderWoman.AreaResultsWW.setText("Debes guardar a Wonder Woman antes de iniciar el combate.");
            return;
        }

        JFrameCombate vistaCombate = new JFrameCombate();
        ControladorCombate ctrlCombate = new ControladorCombate(vistaCombate, heroina);
        vistaCombate.setVisible(true);
    }

    private Objeto crearObjeto(TipoObjeto tipo) {
        switch (tipo) {
            case LAZO_VERDAD:
                return new Objeto("Lazo de la Verdad", tipo,
                        "Obliga al enemigo a decir la verdad e inmoviliza", 15);
            case ESCUDO_ATENEA:
                return new Objeto("Escudo de Atenea", tipo,
                        "Bloquea ataques y reduce el daño recibido", 10);
            case BRAZALETES:
                return new Objeto("Brazaletes de Sumisión", tipo,
                        "Deflectan proyectiles y ataques físicos", 8);
            default:
                return new Objeto("Objeto desconocido", tipo, "Sin efecto", 0);
        }
    }
}
