package modelo;

// ✅ NUEVA CLASE: agrupa los datos del préstamo que el enunciado especifica:
//    fecha de préstamo, fecha de devolución y estado (PRESTADO / DEVUELTO / MULTADO)
public class Prestamo {

    private Usuario        usuario;
    private Libro          libro;
    private Fecha          fechaPrestamo;
    private Fecha          fechaDevolucion;   // null mientras no se devuelva
    private EstadoPrestamo estado;

    public Prestamo() {
        this.estado = EstadoPrestamo.PRESTADO; // estado inicial al crear el préstamo
    }

    public Prestamo(Usuario usuario, Libro libro, Fecha fechaPrestamo) {
        this(); // inicializa estado en PRESTADO
        this.usuario       = usuario;
        this.libro         = libro;
        this.fechaPrestamo = fechaPrestamo;
    }

    // ── Getters y Setters ──────────────────────────────────────────────────

    public Usuario        getUsuario()         { return usuario; }
    public void           setUsuario(Usuario u) { this.usuario = u; }

    public Libro          getLibro()           { return libro; }
    public void           setLibro(Libro l)    { this.libro = l; }

    public Fecha          getFechaPrestamo()   { return fechaPrestamo; }
    public void           setFechaPrestamo(Fecha f) { this.fechaPrestamo = f; }

    public Fecha          getFechaDevolucion() { return fechaDevolucion; }

    public EstadoPrestamo getEstado()          { return estado; }
    public void           setEstado(EstadoPrestamo e) { this.estado = e; }

    // ── Operaciones de negocio ─────────────────────────────────────────────

    // Calcula cuántos días estuvo prestado el libro (usa Fecha.calcularDias())
    public int calcularDiasPrestamo() {
        if (fechaPrestamo == null || fechaDevolucion == null) return 0;
        return fechaPrestamo.calcularDias(fechaDevolucion);
    }

    // Plazo máximo según el cargo: Administrativo = 3 días, demás = 15 días
    public int getPlazoMaximo() {
        return (usuario.getCargo() == Cargo.ADMINISTRATIVO) ? 3 : 15;
    }

    // ✅ MEJORA: el estado lo decide el propio Prestamo, no el Controlador
    public void actualizarEstado() {
        if (fechaDevolucion == null) {
            estado = EstadoPrestamo.PRESTADO;
            return;
        }
        int dias = calcularDiasPrestamo();
        estado = (dias > getPlazoMaximo()) ? EstadoPrestamo.MULTADO
                                           : EstadoPrestamo.DEVUELTO;
    }

    // Registra la devolución: guarda la fecha, devuelve la copia y actualiza el estado
    public void devolver(Fecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        this.libro.devolverLibro();
        actualizarEstado();
    }

    // ✅ MEJORA: toString() concentra todo el formateo del préstamo;
    //    el Controlador ya no necesita construir cadenas manualmente
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NUIP:               ").append(usuario.getNuip())                .append("\n");
        sb.append("Nombre:             ").append(usuario.getNombre())
                                         .append(" ").append(usuario.getApellido()).append("\n");
        sb.append("Código:             ").append(usuario.getCodigo())              .append("\n");
        sb.append("Cargo:              ").append(usuario.getCargo())               .append("\n");
        sb.append("Libro:              ").append(libro.getTitulo())                .append("\n");
        sb.append("Autor:              ").append(libro.getAutor())                 .append("\n");
        sb.append("ISSN:               ").append(libro.getISSN())                 .append("\n");
        sb.append("Editorial:          ").append(libro.getEditorial())             .append("\n");
        sb.append("Tipo:               ").append(libro.getTipoLibro())             .append("\n");
        sb.append("Copias disponibles: ").append(libro.getNumeroCopias())          .append("\n");
        sb.append("Fecha préstamo:     ").append(fechaPrestamo)                   .append("\n");

        if (fechaDevolucion != null) {
            sb.append("Fecha devolución:   ").append(fechaDevolucion)             .append("\n");
            sb.append("Días prestado:      ").append(calcularDiasPrestamo())      .append("\n");
        } else {
            sb.append("Días prestado:      Aún no devuelto\n");
        }

        sb.append("Plazo máximo:       ").append(getPlazoMaximo()).append(" días") .append("\n");
        sb.append("Estado:             ").append(estado)                          .append("\n");
        return sb.toString();
    }
}
