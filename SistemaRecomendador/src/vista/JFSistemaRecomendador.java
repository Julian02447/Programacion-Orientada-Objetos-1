package vista;

import modelo.Pelicula;
import modelo.Usuario;

public class JFSistemaRecomendador extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(JFSistemaRecomendador.class.getName());

    public JFSistemaRecomendador() {
        initComponents();
        aplicarColores();
    }
    public void aplicarColores() {
 
        // ── Colores del tema ─────────────────────────────────────────────────
        java.awt.Color FONDO_OSCURO = new java.awt.Color(0x1A1A2E);
        java.awt.Color FONDO_PANEL  = new java.awt.Color(0x16213E);
        java.awt.Color ACENTO       = new java.awt.Color(0xE2B96F);
        java.awt.Color TEXTO        = new java.awt.Color(0xE0E0E0);
        java.awt.Color AREA_BG      = new java.awt.Color(0x0F3460);
        java.awt.Color BTN_COLOR    = new java.awt.Color(0xE94560);
        java.awt.Color BTN_ACENTO   = new java.awt.Color(0xC8963A);
 
        java.awt.Font FONT_LABEL = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12);
        java.awt.Font FONT_AREA  = new java.awt.Font("Consolas", java.awt.Font.PLAIN, 12);
 
        // ── ContentPane ──────────────────────────────────────────────────────
        getContentPane().setBackground(FONDO_OSCURO);
 
        // ── Paneles ──────────────────────────────────────────────────────────
        for (javax.swing.JPanel panel : new javax.swing.JPanel[]{jPanel1, jPanel2, jPanel3}) {
            panel.setBackground(FONDO_PANEL);
            panel.setOpaque(true);
 
            // Borde con título en color dorado
            javax.swing.border.TitledBorder tb =
                    (javax.swing.border.TitledBorder) panel.getBorder();
            if (tb != null) {
                tb.setTitleColor(ACENTO);
                tb.setTitleFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
                tb.setBorder(javax.swing.BorderFactory.createLineBorder(ACENTO, 1));
            }
        }
 
        // ── Etiquetas ────────────────────────────────────────────────────────
        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{
                lblUsuario, lblPelicula, lblBuscar, lblRecomendaciones,
                jLabel1, jLabel2}) {
            lbl.setForeground(ACENTO);
            lbl.setFont(FONT_LABEL);
        }
 
        // ── ComboBoxes ───────────────────────────────────────────────────────
        for (javax.swing.JComboBox<?> cmb : new javax.swing.JComboBox<?>[]{
                cmbUser, cmbPelicula, cmbCalificacion}) {
            cmb.setBackground(AREA_BG);
            cmb.setForeground(TEXTO);
            cmb.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }
 
        // ── Campos de texto ──────────────────────────────────────────────────
        for (javax.swing.JTextField txt : new javax.swing.JTextField[]{
                txtBuscar, txtComentario}) {
            txt.setBackground(AREA_BG);
            txt.setForeground(TEXTO);
            txt.setCaretColor(ACENTO);
            txt.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(ACENTO, 1),
                    javax.swing.BorderFactory.createEmptyBorder(2, 6, 2, 6)));
            txt.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
        }
 
        // ── Áreas de texto ───────────────────────────────────────────────────
        for (javax.swing.JTextArea area : new javax.swing.JTextArea[]{
                AreaRecomendacion, AreaCalificacion, AreaComentario}) {
            area.setBackground(AREA_BG);
            area.setForeground(TEXTO);
            area.setCaretColor(ACENTO);
            area.setFont(FONT_AREA);
            area.setSelectedTextColor(FONDO_OSCURO);
            area.setSelectionColor(ACENTO);
        }
 
        // ── ScrollPanes ──────────────────────────────────────────────────────
        for (javax.swing.JScrollPane sp : new javax.swing.JScrollPane[]{
                jScrollPane1, jScrollPane2, jScrollPane3}) {
            sp.getViewport().setBackground(AREA_BG);
            sp.setBorder(javax.swing.BorderFactory.createLineBorder(ACENTO, 1));
            sp.getVerticalScrollBar().setBackground(FONDO_PANEL);
            sp.getHorizontalScrollBar().setBackground(FONDO_PANEL);
        }
 
        // ── Botones principales (rojo cartelera) ─────────────────────────────
        for (javax.swing.JButton btn : new javax.swing.JButton[]{
                btnCalificar, btnComentar}) {
            estilizarBoton(btn, BTN_COLOR, TEXTO);
        }
 
        // ── Botones secundarios (dorado) ─────────────────────────────────────
        for (javax.swing.JButton btn : new javax.swing.JButton[]{
                btnBuscar, btnGetRecomendacion,
                btnMostrarCalificacion, btnVerComentario}) {
            estilizarBoton(btn, BTN_ACENTO, FONDO_OSCURO);
        }
 
        repaint();
    }
 
    /**
     * Aplica estilo uniforme a un botón: fondo sólido, sin borde del sistema,
     * fuente bold y efecto hover al pasar el mouse.
     */
    private void estilizarBoton(javax.swing.JButton btn,
                                 java.awt.Color fondo,
                                 java.awt.Color texto) {
        btn.setBackground(fondo);
        btn.setForeground(texto);
        btn.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
 
        // Efecto hover: aclara el botón al pasar el mouse
        java.awt.Color fondoHover = fondo.brighter();
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(fondoHover);
            }
            @Override public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(fondo);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // ── Declaración de componentes ──────────────────────────────────────
        jPanel1               = new javax.swing.JPanel();
        lblUsuario            = new javax.swing.JLabel();
        cmbUser               = new javax.swing.JComboBox<>();
        lblPelicula           = new javax.swing.JLabel();
        cmbPelicula           = new javax.swing.JComboBox<>();
        lblBuscar             = new javax.swing.JLabel();
        txtBuscar             = new javax.swing.JTextField();
        btnBuscar             = new javax.swing.JButton();
        lblRecomendaciones    = new javax.swing.JLabel();
        jScrollPane3          = new javax.swing.JScrollPane();
        AreaRecomendacion     = new javax.swing.JTextArea();
        btnGetRecomendacion   = new javax.swing.JButton();

        jPanel2               = new javax.swing.JPanel();
        jLabel2               = new javax.swing.JLabel();
        cmbCalificacion       = new javax.swing.JComboBox<>();
        btnCalificar          = new javax.swing.JButton();
        btnMostrarCalificacion = new javax.swing.JButton();
        jScrollPane1          = new javax.swing.JScrollPane();
        AreaCalificacion      = new javax.swing.JTextArea();

        jPanel3               = new javax.swing.JPanel();
        jLabel1               = new javax.swing.JLabel();
        txtComentario         = new javax.swing.JTextField();
        btnComentar           = new javax.swing.JButton();
        btnVerComentario      = new javax.swing.JButton();
        jScrollPane2          = new javax.swing.JScrollPane();
        AreaComentario        = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Recomendación de Películas");

        // ── jPanel1: Sistema Recomendador ───────────────────────────────────
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
            null, "SISTEMA RECOMENDADOR",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 1, 12)));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblPelicula.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPelicula.setText("Pelicula:");

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBuscar.setText("Buscar:");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtBuscar.setToolTipText("Buscar por titulo, genero o director");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblRecomendaciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRecomendaciones.setText("Recomendaciones:");

        AreaRecomendacion.setColumns(20);
        AreaRecomendacion.setRows(6);
        AreaRecomendacion.setEditable(false);
        AreaRecomendacion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        AreaRecomendacion.setLineWrap(true);
        AreaRecomendacion.setWrapStyleWord(true);
        jScrollPane3.setViewportView(AreaRecomendacion);

        btnGetRecomendacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGetRecomendacion.setText("Obtener Recomendacion");
        btnGetRecomendacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRecomendacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(lblRecomendaciones)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetRecomendacion))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(cmbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPelicula)
                    .addComponent(cmbPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecomendaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetRecomendacion)
                .addGap(10, 10, 10))
        );

        // ── jPanel2: Calificaciones ─────────────────────────────────────────
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("CALIFICACIONES"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Calificacion:");

        cmbCalificacion.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"1", "2", "3", "4", "5"}));

        btnCalificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalificar.setText("Calificar");
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });

        btnMostrarCalificacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMostrarCalificacion.setText("Mostrar Calificaciones");
        btnMostrarCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCalificacionActionPerformed(evt);
            }
        });

        AreaCalificacion.setColumns(20);
        AreaCalificacion.setRows(5);
        AreaCalificacion.setEditable(false);
        AreaCalificacion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(AreaCalificacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCalificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarCalificacion))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalificar)
                    .addComponent(btnMostrarCalificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        // ── jPanel3: Comentarios ────────────────────────────────────────────
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("COMENTARIOS"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Comentario:");

        txtComentario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnComentar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnComentar.setText("Comentar");
        btnComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarActionPerformed(evt);
            }
        });

        btnVerComentario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerComentario.setText("Ver Comentarios");
        btnVerComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerComentarioActionPerformed(evt);
            }
        });

        AreaComentario.setColumns(20);
        AreaComentario.setRows(5);
        AreaComentario.setEditable(false);
        AreaComentario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jScrollPane2.setViewportView(AreaComentario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnComentar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerComentario))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComentar)
                    .addComponent(btnVerComentario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        // ── Layout principal ────────────────────────────────────────────────
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
    }//GEN-LAST:event_btnCalificarActionPerformed

    private void btnMostrarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCalificacionActionPerformed
    }//GEN-LAST:event_btnMostrarCalificacionActionPerformed

    private void btnComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarActionPerformed
    }//GEN-LAST:event_btnComentarActionPerformed

    private void btnVerComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComentarioActionPerformed
    }//GEN-LAST:event_btnVerComentarioActionPerformed

    private void btnGetRecomendacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRecomendacionActionPerformed
    }//GEN-LAST:event_btnGetRecomendacionActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new JFSistemaRecomendador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public  javax.swing.JTextArea                    AreaCalificacion;
    public  javax.swing.JTextArea                    AreaComentario;
    public  javax.swing.JTextArea                    AreaRecomendacion;
    public  javax.swing.JButton                      btnBuscar;
    public  javax.swing.JButton                      btnCalificar;
    public  javax.swing.JButton                      btnComentar;
    public  javax.swing.JButton                      btnGetRecomendacion;
    public  javax.swing.JButton                      btnMostrarCalificacion;
    public  javax.swing.JButton                      btnVerComentario;
    public  javax.swing.JComboBox<String>            cmbCalificacion;
    public  javax.swing.JComboBox<Pelicula>          cmbPelicula;
    public  javax.swing.JComboBox<Usuario>           cmbUser;
    private javax.swing.JLabel                       jLabel1;
    private javax.swing.JLabel                       jLabel2;
    private javax.swing.JPanel                       jPanel1;
    private javax.swing.JPanel                       jPanel2;
    private javax.swing.JPanel                       jPanel3;
    private javax.swing.JScrollPane                  jScrollPane1;
    private javax.swing.JScrollPane                  jScrollPane2;
    private javax.swing.JScrollPane                  jScrollPane3;
    public  javax.swing.JLabel                       lblBuscar;
    public  javax.swing.JLabel                       lblPelicula;
    public  javax.swing.JLabel                       lblRecomendaciones;
    public  javax.swing.JLabel                       lblUsuario;
    public  javax.swing.JTextField                   txtBuscar;
    public  javax.swing.JTextField                   txtComentario;
    // End of variables declaration//GEN-END:variables
}
