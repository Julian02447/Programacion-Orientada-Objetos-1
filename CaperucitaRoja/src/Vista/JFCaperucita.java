package Vista;

import Modelo.TipoComida;

public class JFCaperucita extends javax.swing.JFrame {

    public JFCaperucita() {
        initComponents();
        // Cargar comidas en el ComboBox
        ComboBoxComida.setModel(new javax.swing.DefaultComboBoxModel<>(TipoComida.values()));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPersonajes = new javax.swing.JPanel();
        jPanelBosque     = new javax.swing.JPanel();
        jPanelHistoria   = new javax.swing.JPanel();
        jScrollPane1     = new javax.swing.JScrollPane();

        // ── Personajes (solo etiquetas con nombres fijos) ──────────────────
        lblCaperucita  = new javax.swing.JLabel();
        lblAbuela      = new javax.swing.JLabel();
        lblLobo        = new javax.swing.JLabel();
        lblLeniador    = new javax.swing.JLabel();
        lblBosque      = new javax.swing.JLabel();

        // ── Cesta ─────────────────────────────────────────────────────────
        lblComida      = new javax.swing.JLabel();
        ComboBoxComida = new javax.swing.JComboBox<>();

        // ── Botones ───────────────────────────────────────────────────────
        btnRegistrar     = new javax.swing.JButton();
        btnAgregarComida = new javax.swing.JButton();
        btnPaso1         = new javax.swing.JButton();
        btnPaso2         = new javax.swing.JButton();
        btnPaso3         = new javax.swing.JButton();
        btnPaso4         = new javax.swing.JButton();
        btnPaso5         = new javax.swing.JButton();
        lblPaso          = new javax.swing.JLabel();

        // ── Área de historia ──────────────────────────────────────────────
        AreaHistoria = new javax.swing.JTextArea(18, 50);

        // ── Configuración Frame ───────────────────────────────────────────
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caperucita Roja - Historia Interactiva");

        java.awt.Font fontTitulo = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 14);
        java.awt.Font fontNormal = new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 13);
        java.awt.Font fontPersonaje = new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 13);

        // ══ PANEL PERSONAJES ══════════════════════════════════════════════
        jPanelPersonajes.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(178, 34, 34)),
                "Personajes",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                fontTitulo));
        jPanelPersonajes.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(4, 12, 4, 12);
        gbc.anchor = java.awt.GridBagConstraints.CENTER;

        // Etiquetas de personajes con iconos
        lblCaperucita.setFont(fontPersonaje);
        lblCaperucita.setText("Caperucita Roja");
        lblCaperucita.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 34, 34), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)));

        lblAbuela.setFont(fontPersonaje);
        lblAbuela.setText("La Abuela");
        lblAbuela.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 34, 34), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)));

        lblLobo.setFont(fontPersonaje);
        lblLobo.setText("El Lobo Feroz");
        lblLobo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 34, 34), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)));

        lblLeniador.setFont(fontPersonaje);
        lblLeniador.setText("El Leñador");
        lblLeniador.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(178, 34, 34), 1, true),
                javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)));

        gbc.gridx = 0; gbc.gridy = 0; jPanelPersonajes.add(lblCaperucita, gbc);
        gbc.gridx = 1;                jPanelPersonajes.add(lblAbuela,     gbc);
        gbc.gridx = 2;                jPanelPersonajes.add(lblLobo,       gbc);
        gbc.gridx = 3;                jPanelPersonajes.add(lblLeniador,   gbc);

        // Botón registrar
        btnRegistrar.setFont(fontTitulo);
        btnRegistrar.setText("Registrar Personajes");
        btnRegistrar.setBackground(new java.awt.Color(178, 34, 34));
        btnRegistrar.setForeground(java.awt.Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 4;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        jPanelPersonajes.add(btnRegistrar, gbc);

        // ══ PANEL BOSQUE Y CESTA ══════════════════════════════════════════
        jPanelBosque.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(34, 139, 34)),
                "Bosque y Cesta",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                fontTitulo));
        jPanelBosque.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcB = new java.awt.GridBagConstraints();
        gbcB.insets = new java.awt.Insets(5, 10, 5, 10);
        gbcB.anchor = java.awt.GridBagConstraints.WEST;

        lblBosque.setFont(fontTitulo);
        lblBosque.setText("Bosque: El Gran Bosque Encantado");
        gbcB.gridx = 0; gbcB.gridy = 0; gbcB.fill = java.awt.GridBagConstraints.NONE; gbcB.weightx = 0;
        jPanelBosque.add(lblBosque, gbcB);

        // Cesta
        lblComida.setFont(fontTitulo);
        lblComida.setText("Agregar a cesta:");
        ComboBoxComida.setFont(fontNormal);

        btnAgregarComida.setFont(fontTitulo);
        btnAgregarComida.setText("Agregar a Cesta");
        btnAgregarComida.setBackground(new java.awt.Color(34, 139, 34));
        btnAgregarComida.setForeground(java.awt.Color.WHITE);
        btnAgregarComida.setFocusPainted(false);

        gbcB.gridx = 0; gbcB.gridy = 1; gbcB.fill = java.awt.GridBagConstraints.NONE; gbcB.weightx = 0;
        jPanelBosque.add(lblComida, gbcB);
        gbcB.gridx = 1; gbcB.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcB.weightx = 1.0;
        jPanelBosque.add(ComboBoxComida, gbcB);
        gbcB.gridx = 2; gbcB.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcB.weightx = 0.5;
        jPanelBosque.add(btnAgregarComida, gbcB);

        // ══ PANEL HISTORIA ════════════════════════════════════════════════
        jPanelHistoria.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(139, 69, 19)),
                "Simular Historia",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                fontTitulo));
        jPanelHistoria.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcH = new java.awt.GridBagConstraints();
        gbcH.insets = new java.awt.Insets(5, 6, 5, 6);

        // Botones de pasos en fila
        btnPaso1.setFont(fontNormal); btnPaso1.setText("1. Sale al bosque");
        btnPaso2.setFont(fontNormal); btnPaso2.setText("2. Lobo aparece");
        btnPaso3.setFont(fontNormal); btnPaso3.setText("3. Lobo corre");
        btnPaso4.setFont(fontNormal); btnPaso4.setText("4. Llega a cabaña");
        btnPaso5.setFont(fontNormal); btnPaso5.setText("5. El Leñador rescata");
        btnPaso1.setEnabled(false);
        btnPaso2.setEnabled(false);
        btnPaso3.setEnabled(false);
        btnPaso4.setEnabled(false);
        btnPaso5.setEnabled(false);

        gbcH.gridy = 0; gbcH.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcH.weightx = 1.0;
        gbcH.gridx = 0; jPanelHistoria.add(btnPaso1, gbcH);
        gbcH.gridx = 1; jPanelHistoria.add(btnPaso2, gbcH);
        gbcH.gridx = 2; jPanelHistoria.add(btnPaso3, gbcH);
        gbcH.gridx = 3; jPanelHistoria.add(btnPaso4, gbcH);
        gbcH.gridx = 4; jPanelHistoria.add(btnPaso5, gbcH);

        // Área de historia (más grande)
        AreaHistoria.setFont(new java.awt.Font("Sitka Text", java.awt.Font.ITALIC, 14));
        AreaHistoria.setText("Aquí se narrará la historia...\nPrimero registra los personajes y luego presiona los pasos en orden.");
        AreaHistoria.setEditable(false);
        AreaHistoria.setLineWrap(true);
        AreaHistoria.setWrapStyleWord(true);
        AreaHistoria.setBackground(new java.awt.Color(255, 252, 240));
        jScrollPane1.setViewportView(AreaHistoria);

        gbcH.gridx = 0; gbcH.gridy = 1; gbcH.gridwidth = 5;
        gbcH.fill = java.awt.GridBagConstraints.BOTH;
        gbcH.weightx = 1.0; gbcH.weighty = 1.0;
        jPanelHistoria.add(jScrollPane1, gbcH);

        // ══ Layout principal ══════════════════════════════════════════════
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPersonajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBosque,     javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHistoria,   javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(10)
                .addComponent(jPanelPersonajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8)
                .addComponent(jPanelBosque,     javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8)
                .addComponent(jPanelHistoria,   javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(10)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public  javax.swing.JTextArea                   AreaHistoria;
    public  javax.swing.JComboBox<TipoComida>       ComboBoxComida;
    public  javax.swing.JButton                     btnRegistrar;
    public  javax.swing.JButton                     btnAgregarComida;
    public  javax.swing.JButton                     btnPaso1;
    public  javax.swing.JButton                     btnPaso2;
    public  javax.swing.JButton                     btnPaso3;
    public  javax.swing.JButton                     btnPaso4;
    public  javax.swing.JButton                     btnPaso5;
    private javax.swing.JPanel                      jPanelPersonajes;
    private javax.swing.JPanel                      jPanelBosque;
    private javax.swing.JPanel                      jPanelHistoria;
    private javax.swing.JScrollPane                 jScrollPane1;
    public  javax.swing.JLabel                      lblCaperucita;
    public  javax.swing.JLabel                      lblAbuela;
    public  javax.swing.JLabel                      lblLobo;
    public  javax.swing.JLabel                      lblLeniador;
    public  javax.swing.JLabel                      lblBosque;
    public  javax.swing.JLabel                      lblComida;
    public  javax.swing.JLabel                      lblPaso;
    // End of variables declaration//GEN-END:variables
}
