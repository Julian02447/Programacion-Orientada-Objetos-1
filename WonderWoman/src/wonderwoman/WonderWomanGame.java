package wonderwoman;

import Controlador.ControladorWonderWoman;
import Vista.JFrameWonderWoman;

public class WonderWomanGame {

    public static void main(String[] args) {

        JFrameWonderWoman frmWonderWoman = new JFrameWonderWoman();
        frmWonderWoman.setVisible(true);
        ControladorWonderWoman ctrlWonderWoman = new ControladorWonderWoman(frmWonderWoman);

    }
}
