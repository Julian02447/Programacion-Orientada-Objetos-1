package Modelo;

public class DonRamon extends Personaje {

    public DonRamon() {
        super("Don Ramón", 45, "Flojo pero bonachón", "Vecino deudor");
    }

    @Override
    public String hablar() {
        return "\"¡Al que no le guste, que se vaya!\"";
    }

    @Override
    public String accionEspecial() {
        return evadirCobroRenta();
    }

    public String evadirCobroRenta() {
        return "Don Ramón dice: \"El Señor Barriga... ¡corra Chilindrina, que nos cobra la renta!\"";
    }
}
