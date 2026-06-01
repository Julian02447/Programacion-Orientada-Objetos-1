package modelo;

public class Administrativo extends Empleado {

    private Dependencia dependencia;

    public Administrativo() {
    }

    public Administrativo(Dependencia dependencia,
            String nombre,
            String apellido,
            String nuip,
            Fecha fechaIngreso,
            String codigo,
            String cargo,
            double salarioBase) {

        super(nombre, apellido, nuip,
                fechaIngreso, codigo,
                cargo, salarioBase);

        this.dependencia = dependencia;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public double calcularSalario() {

        double bonificacion = salarioBase * 0.10;

        return salarioBase + bonificacion;
    }
}
