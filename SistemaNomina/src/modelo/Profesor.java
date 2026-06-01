package modelo;

public class Profesor extends Empleado {

    private String especialidad;
    private Asignatura asignatura;
    private Proyecto proyecto;

    public Profesor() {
    }

    public Profesor(String especialidad, String nombre, String apellido,
            String nuip, Fecha fechaIngreso,
            String codigo, String cargo,
            double salarioBase) {

        super(nombre, apellido, nuip, fechaIngreso,
                codigo, cargo, salarioBase);

        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void asignarProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int acumularPuntos() {

        if (proyecto != null && proyecto.getProducto() != null) {
            return proyecto.getProducto().getPuntos();
        }

        return 0;
    }

    @Override
    public double calcularSalario() {

        double bono = acumularPuntos() * 10000;

        return salarioBase + bono;
    }

    @Override
    public String toString() {
        return nombre;
    }
}