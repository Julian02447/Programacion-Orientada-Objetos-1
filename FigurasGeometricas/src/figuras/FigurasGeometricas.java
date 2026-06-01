package figuras;

import Controlador.ControladorTrianguloRectangulo;
import Vista.JFTrianguloRectangulo;

public class FigurasGeometricas {

    public static void main(String[] args) {
        JFTrianguloRectangulo frmTriangulo = new JFTrianguloRectangulo();
        frmTriangulo.setVisible(true);
        ControladorTrianguloRectangulo ctrl = new ControladorTrianguloRectangulo(frmTriangulo);
    }
}
