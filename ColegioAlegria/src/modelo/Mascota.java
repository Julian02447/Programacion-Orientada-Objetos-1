package modelo;

public class Mascota {
    private String     id;
    private String     nombre;
    private String     genero;
    private int        edad;
    private String     cualidades;
    private TipoMascota tipo;

    public Mascota() {}
    public Mascota(String id, String nombre, String genero, int edad,
                   String cualidades, TipoMascota tipo) {
        this.id         = id;
        this.nombre     = nombre;
        this.genero     = genero;
        this.edad       = edad;
        this.cualidades = cualidades;
        this.tipo       = tipo;
    }

    public String      getId()         { return id; }
    public String      getNombre()     { return nombre; }
    public String      getGenero()     { return genero; }
    public int         getEdad()       { return edad; }
    public String      getCualidades() { return cualidades; }
    public TipoMascota getTipo()       { return tipo; }
    public void setId(String id)               { this.id         = id; }
    public void setNombre(String nombre)       { this.nombre     = nombre; }
    public void setGenero(String genero)       { this.genero     = genero; }
    public void setEdad(int edad)              { this.edad       = edad; }
    public void setCualidades(String c)        { this.cualidades = c; }
    public void setTipo(TipoMascota tipo)      { this.tipo       = tipo; }
}
