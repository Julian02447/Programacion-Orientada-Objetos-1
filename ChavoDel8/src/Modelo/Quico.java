package Modelo;

public class Quico extends Personaje {

    public Quico() {
        super("Quico", 9, "Presumido y llorón", "Hijo de Doña Florinda");
    }

    @Override
    public String hablar() {
        return "\"¡Cállate, cállate, cállate, que me desesperas!\"";
    }

    @Override
    public String accionEspecial() {
        return llorar();
    }

    public String llorar() {
        return "Quico llora: \"¡Mamaaaá! ¡El Chavo me pegó!\"";
    }
}
