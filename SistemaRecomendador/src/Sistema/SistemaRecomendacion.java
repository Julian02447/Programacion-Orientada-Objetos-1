package Sistema;

import Controlador.ControladorRecomendacion;
import vista.JFSistemaRecomendador;

public class SistemaRecomendacion {

    public static void main(String[] args) {
        JFSistemaRecomendador frmReco = new JFSistemaRecomendador();
        frmReco.setVisible(true);
        ControladorRecomendacion cr = new ControladorRecomendacion(frmReco);
    }
}
