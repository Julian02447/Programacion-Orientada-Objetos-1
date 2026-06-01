package modelo;

// ✅ MEJORA: Usuario solo tiene sus propios datos de identidad.
//    Los datos del préstamo (libro, fechas, estado) se trasladaron a Prestamo.
public class Usuario {

    private String nuip;
    private String nombre;
    private String apellido;
    private String codigo;
    private Cargo  cargo;

    public Usuario() {
    }

    public Usuario(String nuip, String nombre, String apellido,
                   String codigo, Cargo cargo) {
        this.nuip     = nuip;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.codigo   = codigo;
        this.cargo    = cargo;
    }

    public String getNuip()     { return nuip; }
    public void   setNuip(String nuip)     { this.nuip = nuip; }

    public String getNombre()   { return nombre; }
    public void   setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void   setApellido(String apellido) { this.apellido = apellido; }

    public String getCodigo()   { return codigo; }
    public void   setCodigo(String codigo) { this.codigo = codigo; }

    public Cargo  getCargo()    { return cargo; }
    public void   setCargo(Cargo cargo) { this.cargo = cargo; }

    // ✅ MEJORA: toString() para que el usuario se muestre bien en el área de resultados
    @Override
    public String toString() {
        return nombre + " " + apellido + " [" + cargo + "] - NUIP: " + nuip;
    }
}
