package chavodel8;
import Controlador.ControladorVecindad;
import Vista.JFVecindad;

public class ChavoDel8 {
    public static void main(String[] args) {
        JFVecindad frmVecindad = new JFVecindad();
        frmVecindad.setVisible(true);
        ControladorVecindad ctrlVecindad = new ControladorVecindad(frmVecindad);        
    } 
}
