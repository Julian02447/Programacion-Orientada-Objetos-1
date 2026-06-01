package Vista;

import Modelo.Personaje;
import Modelo.ObjetoInteractivo;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JFVecindad extends JFrame {

    public JList<Personaje> listPersonajes;
    public JList<ObjetoInteractivo> listObjetos;
    public JLabel lblNombre;
    public JLabel lblEdad;
    public JLabel lblPersonalidad;
    public JLabel lblRol;
    public JLabel lblObjNombre;
    public JLabel lblObjDescripcion;
    public JButton btnSimular;

    public JFVecindad() {
        initComponents();
    }

    private void initComponents() {
        setTitle("La Vecindad del Chavo del 8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        // ── HEADER ──
        JLabel lblTitulo = new JLabel("🏘  La Vecindad del Chavo del Ocho", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new Color(255, 193, 7));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // ── CENTRO: dos paneles lado a lado ──
        JPanel pnlCentro = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(10, 14, 6, 14));

        // Panel personajes
        JPanel pnlPersonajes = new JPanel(new BorderLayout(6, 6));
        pnlPersonajes.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 193, 7), 2),
                "Personajes de la Vecindad",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 13)));

        listPersonajes = new JList<>();
        listPersonajes.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        listPersonajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPersonajes.setBackground(new Color(255, 253, 231));
        JScrollPane scrollP = new JScrollPane(listPersonajes);
        scrollP.setPreferredSize(new Dimension(220, 120));

        // Detalle personaje
        JPanel pnlDetalleP = new JPanel(new GridLayout(4, 1, 2, 2));
        pnlDetalleP.setBorder(BorderFactory.createEmptyBorder(6, 4, 4, 4));
        lblNombre      = new JLabel("Nombre: —");
        lblEdad        = new JLabel("Edad: —");
        lblPersonalidad = new JLabel("Personalidad: —");
        lblRol         = new JLabel("Rol: —");
        for (JLabel l : new JLabel[]{lblNombre, lblEdad, lblPersonalidad, lblRol}) {
            l.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            pnlDetalleP.add(l);
        }

        pnlPersonajes.add(scrollP, BorderLayout.CENTER);
        pnlPersonajes.add(pnlDetalleP, BorderLayout.SOUTH);

        // Panel objetos
        JPanel pnlObjetos = new JPanel(new BorderLayout(6, 6));
        pnlObjetos.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 193, 7), 2),
                "Objetos de la Vecindad",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 13)));

        listObjetos = new JList<>();
        listObjetos.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        listObjetos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listObjetos.setBackground(new Color(255, 253, 231));
        JScrollPane scrollO = new JScrollPane(listObjetos);
        scrollO.setPreferredSize(new Dimension(220, 120));

        // Detalle objeto
        JPanel pnlDetalleO = new JPanel(new GridLayout(2, 1, 2, 2));
        pnlDetalleO.setBorder(BorderFactory.createEmptyBorder(6, 4, 4, 4));
        lblObjNombre      = new JLabel("Objeto: —");
        lblObjDescripcion = new JLabel("<html>Descripción: —</html>");
        for (JLabel l : new JLabel[]{lblObjNombre, lblObjDescripcion}) {
            l.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            pnlDetalleO.add(l);
        }

        pnlObjetos.add(scrollO, BorderLayout.CENTER);
        pnlObjetos.add(pnlDetalleO, BorderLayout.SOUTH);

        pnlCentro.add(pnlPersonajes);
        pnlCentro.add(pnlObjetos);
        add(pnlCentro, BorderLayout.CENTER);

        // ── BOTONES ──
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 10));
        pnlBotones.setBackground(new Color(255, 248, 200));

        btnSimular = new JButton("Ir a Simulación ▶");
        btnSimular.setFont(new Font("Times New Roman", Font.BOLD, 13));
        btnSimular.setBackground(new Color(34, 139, 34));
        btnSimular.setForeground(Color.WHITE);
        btnSimular.setFocusPainted(false);

        pnlBotones.add(btnSimular);
        add(pnlBotones, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}
