package Modelo;

public class Chavo extends Personaje {

    public Chavo() {
        super("El Chavo", 8, "Inocente y travieso", "Niño de la vecindad");
    }

    @Override
    public String hablar() {
        return "\"¡Fue sin querer queriendo!\"";
    }

    @Override
    public String accionEspecial() {
        return pedirTortaJamon();
    }

    public String pedirTortaJamon() {
        return "El Chavo dice: \"¡Una torta de jamón... una torta de jamón... una torta de jamón!\"";
    }
}
