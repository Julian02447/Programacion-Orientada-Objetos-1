package Vista;

import Modelo.Personaje;
import Modelo.ObjetoInteractivo;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JFSimulacion extends JFrame {

    public JComboBox<Personaje>        comboPersonaje;
    public JComboBox<ObjetoInteractivo> comboObjeto;
    public JButton btnHablar;
    public JButton btnAccionEspecial;
    public JButton btnMover;
    public JButton btnInteractuar;
    public JButton btnUsarObjeto;
    public JButton btnLimpiar;
    public JTextArea areaLog;

    public JFSimulacion() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Simulación — La Vecindad del Chavo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        // ── HEADER ──
        JLabel lblTitulo = new JLabel("🎭  Simulación de la Vecindad", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(34, 139, 34));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // ── PANEL IZQUIERDO: controles ──
        JPanel pnlControles = new JPanel();
        pnlControles.setLayout(new BoxLayout(pnlControles, BoxLayout.Y_AXIS));
        pnlControles.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 8));
        pnlControles.setPreferredSize(new Dimension(230, 0));

        // Selector personaje
        JPanel pnlSelP = new JPanel(new BorderLayout(4, 4));
        pnlSelP.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 1),
                "Seleccionar Personaje",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 12)));
        comboPersonaje = new JComboBox<>();
        comboPersonaje.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pnlSelP.add(comboPersonaje, BorderLayout.CENTER);
        pnlSelP.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));

        // Acciones personaje
        JPanel pnlAcciones = new JPanel(new GridLayout(3, 1, 4, 4));
        pnlAcciones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 1),
                "Acciones del Personaje",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 12)));

        btnHablar         = crearBoton("💬 Hablar",         new Color(70, 130, 180));
        btnAccionEspecial = crearBoton("⭐ Acción Especial", new Color(255, 140, 0));
        btnMover          = crearBoton("🚶 Moverse",         new Color(100, 149, 237));

        pnlAcciones.add(btnHablar);
        pnlAcciones.add(btnAccionEspecial);
        pnlAcciones.add(btnMover);
        pnlAcciones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        // Selector objeto
        JPanel pnlSelO = new JPanel(new BorderLayout(4, 4));
        pnlSelO.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 1),
                "Seleccionar Objeto",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 12)));
        comboObjeto = new JComboBox<>();
        comboObjeto.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pnlSelO.add(comboObjeto, BorderLayout.CENTER);
        pnlSelO.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));

        // Acciones objeto
        JPanel pnlAccObjeto = new JPanel(new GridLayout(2, 1, 4, 4));
        pnlAccObjeto.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 1),
                "Acciones con Objeto",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 12)));

        btnInteractuar = crearBoton("🤝 Interactuar",   new Color(147, 112, 219));
        btnUsarObjeto  = crearBoton("🔧 Usar Objeto",   new Color(60, 179, 113));

        pnlAccObjeto.add(btnInteractuar);
        pnlAccObjeto.add(btnUsarObjeto);
        pnlAccObjeto.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        // Limpiar
        btnLimpiar = crearBoton("🗑  Limpiar Log", new Color(178, 34, 34));
        btnLimpiar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));

        pnlControles.add(pnlSelP);
        pnlControles.add(Box.createVerticalStrut(8));
        pnlControles.add(pnlAcciones);
        pnlControles.add(Box.createVerticalStrut(8));
        pnlControles.add(pnlSelO);
        pnlControles.add(Box.createVerticalStrut(8));
        pnlControles.add(pnlAccObjeto);
        pnlControles.add(Box.createVerticalStrut(12));
        pnlControles.add(btnLimpiar);

        add(pnlControles, BorderLayout.WEST);

        // ── PANEL DERECHO: log ──
        JPanel pnlLog = new JPanel(new BorderLayout());
        pnlLog.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(34, 139, 34), 2),
                "Registro de Eventos",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 13)));
        pnlLog.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 0, 10, 14),
                pnlLog.getBorder()));

        areaLog = new JTextArea();
        areaLog.setEditable(false);
        areaLog.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaLog.setBackground(new Color(245, 255, 245));
        areaLog.setLineWrap(true);
        areaLog.setWrapStyleWord(true);
        areaLog.setText("¡Bienvenido a la Vecindad!\nSelecciona un personaje y realiza una acción.\n\n");

        JScrollPane scroll = new JScrollPane(areaLog);
        scroll.setPreferredSize(new Dimension(360, 380));
        pnlLog.add(scroll, BorderLayout.CENTER);

        add(pnlLog, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }
}
