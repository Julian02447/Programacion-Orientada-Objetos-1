package modelo;

public class Mascota {
    
    private String nombre;
    private String tipoAnimal;
    private int edad;
    private String necesidades;
    private Propietario propietario; 

    public Mascota(String nombre, String tipoAnimal, int edad, String necesidades, Propietario propietario) {
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.edad = edad;
        this.necesidades = necesidades;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setRaza(String raza) {
        this.tipoAnimal = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNecesidades() {
        return necesidades;
    }

    public void setNecesidades(String necesidades) {
        this.necesidades = necesidades;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }   
}