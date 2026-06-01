package caperucita;

import Controlador.ControladorCaperucita;
import Vista.JFCaperucita;

public class CaperucitaRoja {

    public static void main(String[] args) {

        JFCaperucita frmCaperucita = new JFCaperucita();
        frmCaperucita.setVisible(true);
        ControladorCaperucita ctrlCaperucita = new ControladorCaperucita(frmCaperucita);

    }
}
