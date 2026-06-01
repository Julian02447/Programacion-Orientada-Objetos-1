package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import modelo.*;
import vista.JFBiblioteca;

public class ControladorBiblioteca implements ActionListener {

    private JFBiblioteca    frmBiblioteca;
    private SistemaPrestamo sistema;

    public ControladorBiblioteca(JFBiblioteca frmBiblioteca) {
        this.frmBiblioteca = frmBiblioteca;
        this.sistema       = new SistemaPrestamo();

        // registrar listeners
        this.frmBiblioteca.btnPrestar.addActionListener(this);
        this.frmBiblioteca.btnDevolver.addActionListener(this);
        this.frmBiblioteca.btnMostrar.addActionListener(this);

        cargarCombos();
    }

    // ✅ MEJORA: private — es un método interno, no debe ser público
    private void cargarCombos() {

        // ✅ MEJORA: DefaultComboBoxModel con enum.values() es más limpio que addItem() manual
        frmBiblioteca.cmbCargo.setModel(
                new DefaultComboBoxModel<>(Cargo.values()));

        Libro libro1 = new Libro("Clean Code",   "Robert Martin", "111",
                TipoLibro.COLECCION_GENERAL, 10, 2008, "Pearson");

        Libro libro2 = new Libro("Java POO",     "Deitel",        "222",
                TipoLibro.COLECCION_GENERAL, 5,  2015, "McGraw Hill");

        Libro libro3 = new Libro("Diccionario",  "RAE",           "333",
                TipoLibro.REFERENCIA,        2,  2020, "RAE");

        frmBiblioteca.cmbLibro.addItem(libro1);
        frmBiblioteca.cmbLibro.addItem(libro2);
        frmBiblioteca.cmbLibro.addItem(libro3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmBiblioteca.btnPrestar)  prestar();
        if (e.getSource() == frmBiblioteca.btnDevolver) devolver();
        if (e.getSource() == frmBiblioteca.btnMostrar)  mostrar();
    }

    // ── Prestar ────────────────────────────────────────────────────────────
    // ✅ MEJORA: private; valida formato de fecha; crea Prestamo (no mezcla datos en Usuario)
    private void prestar() {
        try {
            String nuip       = frmBiblioteca.txtNuip.getText().trim();
            String nombre     = frmBiblioteca.txtNombre.getText().trim();
            String apellido   = frmBiblioteca.txtApellido.getText().trim();
            String codigo     = frmBiblioteca.txtCodigo.getText().trim();
            String fechaTxt   = frmBiblioteca.txtFechaInicio.getText().trim();

            // Validar campos vacíos
            if (nuip.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                    || codigo.isEmpty() || fechaTxt.isEmpty()) {
                frmBiblioteca.AreaResultado.setText("Todos los campos son obligatorios.");
                return;
            }

            Cargo cargo = (Cargo) frmBiblioteca.cmbCargo.getSelectedItem();
            Libro libro = (Libro) frmBiblioteca.cmbLibro.getSelectedItem();

            // Verificar disponibilidad de copias
            if (!libro.calcularDisponibilidad()) {
                frmBiblioteca.AreaResultado.setText(
                        "No hay copias disponibles de \"" + libro.getTitulo() + "\".");
                return;
            }

            // ✅ MEJORA: validar formato antes de parsear (evita ArrayIndexOutOfBoundsException)
            Fecha fechaPrestamo = parsearFecha(fechaTxt);
            if (fechaPrestamo == null) return; // parsearFecha ya muestra el error

            // Crear el préstamo con el modelo correcto
            Usuario  usuario  = new Usuario(nuip, nombre, apellido, codigo, cargo);
            Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo);

            sistema.agregarPrestamo(prestamo);
            libro.prestarLibro();
            frmBiblioteca.cmbLibro.repaint();

            frmBiblioteca.AreaResultado.setText(
                    "Préstamo registrado correctamente.\n"
                    + "Plazo máximo: " + prestamo.getPlazoMaximo() + " días.\n"
                    + "Copias restantes: " + libro.getNumeroCopias());

            limpiar();

        } catch (NumberFormatException ex) {
            frmBiblioteca.AreaResultado.setText(
                    "Error: los campos de fecha deben ser numéricos. Use dd/mm/aaaa");
        } catch (Exception ex) {
            frmBiblioteca.AreaResultado.setText("Error inesperado: " + ex.getMessage());
        }
    }

    // ── Devolver ───────────────────────────────────────────────────────────
    // ✅ MEJORA: busca el préstamo por NUIP en lugar de tomar siempre el último
    private void devolver() {
        try {
            String nuip     = frmBiblioteca.txtNuip.getText().trim();
            String fechaTxt = frmBiblioteca.txtFechaActual.getText().trim();

            if (nuip.isEmpty()) {
                frmBiblioteca.AreaResultado.setText(
                        "Ingrese el NUIP del usuario para registrar la devolución.");
                return;
            }

            if (fechaTxt.isEmpty()) {
                frmBiblioteca.AreaResultado.setText(
                        "Ingrese la fecha actual de devolución (dd/mm/aaaa).");
                return;
            }

            // ✅ MEJORA: busca el préstamo activo del NUIP indicado
            Prestamo prestamo = sistema.buscarPrestamoActivo(nuip);
            if (prestamo == null) {
                frmBiblioteca.AreaResultado.setText(
                        "No se encontró un préstamo ACTIVO para el NUIP: " + nuip);
                return;
            }

            Fecha fechaDevolucion = parsearFecha(fechaTxt);
            if (fechaDevolucion == null) return;

            // El modelo gestiona la devolución: devuelve la copia y actualiza el estado
            prestamo.devolver(fechaDevolucion);
            frmBiblioteca.cmbLibro.repaint();

            frmBiblioteca.AreaResultado.setText(
                    "Devolución registrada correctamente.\n"
                    + "Días prestado: " + prestamo.calcularDiasPrestamo() + "\n"
                    + "Estado final:  " + prestamo.getEstado());

        } catch (NumberFormatException ex) {
            frmBiblioteca.AreaResultado.setText(
                    "Error: los campos de fecha deben ser numéricos. Use dd/mm/aaaa");
        } catch (Exception ex) {
            frmBiblioteca.AreaResultado.setText("Error en devolución: " + ex.getMessage());
        }
    }

    // ── Mostrar ────────────────────────────────────────────────────────────
    // ✅ MEJORA: usa Prestamo.toString() — el controlador ya no arma cadenas a mano
    private void mostrar() {
        if (sistema.getPrestamos().isEmpty()) {
            frmBiblioteca.AreaResultado.setText("No hay préstamos registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("===== LISTA DE PRÉSTAMOS =====\n\n");

        for (Prestamo p : sistema.getPrestamos()) {
            sb.append(p.toString());           // toda la info ya está en el modelo
            sb.append("----------------------------------\n");
        }

        // Resumen de estados al final
        sb.append("\nRESUMEN:\n");
        sb.append("  Préstamos activos:  ").append(sistema.contarPorEstado(EstadoPrestamo.PRESTADO)).append("\n");
        sb.append("  Devueltos a tiempo: ").append(sistema.contarPorEstado(EstadoPrestamo.DEVUELTO)).append("\n");
        sb.append("  Multados:           ").append(sistema.contarPorEstado(EstadoPrestamo.MULTADO)).append("\n");

        frmBiblioteca.AreaResultado.setText(sb.toString());
    }

    // ── Utilidades ─────────────────────────────────────────────────────────

    // ✅ MEJORA: parseo de fecha centralizado con validación de formato y rango
    private Fecha parsearFecha(String texto) {
        String[] partes = texto.split("/");
        if (partes.length != 3) {
            frmBiblioteca.AreaResultado.setText(
                    "Formato de fecha inválido. Use dd/mm/aaaa  (ej: 15/06/2025)");
            return null;
        }
        int dia  = Integer.parseInt(partes[0]);
        int mes  = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        Fecha fecha = new Fecha(dia, mes, anio);
        if (!fecha.esValida()) {
            frmBiblioteca.AreaResultado.setText(
                    "Fecha inválida: " + fecha + "  Revise día (1-31), mes (1-12) y año (≥2000).");
            return null;
        }
        return fecha;
    }

    private void limpiar() {
        frmBiblioteca.txtNuip.setText("");
        frmBiblioteca.txtNombre.setText("");
        frmBiblioteca.txtApellido.setText("");
        frmBiblioteca.txtCodigo.setText("");
        frmBiblioteca.txtFechaInicio.setText("");
    }
}
