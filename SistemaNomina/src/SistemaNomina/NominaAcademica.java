package SistemaNomina;
import vista.*;
import controlador.*;

public class NominaAcademica {

    public static void main(String[] args) {
        vista.JFNomina frmNomina = new JFNomina();
        frmNomina.setVisible(true);
        controlador.ControladorNomina cn = new ControladorNomina(frmNomina);
    }   
}