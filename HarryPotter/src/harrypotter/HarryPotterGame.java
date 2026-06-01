package harrypotter;

import Controlador.ControladorEstudiante;
import Vista.JFrameEstudiante;

public class HarryPotterGame {

    public static void main(String[] args) {

        JFrameEstudiante frmEstudiante = new JFrameEstudiante();
        frmEstudiante.setVisible(true);
        ControladorEstudiante ctrlEstudiante = new ControladorEstudiante(frmEstudiante);

    }
}
