package Controlador;

import Modelo.*;
import Vista.JFCaperucita;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCaperucita implements ActionListener {

    private JFCaperucita frmCaperucita;
    private Caperucita caperucita;
    private Abuela     abuela;
    private Lobo       lobo;
    private Lenador    leniador;
    private Bosque     bosque;

    public ControladorCaperucita(JFCaperucita frmCaperucita) {
        this.frmCaperucita = frmCaperucita;

        this.frmCaperucita.btnRegistrar.addActionListener(this);
        this.frmCaperucita.btnAgregarComida.addActionListener(this);
        this.frmCaperucita.btnPaso1.addActionListener(this);
        this.frmCaperucita.btnPaso2.addActionListener(this);
        this.frmCaperucita.btnPaso3.addActionListener(this);
        this.frmCaperucita.btnPaso4.addActionListener(this);
        this.frmCaperucita.btnPaso5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmCaperucita.btnRegistrar)     { registrarPersonajes();       }
        if (e.getSource() == frmCaperucita.btnAgregarComida) { agregarComidaCesta();        }
        if (e.getSource() == frmCaperucita.btnPaso1)         { paso1_CaperucitaSale();      }
        if (e.getSource() == frmCaperucita.btnPaso2)         { paso2_LoboHabla();           }
        if (e.getSource() == frmCaperucita.btnPaso3)         { paso3_LoboCorre();           }
        if (e.getSource() == frmCaperucita.btnPaso4)         { paso4_CaperucitaLlega();     }
        if (e.getSource() == frmCaperucita.btnPaso5)         { paso5_LeniadorRescata();     }
    }

    private void registrarPersonajes() {

        caperucita = new Caperucita("Caperucita Roja", "Roja");
        abuela     = new Abuela("La Abuela", 75, "Delicada");
        lobo       = new Lobo("El Lobo Feroz", 45);
        leniador   = new Lenador("El Leñador", "Hacha");
        bosque     = new Bosque("El Gran Bosque Encantado", 200.0);

        // Habilitar solo el primer paso
        frmCaperucita.btnPaso1.setEnabled(true);
        frmCaperucita.btnPaso2.setEnabled(false);
        frmCaperucita.btnPaso3.setEnabled(false);
        frmCaperucita.btnPaso4.setEnabled(false);
        frmCaperucita.btnPaso5.setEnabled(false);

        frmCaperucita.AreaHistoria.setText(
                "¡Personajes registrados!" + nl()
                + "─────────────────────────────────────────────" + nl()
                +  caperucita  + nl()
                + abuela      + nl()
                + lobo        + nl()
                + leniador    + nl()
                + bosque      + nl()
                + "─────────────────────────────────────────────" + nl()
                + bosque.describir()  + nl()
                + nl()
                + "Agrega comida a la cesta y luego presiona el Paso 1.");
    }

    // ── 2. Agregar comida a la cesta ──────────────────────────────────────
    private void agregarComidaCesta() {
        if (caperucita == null) {
            frmCaperucita.AreaHistoria.setText("Primero registra los personajes.");
            return;
        }
        TipoComida comida = (TipoComida) frmCaperucita.ComboBoxComida.getSelectedItem();
        caperucita.getCesta().agregarComida(comida);

        frmCaperucita.AreaHistoria.setText(
                comida.name() + " añadido a la cesta de " + caperucita.getNombre() + "." + nl()
                + nl()
                + "Contenido actual de la cesta:" + nl()
                + caperucita.getCesta().listarContenido());
    }

    private void paso1_CaperucitaSale() {
        frmCaperucita.AreaHistoria.append(
                nl()
                + "══════════════════════════════════════════════" + nl()
                + "Escena 1 — Caperucita sale al bosque"         + nl()
                + "══════════════════════════════════════════════" + nl()
                + caperucita.caminarAlBosque() + nl()
                + "La cesta lleva:" + nl()
                + caperucita.getCesta().listarContenido());
        frmCaperucita.btnPaso1.setEnabled(false);
        frmCaperucita.btnPaso2.setEnabled(true);
    }

    private void paso2_LoboHabla() {
        frmCaperucita.AreaHistoria.append(
                nl()
                + "══════════════════════════════════════════════" + nl()
                + "Escena 2 — El Lobo aparece"                   + nl()
                + "══════════════════════════════════════════════" + nl()
                + caperucita.hablarConLobo(lobo) + nl()
                + lobo.hablar());
        frmCaperucita.btnPaso2.setEnabled(false);
        frmCaperucita.btnPaso3.setEnabled(true);
    }

    private void paso3_LoboCorre() {
        frmCaperucita.AreaHistoria.append(
                nl()
                + "══════════════════════════════════════════════" + nl()
                + "Escena 3 — El Lobo corre a la cabaña"        + nl()
                + "══════════════════════════════════════════════" + nl()
                + lobo.correr()  +nl()
                + abuela.serEnganiada(lobo));
        frmCaperucita.btnPaso3.setEnabled(false);
        frmCaperucita.btnPaso4.setEnabled(true);
    }

    private void paso4_CaperucitaLlega() {
        frmCaperucita.AreaHistoria.append(
                nl()
                + "══════════════════════════════════════════════" + nl()
                + "Escena 4 — Caperucita llega a la cabaña"     + nl()
                + "══════════════════════════════════════════════" + nl()
                + caperucita.llegarACabania(abuela));
        frmCaperucita.btnPaso4.setEnabled(false);
        frmCaperucita.btnPaso5.setEnabled(true);
    }

    private void paso5_LeniadorRescata() {
        frmCaperucita.AreaHistoria.append(
                nl()
                + "══════════════════════════════════════════════" + nl()
                + "Escena 5 — ¡El Leñador al rescate!"          + nl()
                + "══════════════════════════════════════════════" + nl()
                + leniador.rescatar(caperucita, abuela, lobo)    + nl()
                + nl()
                + "¡FIN! El " + bosque.getNombre() + " vuelve a ser seguro.");
        frmCaperucita.btnPaso5.setEnabled(false);
    }

    private String nl() { return System.lineSeparator(); }
}
