package modelo;
import java.util.ArrayList;

public class Propietario{
    private String cedula;
    private String nombre;
    private ArrayList<Mascota> mascotas;

    public Propietario(String cedula, String nombre, ArrayList<Mascota> mascotas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.mascotas = mascotas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
        
    public void registrarMascota(Mascota mascota){
        
        mascotas.add(mascota);
        
    }    
}