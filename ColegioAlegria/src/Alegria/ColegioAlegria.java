package Alegria;

import controlador.*;
import vista.JFVotacionesRepresentantes;
public class ColegioAlegria {
    public static void main(String[] args) {
       vista.JFVotacionesRepresentantes frmVotaciones = new JFVotacionesRepresentantes();
        frmVotaciones.setVisible(true); 
        ControladorPersonero cp = new ControladorPersonero(frmVotaciones);
    }
    
}