/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Estudiante
 */
public class JFTrianguloRectangulo extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFTrianguloRectangulo.class.getName());

    /**
     * Creates new form JFTrianguloRectangulo
     */
    public JFTrianguloRectangulo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlEntrada = new javax.swing.JPanel();
        lblCateto1 = new javax.swing.JLabel();
        txtCateto1 = new javax.swing.JTextField();
        lblCateto2 = new javax.swing.JLabel();
        txtCateto2 = new javax.swing.JTextField();
        lblHipotenusa = new javax.swing.JLabel();
        txtHipotenusa = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnCalcularHipotenusa = new javax.swing.JButton();
        btnVerificarPitagoras = new javax.swing.JButton();
        btnCalcularAreaPerimetro = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pnlResultados = new javax.swing.JPanel();
        lblResultadoHipotenusa = new javax.swing.JLabel();
        lblResultadoVerificacion = new javax.swing.JLabel();
        lblResultadoArea = new javax.swing.JLabel();
        lblResultadoPerimetro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Triangulo Rectangulo");
        setResizable(false);

        // Header
        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Triangulo Rectangulo");
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new java.awt.Color(41, 128, 185));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 12, 0));

        // Panel entrada
        pnlEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 128, 185), 2),
            "Datos del Triangulo",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Times New Roman", 1, 13))); // NOI18N

        lblCateto1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lblCateto1.setText("Cateto 1:");

        txtCateto1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblCateto2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lblCateto2.setText("Cateto 2:");

        txtCateto2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        lblHipotenusa.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        lblHipotenusa.setText("Hipotenusa:");

        txtHipotenusa.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtHipotenusa.setEditable(false);
        txtHipotenusa.setBackground(new java.awt.Color(236, 240, 241));

        javax.swing.GroupLayout pnlEntradaLayout = new javax.swing.GroupLayout(pnlEntrada);
        pnlEntrada.setLayout(pnlEntradaLayout);
        pnlEntradaLayout.setHorizontalGroup(
            pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntradaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCateto1)
                    .addComponent(lblCateto2)
                    .addComponent(lblHipotenusa))
                .addGap(12, 12, 12)
                .addGroup(pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCateto1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCateto2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHipotenusa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlEntradaLayout.setVerticalGroup(
            pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntradaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCateto1)
                    .addComponent(txtCateto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCateto2)
                    .addComponent(txtCateto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHipotenusa)
                    .addComponent(txtHipotenusa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        // Panel botones
        btnCalcularHipotenusa.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnCalcularHipotenusa.setText("Calcular Hipotenusa");
        btnCalcularHipotenusa.setBackground(new java.awt.Color(41, 128, 185));
        btnCalcularHipotenusa.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcularHipotenusa.setFocusPainted(false);
        btnCalcularHipotenusa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularHipotenusaActionPerformed(evt);
            }
        });

        btnVerificarPitagoras.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnVerificarPitagoras.setText("Verificar T. Pitagoras");
        btnVerificarPitagoras.setBackground(new java.awt.Color(39, 174, 96));
        btnVerificarPitagoras.setForeground(new java.awt.Color(255, 255, 255));
        btnVerificarPitagoras.setFocusPainted(false);
        btnVerificarPitagoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarPitagonasActionPerformed(evt);
            }
        });

        btnCalcularAreaPerimetro.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnCalcularAreaPerimetro.setText("Calcular Area y Perimetro");
        btnCalcularAreaPerimetro.setBackground(new java.awt.Color(142, 68, 173));
        btnCalcularAreaPerimetro.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcularAreaPerimetro.setFocusPainted(false);
        btnCalcularAreaPerimetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularAreaPerimetroActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBackground(new java.awt.Color(192, 57, 43));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcularHipotenusa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerificarPitagoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcularAreaPerimetro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCalcularHipotenusa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerificarPitagoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalcularAreaPerimetro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );

        // Panel resultados
        pnlResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 128, 185), 2),
            "Resultados",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Times New Roman", 1, 13))); // NOI18N

        lblResultadoHipotenusa.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lblResultadoHipotenusa.setText("Hipotenusa: —");

        lblResultadoVerificacion.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lblResultadoVerificacion.setText("Verificacion Pitagoras: —");

        lblResultadoArea.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lblResultadoArea.setText("Area: —");

        lblResultadoPerimetro.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lblResultadoPerimetro.setText("Perimetro: —");

        javax.swing.GroupLayout pnlResultadosLayout = new javax.swing.GroupLayout(pnlResultados);
        pnlResultados.setLayout(pnlResultadosLayout);
        pnlResultadosLayout.setHorizontalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResultadoHipotenusa)
                    .addComponent(lblResultadoVerificacion)
                    .addComponent(lblResultadoArea)
                    .addComponent(lblResultadoPerimetro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlResultadosLayout.setVerticalGroup(
            pnlResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultadoHipotenusa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultadoVerificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultadoArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultadoPerimetro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Layout principal
        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularHipotenusaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularHipotenusaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularHipotenusaActionPerformed

    private void btnVerificarPitagonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarPitagonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerificarPitagonasActionPerformed

    private void btnCalcularAreaPerimetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularAreaPerimetroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularAreaPerimetroActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new JFTrianguloRectangulo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCalcularAreaPerimetro;
    public javax.swing.JButton btnCalcularHipotenusa;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnVerificarPitagoras;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblCateto1;
    public javax.swing.JLabel lblCateto2;
    public javax.swing.JLabel lblHipotenusa;
    public javax.swing.JLabel lblResultadoArea;
    public javax.swing.JLabel lblResultadoHipotenusa;
    public javax.swing.JLabel lblResultadoPerimetro;
    public javax.swing.JLabel lblResultadoVerificacion;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEntrada;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlResultados;
    public javax.swing.JTextField txtCateto1;
    public javax.swing.JTextField txtCateto2;
    public javax.swing.JTextField txtHipotenusa;
    // End of variables declaration//GEN-END:variables
}
