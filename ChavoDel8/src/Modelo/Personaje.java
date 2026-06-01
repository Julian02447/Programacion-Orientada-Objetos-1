package Modelo;

public abstract class Personaje {
    protected String nombre;
    protected int edad;
    protected String personalidad;
    protected String rol;

    public Personaje() {
    }

    public Personaje(String nombre, int edad, String personalidad, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getPersonalidad() { return personalidad; }
    public void setPersonalidad(String personalidad) { this.personalidad = personalidad; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public abstract String hablar();
    public abstract String accionEspecial();

    public String mover() {
        return nombre + " se mueve por la vecindad.";
    }

    public String interactuar(ObjetoInteractivo objeto) {
        return nombre + " interactúa con: " + objeto.getNombre();
    }

    @Override
    public String toString() {
        return nombre + " (" + rol + ")";
    }
}
