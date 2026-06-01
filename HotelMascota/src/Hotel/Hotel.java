package Hotel;

import vista.*;
import controlador.*;
public class Hotel {
    public static void main(String[] args) {       
        vista.JFHotelMascota frmHotel = new JFHotelMascota();
        frmHotel.setVisible(true);
        controlador.ControladorHotelMascota ch = new ControladorHotelMascota(frmHotel);
    }
    
}