package Modelo;

public class Barril extends ObjetoInteractivo {

    public Barril() {
        super("El Barril del Chavo", "El hogar improvisado del Chavo, ubicado en el patio de la vecindad.");
    }

    @Override
    public String usar() {
        return "El Chavo se mete al barril y dice: \"¡Que no, que no, que no me gusta!\"";
    }
}
