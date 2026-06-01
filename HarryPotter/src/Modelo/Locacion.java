package Modelo;

public enum Locacion {
    GRAN_SALON, SALON_CLASE, BOSQUE_PROHIBIDO, SALA_MENESTERES, BIBLIOTECA;

    public static Locacion getGRAN_SALON()       { return GRAN_SALON; }
    public static Locacion getSALON_CLASE()      { return SALON_CLASE; }
    public static Locacion getBOSQUE_PROHIBIDO() { return BOSQUE_PROHIBIDO; }
    public static Locacion getSALA_MENESTERES()  { return SALA_MENESTERES; }
    public static Locacion getBIBLIOTECA()       { return BIBLIOTECA; }

    public String getDescripcion() {
        switch (this) {
            case GRAN_SALON:
                return "Estás en el Gran Comedor de Hogwarts. Las velas flotan en el aire y "
                     + "los techos reflejan el cielo exterior. Los estudiantes comparten "
                     + "historias de sus clases.";
            case SALON_CLASE:
                return "Entras al salón de clase. Pizarras mágicas escriben solas y "
                     + "los libros de hechizos esperan ser consultados. "
                     + "Puedes practicar aquí nuevos hechizos.";
            case BOSQUE_PROHIBIDO:
                return "¡Peligro! Has ingresado al Bosque Prohibido. "
                     + "Entre las sombras se escuchan criaturas mágicas. "
                     + "Buckbeak y los centauros merodean por aquí.";
            case SALA_MENESTERES:
                return "Descubres la Sala de los Menesteres. La habitación se transforma "
                     + "en lo que más necesitas en este momento. "
                     + "Es el escondite secreto perfecto.";
            case BIBLIOTECA:
                return "La Biblioteca de Hogwarts te recibe con miles de volúmenes. "
                     + "Encontras grimorios de hechizos avanzados e historia mágica. "
                     + "El nivel de magia aumenta al estudiar aquí.";
            default:
                return "Locación desconocida.";
        }
    }
}
