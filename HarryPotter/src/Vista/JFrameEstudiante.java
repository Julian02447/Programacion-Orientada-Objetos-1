/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.*;

public class JFrameEstudiante extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrameEstudiante.class.getName());

    /**
     * Creates new form JFrameEstudiante
     */
    public JFrameEstudiante() {
        initComponents();
        cmbCasa.setModel(new javax.swing.DefaultComboBoxModel<>(CasaHogwarts.values()));
        cmbObjeto.setModel(new javax.swing.DefaultComboBoxModel<>(TipoObjeto.values()));
        cmbLocacion.setModel(new javax.swing.DefaultComboBoxModel<>(Locacion.values()));
        aplicarTema();
    }

    private void aplicarTema() {
    java.awt.Color colorFondo      = new java.awt.Color(20, 10, 35);
    java.awt.Color colorPanel      = new java.awt.Color(35, 20, 55);
    java.awt.Color colorAcento     = new java.awt.Color(197, 160, 60);
    java.awt.Color colorTexto      = new java.awt.Color(230, 210, 150);
    java.awt.Color colorCampo      = new java.awt.Color(50, 30, 75);
    java.awt.Color colorBoton      = new java.awt.Color(120, 20, 30);
    java.awt.Font  fuenteLabel     = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13);
    java.awt.Font  fuenteBoton     = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13);

    getContentPane().setBackground(colorFondo);

    jPanel1.setBackground(colorPanel);
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
        javax.swing.BorderFactory.createLineBorder(colorAcento, 2),
        "Registro de Estudiante - Hogwarts",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15),
        colorAcento
    ));

    for (javax.swing.JLabel label : new javax.swing.JLabel[]{
        jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6
    }) {
        label.setFont(fuenteLabel);
        label.setForeground(colorTexto);
    }

    for (javax.swing.JTextField campo : new javax.swing.JTextField[]{
        txtNombre, txtAnio, txtHabilidad
    }) {
        campo.setFont(fuenteLabel);
        campo.setForeground(colorTexto);
        campo.setBackground(colorCampo);
        campo.setCaretColor(colorAcento);
        campo.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(colorAcento),
            javax.swing.BorderFactory.createEmptyBorder(2, 6, 2, 6)
        ));
    }

    for (javax.swing.JComboBox<?> combo : new javax.swing.JComboBox[]{cmbCasa, cmbObjeto, cmbLocacion}) {
        combo.setFont(fuenteLabel);
        combo.setBackground(colorCampo);
        combo.setForeground(colorTexto);
    }

    AreaResultsEstu.setFont(fuenteLabel);
    AreaResultsEstu.setForeground(colorTexto);
    AreaResultsEstu.setBackground(new java.awt.Color(15, 8, 25));
    AreaResultsEstu.setCaretColor(colorAcento);
    jScrollPane1.getViewport().setBackground(new java.awt.Color(15, 8, 25));
    jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(colorAcento));

    for (javax.swing.JButton boton : new javax.swing.JButton[]{
        btnGuardar, btnAgregarObjeto, btnLearnHechizo, btnExplorar, btnStartDuelo
    }) {
        boton.setFont(fuenteBoton);
        boton.setBackground(colorBoton);
        boton.setForeground(colorTexto);
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtHabilidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbCasa = new javax.swing.JComboBox<>();
        cmbObjeto = new javax.swing.JComboBox<>();
        cmbLocacion = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnAgregarObjeto = new javax.swing.JButton();
        btnLearnHechizo = new javax.swing.JButton();
        btnExplorar = new javax.swing.JButton();
        btnStartDuelo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaResultsEstu = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de estudiante - Hogwarts"));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Casa:");
        jLabel2.setToolTipText("");

        jLabel3.setText("Año de estudio:");

        jLabel4.setText("Hablidad Especial:");

        jLabel5.setText("Obejto Magico:");

        jLabel6.setText("Explorar Locacion:");

        btnGuardar.setText("Guardar");

        btnAgregarObjeto.setText("Agregar Objeto");

        btnLearnHechizo.setText("Aprender Hechizo");

        btnExplorar.setText("Explorar");

        btnStartDuelo.setText("Iniciar Duelo");

        AreaResultsEstu.setColumns(20);
        AreaResultsEstu.setLineWrap(true);
        AreaResultsEstu.setRows(5);
        AreaResultsEstu.setText("Resultados");
        AreaResultsEstu.setWrapStyleWord(true);
        jScrollPane1.setViewportView(AreaResultsEstu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(btnExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnStartDuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(cmbCasa, 0, 236, Short.MAX_VALUE)
                                    .addComponent(txtAnio)
                                    .addComponent(txtHabilidad)
                                    .addComponent(cmbObjeto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLocacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLearnHechizo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbLocacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnAgregarObjeto)
                    .addComponent(btnLearnHechizo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExplorar)
                    .addComponent(btnStartDuelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrameEstudiante().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea AreaResultsEstu;
    public javax.swing.JButton btnAgregarObjeto;
    public javax.swing.JButton btnExplorar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLearnHechizo;
    public javax.swing.JButton btnStartDuelo;
    public javax.swing.JComboBox<CasaHogwarts> cmbCasa;
    public javax.swing.JComboBox<Locacion> cmbLocacion;
    public javax.swing.JComboBox<TipoObjeto> cmbObjeto;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtAnio;
    public javax.swing.JTextField txtHabilidad;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
