package modelo;

public class Candidato {
    private String nombre;
    private String apellido;
    private int    grado;
    private String curso;
    private String lema;
    private String numTarjeton;

    public Candidato() {}

    public Candidato(String nombre, String apellido, int grado, String curso,String lema, String numTarjeton) {
        this.nombre      = nombre;
        this.apellido    = apellido;
        this.grado       = grado;
        this.curso       = curso;
        this.lema        = lema;
        this.numTarjeton = numTarjeton;
    }

    public String getNombre()      { return nombre; }
    public String getApellido()    { return apellido; }
    public int    getGrado()       { return grado; }
    public String getCurso()       { return curso; }
    public String getLema()        { return lema; }
    public String getNumTarjeton() { return numTarjeton; }
    public void setNombre(String nombre)           { this.nombre      = nombre; }
    public void setApellido(String apellido)       { this.apellido    = apellido; }
    public void setGrado(int grado)                { this.grado       = grado; }
    public void setCurso(String curso)             { this.curso       = curso; }
    public void setLema(String lema)               { this.lema        = lema; }
    public void setNumTarjeton(String numTarjeton) { this.numTarjeton = numTarjeton; }
}