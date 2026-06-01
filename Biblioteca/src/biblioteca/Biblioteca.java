package biblioteca;

import vista.JFBiblioteca;
import controlador.ControladorBiblioteca;

public class Biblioteca {

    public static void main(String[] args) {

        JFBiblioteca frmBiblioteca = new JFBiblioteca();
        frmBiblioteca.setVisible(true);
        ControladorBiblioteca cb = new ControladorBiblioteca(frmBiblioteca);
    }
}
