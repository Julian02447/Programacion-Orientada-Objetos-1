package controlador;

import java.util.ArrayList;
import modelo.*;

public class DatosColegio {

    public static ArrayList<CandidatoPersonero> crearPersoneros() {
        Mascota m1 = new Mascota("M01", "Max el perro",       "Macho",  2, "Juguetón",  TipoMascota.TERRESTRES);
        Mascota m2 = new Mascota("M02", "Luna la mariposa",   "Hembra", 1, "Cariñosa",  TipoMascota.AEREOS);
        Mascota m3 = new Mascota("M03", "Rocky el tiburón",   "Macho",  3, "Activo",    TipoMascota.ACUATICOS);

        ArrayList<CandidatoPersonero> lista = new ArrayList<>();
        lista.add(new CandidatoPersonero(m1, "German",    "Cepeda", 11, "A", "Compromiso y liderazgo",       "01"));
        lista.add(new CandidatoPersonero(m2, "Valentina", "Gomez", 11, "B", "Tu voz será escuchada",        "02"));
        lista.add(new CandidatoPersonero(m3, "Andres",    "Lopez", 11, "C", "Un colegio mejor para todos",  "03"));
        return lista;
    }

    public static ArrayList<CandidatoRepresentante> crearRepresentantes() {
        Formula f1 = new Formula("(formula) Juan",   "10", "A");
        Formula f2 = new Formula("(formula) Sara",   "10", "B");
        Formula f3 = new Formula("(formula) Daniel", "10", "C");

        ArrayList<CandidatoRepresentante> lista = new ArrayList<>();
        lista.add(new CandidatoRepresentante(f1, "Sebastian", "Ramirez", 10, "A", "Más deporte y cultura",          "11"));
        lista.add(new CandidatoRepresentante(f2, "Mariana",   "Torres",  10, "B", "Mejor convivencia estudiantil",  "12"));
        lista.add(new CandidatoRepresentante(f3, "Julian",    "Manrique",  10, "C", "Innovación y tecnología",        "13"));
        return lista;
    }
}
