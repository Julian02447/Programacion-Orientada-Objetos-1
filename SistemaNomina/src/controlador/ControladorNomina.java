package controlador;

import java.awt.event.*;
import java.util.*;
import modelo.*;
import vista.JFNomina;

public class ControladorNomina implements ActionListener {

    private JFNomina frmNomina;
    private ArrayList<Empleado> listaEmpleados;
    
    public ControladorNomina(JFNomina frmNomina) {

        this.frmNomina = frmNomina;
        this.listaEmpleados = new ArrayList<>();

        this.frmNomina.btnGuardar.addActionListener(this);
        this.frmNomina.btnMostrar.addActionListener(this);
        this.frmNomina.cmbTipo.addActionListener(this);

        inicializar();
    }

    public void inicializar() {

        if ("Profesor".equals(frmNomina.cmbTipo.getSelectedItem().toString())) {

            frmNomina.txtNombreProyecto.setEnabled(true);
            frmNomina.txtTipoProyecto.setEnabled(true);
            frmNomina.txtNombreProducto.setEnabled(true);
            frmNomina.txtPuntos.setEnabled(true);
            frmNomina.txtNombreDependencia.setEnabled(false);
            frmNomina.txtCodigoDependencia.setEnabled(false);

        } else {

            frmNomina.txtNombreProyecto.setEnabled(false);
            frmNomina.txtTipoProyecto.setEnabled(false);
            frmNomina.txtNombreProducto.setEnabled(false);
            frmNomina.txtPuntos.setEnabled(false);
            frmNomina.txtNombreDependencia.setEnabled(true);
            frmNomina.txtCodigoDependencia.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmNomina.btnGuardar) {
            guardar();
        }

        if (e.getSource() == frmNomina.btnMostrar) {
            mostrar();
        }

        if (e.getSource() == frmNomina.cmbTipo) {
            inicializar();
        }
    }

    public void guardar() {

        try {

            String nombre = frmNomina.txtNombreEmpleado.getText();
            String apellido = frmNomina.txtApellido.getText();
            String nuip = frmNomina.txtNuip.getText();

            int anioIngreso = Integer.parseInt(frmNomina.txtFechaIngreso.getText());

            String codigo = frmNomina.txtCodigoEmpleado.getText();
            String cargo = frmNomina.txtCargo.getText();

            double salarioBase = Double.parseDouble(frmNomina.txtSalarioBase.getText());

            String tipo = frmNomina.cmbTipo.getSelectedItem().toString();

            if (nombre.isEmpty() || apellido.isEmpty() || nuip.isEmpty() || codigo.isEmpty() || cargo.isEmpty()) {
                frmNomina.AreaResultado.setText("Todos los campos son obligatorios");
                return;
            }

            
            for (Empleado e : listaEmpleados) {
                if (e.getNuip().equalsIgnoreCase(nuip)) {

                    frmNomina.AreaResultado.setText("El empleado ya existe");
                    return;
                }
            }
            
            Fecha fecha = new Fecha(1, 1, anioIngreso);

            
            if ("Profesor".equals(tipo)) {

                Profesor profesor = new Profesor("General", nombre, apellido, nuip, fecha, codigo, cargo, salarioBase);
                
                if (!frmNomina.txtNombreProyecto.getText().isEmpty()) {

                    String nombreProyecto = frmNomina.txtNombreProyecto.getText();
                    String tipoProyecto = frmNomina.txtTipoProyecto.getText();
                    String nombreProducto = frmNomina.txtNombreProducto.getText();

                    int puntos = 0;

                    if (!frmNomina.txtPuntos.getText().isEmpty()) {
                        puntos = Integer.parseInt(frmNomina.txtPuntos.getText());
                    }

                    Producto producto = new Producto(nombreProducto, puntos);

                    Proyecto proyecto = new Proyecto(
                            nombreProyecto,
                            tipoProyecto
                    );

                    proyecto.addProducto(producto);

                    profesor.asignarProyecto(proyecto);
                }

                listaEmpleados.add(profesor);

                frmNomina.AreaResultado.setText("Profesor guardado correctamente");
            }


            if ("Administrativo".equals(tipo)) {

                String nombreDependencia = frmNomina.txtNombreDependencia.getText();
                String codigoDependencia = frmNomina.txtCodigoDependencia.getText();

                Dependencia dependencia = new Dependencia(
                        codigoDependencia,
                        nombreDependencia
                );

                Administrativo administrativo = new Administrativo(dependencia, nombre, apellido, nuip, fecha, codigo, cargo, salarioBase);
                listaEmpleados.add(administrativo);

                frmNomina.AreaResultado.setText("Administrativo guardado correctamente");
            }

            limpiar();

        } catch (NumberFormatException e) {
            frmNomina.AreaResultado.setText("Error en datos numéricos");
        }
    }
    
    
    public void mostrar() {
        

        if (listaEmpleados.isEmpty()) {
            frmNomina.AreaResultado.setText("No hay empleados registrados");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===== LISTA DE EMPLEADOS =====\n\n");

        for (Empleado e : listaEmpleados) {

            sb.append("Nombre: ").append(e.getNombre()).append("\n");
            sb.append("Apellido: ").append(e.getApellido()).append("\n");
            sb.append("NUIP: ").append(e.getNuip()).append("\n");
            sb.append("Código: ").append(e.getCodigo()).append("\n");
            sb.append("Cargo: ").append(e.getCargo()).append("\n");
            sb.append("Salario: ").append(e.calcularSalario()).append("\n");
            sb.append("Antigüedad: ").append(e.calcularAntiguedad()).append(" años\n");

            if (e instanceof Profesor) {

                Profesor p = (Profesor) e;

                sb.append("Tipo: Profesor\n");
                sb.append("Puntos acumulados: ").append(p.acumularPuntos()).append("\n");
            }

            if (e instanceof Administrativo) {

                Administrativo a = (Administrativo) e;

                sb.append("Tipo: Administrativo\n");

                if (a.getDependencia() != null) {
                    sb.append("Dependencia: ").append(a.getDependencia().getNombre()).append("\n");
                }
            }

            sb.append("-----------------------------------\n");
        }

        frmNomina.AreaResultado.setText(sb.toString());
    }
    

    public void limpiar() {

        frmNomina.txtNombreEmpleado.setText("");
        frmNomina.txtApellido.setText("");
        frmNomina.txtNuip.setText("");
        frmNomina.txtFechaIngreso.setText("");
        frmNomina.txtCodigoEmpleado.setText("");
        frmNomina.txtCargo.setText("");
        frmNomina.txtSalarioBase.setText("");

        frmNomina.txtNombreProyecto.setText("");
        frmNomina.txtTipoProyecto.setText("");
        frmNomina.txtNombreProducto.setText("");
        frmNomina.txtPuntos.setText("");

        frmNomina.txtNombreDependencia.setText("");
        frmNomina.txtCodigoDependencia.setText("");
    }
}