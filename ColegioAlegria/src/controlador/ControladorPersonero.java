package controlador;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import modelo.*;
import vista.JFVotacionesRepresentantes;

public class ControladorPersonero implements ActionListener {

    private final JFVotacionesRepresentantes frmVotaciones;
    private final ArrayList<CandidatoPersonero>    listaPersonero;
    private final ArrayList<CandidatoRepresentante> listaRepresentantes;
    private final Voto voto;

    public ControladorPersonero(JFVotacionesRepresentantes frmVotaciones) {
        this.frmVotaciones      = frmVotaciones;
        this.listaPersonero     = DatosColegio.crearPersoneros();
        this.listaRepresentantes = DatosColegio.crearRepresentantes();
        this.voto               = new Voto();
        frmVotaciones.btnVotarPersonero.addActionListener(this);
        frmVotaciones.btnVotarRepresentante.addActionListener(this);
        frmVotaciones.btnMostrar.addActionListener(this);
        frmVotaciones.btnReiniciar.addActionListener(this);

        iniciar();
    }

    private void iniciar() {
        DefaultComboBoxModel<CandidatoPersonero>    modelo1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<CandidatoRepresentante> modelo2 = new DefaultComboBoxModel<>();

        for (CandidatoPersonero cp : listaPersonero) {
            modelo1.addElement(cp);
            voto.getVotosP().put(cp.getNombre(), 0);
        }
        for (CandidatoRepresentante cr : listaRepresentantes) {
            modelo2.addElement(cr);
            voto.getVotosR().put(cr.getNombre(), 0);
        }

        frmVotaciones.cmbPersonero.setModel(modelo1);
        frmVotaciones.cmbRepresentante.setModel(modelo2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if      (src == frmVotaciones.btnVotarPersonero)    votarPersonero();
        else if (src == frmVotaciones.btnVotarRepresentante) votarRepresentante();
        else if (src == frmVotaciones.btnMostrar)            mostrar();
        else if (src == frmVotaciones.btnReiniciar)          reiniciar();
    }

    private void votarPersonero() {
        CandidatoPersonero cp =
            (CandidatoPersonero) frmVotaciones.cmbPersonero.getSelectedItem();
        if (cp == null) return;
        voto.votarP(cp.getNombre());
        frmVotaciones.AreaResultado.append("Voto para: " + cp.getNombre() + "\n");
    }

    private void votarRepresentante() {
        CandidatoRepresentante cr =
            (CandidatoRepresentante) frmVotaciones.cmbRepresentante.getSelectedItem();
        if (cr == null) return;
        voto.votarR(cr.getNombre());
        frmVotaciones.AreaResultado.append("Voto para: " + cr.getNombre() + "\n");
    }

    private void mostrar() {
        if (voto.getVotosP().isEmpty() && voto.getVotosR().isEmpty()) {
            frmVotaciones.AreaResultado.setText("No hay votos registrados.");
            return;
        }

        String ganadorP = buscarExtremo(voto.getVotosP(), true);
        String menorP   = buscarExtremo(voto.getVotosP(), false);
        String ganadorR = buscarExtremo(voto.getVotosR(), true);
        String menorR   = buscarExtremo(voto.getVotosR(), false);

        StringBuilder sb = new StringBuilder("\n======RESULTADOS VOTACIONES======\n");
        sb.append("\nGanador Personero:          ").append(ganadorP)
          .append(" (").append(voto.getVotosP().get(ganadorP)).append(" votos)");
        sb.append("\nMenor votos Personero:      ").append(menorP)
          .append(" (").append(voto.getVotosP().get(menorP)).append(" votos)");
        sb.append("\n\nGanador Representante:      ").append(ganadorR)
          .append(" (").append(voto.getVotosR().get(ganadorR)).append(" votos)");
        sb.append("\nMenor votos Representante:  ").append(menorR)
          .append(" (").append(voto.getVotosR().get(menorR)).append(" votos)");
        sb.append("\n\n--- RF4: Población Electoral ---");
        sb.append("\nVotos nulos:    ").append(voto.getVotosNulos());
        sb.append("\nVotos en blanco:").append(voto.getVotosEnBlanco());
        sb.append("\nTotal población:").append(voto.getPoblacionElectoral());

        frmVotaciones.AreaResultado.setText(sb.toString());
    }

    private void reiniciar() {
        voto.reiniciar();   // conserva candidatos, pone contadores a 0
        frmVotaciones.AreaResultado.setText("Votaciones reiniciadas.");
    }
    /**
     * Devuelve el nombre del candidato con mayor o menor cantidad de votos.
     *
     * @param votos  mapa nombre → cantidad
     * @param mayor  true = ganador, false = menor votación
     */
    private String buscarExtremo(Map<String, Integer> votos, boolean mayor) {
        return votos.entrySet().stream()
            .reduce((a, b) -> (mayor
                    ? a.getValue() >= b.getValue()
                    : a.getValue() <= b.getValue()) ? a : b)
            .map(Map.Entry::getKey)
            .orElse("N/A");
    }
}