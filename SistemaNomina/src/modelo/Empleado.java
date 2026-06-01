package modelo;

public class Empleado {

    protected String nombre;
    protected String apellido;
    protected String nuip;
    protected Fecha fechaIngreso;
    protected String codigo;
    protected String cargo;
    protected double salarioBase;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String nuip,
            Fecha fechaIngreso, String codigo,
            String cargo, double salarioBase) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.nuip = nuip;
        this.fechaIngreso = fechaIngreso;
        this.codigo = codigo;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNuip() {
        return nuip;
    }

    public void setNuip(String nuip) {
        this.nuip = nuip;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public int calcularAntiguedad() {

        int anioActual = 2026;

        return anioActual - fechaIngreso.getAnios();
    }

    public String mostrarInformacion() {

        return "Nombre: " + nombre
                + "\nApellido: " + apellido
                + "\nNUIP: " + nuip
                + "\nCodigo: " + codigo
                + "\nCargo: " + cargo
                + "\nSalario: " + calcularSalario();
    }
}