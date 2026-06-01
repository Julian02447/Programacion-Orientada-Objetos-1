package modelo;

public class Cuidador {
    private String id;
    private String nombre;
    private String tipoAnimal; 
    private int nivelExperiencia;
    private boolean disponibilidad;

    public Cuidador(String id, String nombre, String tipoAnimal, int nivelExperiencia, boolean disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.nivelExperiencia = nivelExperiencia;
        this.disponibilidad = disponibilidad;
    }
    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public boolean isDisponibilidad() {    
        return disponibilidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.tipoAnimal = raza;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public String perfilCuidador() {
        return "Cuidador: " + nombre + " | Tipo animal: " + tipoAnimal +
                " | Experiencia: " + nivelExperiencia + " años" +
                " | Disponible: " + disponibilidad;
    }
    @Override
    public String toString() {
        return nombre + " (" + tipoAnimal + ")";
    }
}
