package modelo;

public class Libro {

    private String titulo;
    private String autor;
    private String ISSN;
    private TipoLibro tipoLibro;
    private int numeroCopias;
    private int anioDePublicacion;
    private String editorial;

    public Libro() {
    }

    public Libro(String titulo, String autor, String ISSN,
                 TipoLibro tipoLibro, int numeroCopias,
                 int anioDePublicacion, String editorial) {
        this.titulo            = titulo;
        this.autor             = autor;
        this.ISSN              = ISSN;
        this.tipoLibro         = tipoLibro;
        this.numeroCopias      = numeroCopias;
        this.anioDePublicacion = anioDePublicacion;
        this.editorial         = editorial;
        validarCopias();
    }

    public String    getTitulo()           { return titulo; }
    public void      setTitulo(String t)   { this.titulo = t; }

    public String    getAutor()            { return autor; }
    public void      setAutor(String a)    { this.autor = a; }

    public String    getISSN()             { return ISSN; }
    public void      setISSN(String i)     { this.ISSN = i; }

    public TipoLibro getTipoLibro()        { return tipoLibro; }
    public void      setTipoLibro(TipoLibro t) {
        this.tipoLibro = t;
        validarCopias();
    }

    public int  getNumeroCopias()          { return numeroCopias; }
    public void setNumeroCopias(int n)     { this.numeroCopias = n; validarCopias(); }

    public int  getAnioDePublicacion()     { return anioDePublicacion; }
    public void setAnioDePublicacion(int a){ this.anioDePublicacion = a; }

    public String getEditorial()           { return editorial; }
    public void   setEditorial(String e)   { this.editorial = e; }

    // Operaciones
    public boolean calcularDisponibilidad() {
        return numeroCopias > 0;
    }

    public void prestarLibro() {
        if (numeroCopias > 0) numeroCopias--;
    }

    public void devolverLibro() {
        numeroCopias++;
    }

    // ✅ MEJORA: usa el enum renombrado COLECCION_GENERAL
    private void validarCopias() {
        if (tipoLibro == TipoLibro.REFERENCIA) {
            numeroCopias = 2; // el enunciado indica máximo 2 copias para referencia
        }
    }

    @Override
    public String toString() {
        return titulo + " | Copias: " + numeroCopias + " | " + tipoLibro;
    }
}
