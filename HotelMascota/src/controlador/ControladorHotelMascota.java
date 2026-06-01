package controlador;

import modelo.*;
import vista.JFHotelMascota;
import java.awt.event.*;
import java.util.*;

public class ControladorHotelMascota implements ActionListener {

    private JFHotelMascota frmHotel;
    private ArrayList<Reserva> reservas;
    private ArrayList<Cuidador> cuidadores;

    public ControladorHotelMascota(JFHotelMascota frmHotel) {

        this.frmHotel = frmHotel;

        reservas = new ArrayList<>();
        cuidadores = new ArrayList<>();

        frmHotel.btnRerservar.addActionListener(this);
        frmHotel.btnMostrar.addActionListener(this);

        inicializar();
    }

    private void inicializar() {

        Cuidador c1 = new Cuidador(
                "C1",
                "Carlos",
                "Perro",
                5,
                true
        );

        Cuidador c2 = new Cuidador(
                "C2",
                "Ana",
                "Gato",
                3,
                true
        );

        Cuidador c3 = new Cuidador(
                "C3",
                "Luis",
                "Ave",
                7,
                false
        );

        cuidadores.add(c1);
        cuidadores.add(c2);
        cuidadores.add(c3);

        frmHotel.cmbCuidador.addItem(c1);
        frmHotel.cmbCuidador.addItem(c2);
        frmHotel.cmbCuidador.addItem(c3);

        frmHotel.cbmServicio.addItem(Servicio.ALIMENTACION_ESPECIAL);
        frmHotel.cbmServicio.addItem(Servicio.PASEO);
        frmHotel.cbmServicio.addItem(Servicio.BAÑO);

        frmHotel.cmbRaza.addItem("Perro");
        frmHotel.cmbRaza.addItem("Gato");
        frmHotel.cmbRaza.addItem("Ave");
        frmHotel.cmbRaza.addItem("Reptil");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmHotel.btnRerservar) {
            reservar();
        }

        if (e.getSource() == frmHotel.btnMostrar) {
            mostrarReservas();
        }
    }

    private void reservar() {

        try {

            String cedula = frmHotel.txtCedula.getText();
            String nombrePropietario = frmHotel.txtNombrePropietario.getText();
            String nombreMascota = frmHotel.txtNombreMascota.getText();
            String tipoAnimal = frmHotel.cmbRaza.getSelectedItem().toString();
            int edad = Integer.parseInt(frmHotel.txtEdad.getText());
            String necesidades = frmHotel.txtNecesidades.getText();
            
            String fechaTexto = frmHotel.txtFecha.getText();

            String[] partesFecha = fechaTexto.split("/");

            int dia = Integer.parseInt(partesFecha[0]);
            int mes = Integer.parseInt(partesFecha[1]);
            int anio = Integer.parseInt(partesFecha[2]);

            String horaTexto = frmHotel.txtHora.getText();

            
            String[] partesHora = horaTexto.split(":");

            int hora = Integer.parseInt(partesHora[0]);
            int minuto = Integer.parseInt(partesHora[1]);

            Fecha fecha = new Fecha(
                    dia,
                    mes,
                    anio,
                    hora,
                    minuto
            );

            Cuidador cuidador = (Cuidador) frmHotel.cmbCuidador.getSelectedItem();

            Servicio servicio = (Servicio) frmHotel.cbmServicio.getSelectedItem();

            if (cedula.isEmpty()
                    || nombrePropietario.isEmpty()
                    || nombreMascota.isEmpty()
                    || frmHotel.txtEdad.getText().isEmpty()
                    || necesidades.isEmpty()
                    || fechaTexto.isEmpty()
                    || horaTexto.isEmpty()) {

                frmHotel.AreaResultado.setText("Todos los campos son obligatorios");

                return;
            }

            if (!cuidador.isDisponibilidad()) {

                frmHotel.AreaResultado.setText("El cuidador no está disponible");

                return;
            }

            if (!cuidador.getTipoAnimal().equalsIgnoreCase(tipoAnimal)) {

                frmHotel.AreaResultado.setText("El cuidador no atiende este tipo de animal");

                return;
            }

            for (Reserva r : reservas) {

                if (r.getCuidador().equals(cuidador)
                        && r.getFecha().mismaFechaHora(fecha)) {

                    frmHotel.AreaResultado.setText("El cuidador ya tiene una reserva en esa fecha y hora");

                    return;
                }
            }

            Propietario propietario =
                    new Propietario(
                            cedula,
                            nombrePropietario,
                            new ArrayList<>()
                    );

            Mascota mascota =
                    new Mascota(
                            nombreMascota,
                            tipoAnimal,
                            edad,
                            necesidades,
                            propietario
                    );

            propietario.registrarMascota(mascota);

            Reserva reserva =
                    new Reserva(
                            propietario,
                            mascota,
                            cuidador,
                            fecha,
                            1,
                            servicio
                    );

            reservas.add(reserva);

            frmHotel.AreaResultado.setText(
                    "Reserva registrada correctamente"
            );

            limpiar();

        } catch (NumberFormatException e) {
            frmHotel.AreaResultado.setText("Error en datos numéricos");
            

        } catch (ArrayIndexOutOfBoundsException e) {

            frmHotel.AreaResultado.setText(
                    "Formato inválido\n"
                    + "Fecha: dd/MM/yyyy\n"
                    + "Hora: HH:mm"
            );
        }
    }

    private void mostrarReservas() {

        if (reservas.isEmpty()) {

            frmHotel.AreaResultado.setText("No hay reservas registradas");
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("===== RESERVAS =====\n\n");

        for (Reserva r : reservas) {

            sb.append("Propietario: ")
                    .append(r.getPropietario().getNombre())
                    .append("\n");

            sb.append("Cedula: ")
                    .append(r.getPropietario().getCedula())
                    .append("\n");

            sb.append("Mascota: ")
                    .append(r.getMascota().getNombre())
                    .append("\n");

            sb.append("Tipo Animal: ")
                    .append(r.getMascota().getTipoAnimal())
                    .append("\n");

            sb.append("Edad: ")
                    .append(r.getMascota().getEdad())
                    .append("\n");

            sb.append("Necesidades: ")
                    .append(r.getMascota().getNecesidades())
                    .append("\n");

            sb.append("Cuidador: ")
                    .append(r.getCuidador().getNombre())
                    .append("\n");

            sb.append("Servicio: ")
                    .append(r.getServicio())
                    .append("\n");

            sb.append("Fecha: ")
                    .append(r.getFecha())
                    .append("\n");

            sb.append("-----------------------------------\n");
        }

        frmHotel.AreaResultado.setText(sb.toString());
    }

    private void limpiar() {

        frmHotel.txtCedula.setText("");
        frmHotel.txtNombrePropietario.setText("");
        frmHotel.txtNombreMascota.setText("");
        frmHotel.txtEdad.setText("");
        frmHotel.txtNecesidades.setText("");
        frmHotel.txtFecha.setText("");
        frmHotel.txtHora.setText("");
    }
}