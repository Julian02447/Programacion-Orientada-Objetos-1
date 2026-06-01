package Modelo;

public class Florinda extends Personaje {

    public Florinda() {
        super("Doña Florinda", 38, "Altiva y sobreprotectora", "Madre de Quico");
    }

    @Override
    public String hablar() {
        return "\"¡Metiche! ¡Váyase de aquí, pelado!\"";
    }

    @Override
    public String accionEspecial() {
        return darBofetada();
    }

    public String darBofetada() {
        return "¡Doña Florinda le da una bofetada a Don Ramón! \"¡Tome, para que aprenda!\"";
    }
}
