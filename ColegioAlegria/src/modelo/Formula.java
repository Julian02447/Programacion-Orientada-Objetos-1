package modelo;

public class Formula {
    private String nombre;
    private String grado;
    private String curso;

    public Formula() {
    }

    public Formula(String nombre, String grado, String curso) {
        this.nombre = nombre;
        this.grado = grado;
        this.curso = curso;
    }
    public String getNombre() {
        return nombre;
    }
    public String getGrado() {
        return grado;
    }
    public String getCurso() {
        return curso;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }  
}