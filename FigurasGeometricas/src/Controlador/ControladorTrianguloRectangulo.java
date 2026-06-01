package Controlador;

import Modelo.TrianguloRectangulo;
import Vista.JFTrianguloRectangulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorTrianguloRectangulo implements ActionListener {

    private JFTrianguloRectangulo frmTriangulo;
    private TrianguloRectangulo modelo;

    public ControladorTrianguloRectangulo(JFTrianguloRectangulo frmTriangulo) {
        this.frmTriangulo = frmTriangulo;
        this.modelo = new TrianguloRectangulo();

        this.frmTriangulo.btnCalcularHipotenusa.addActionListener(this);
        this.frmTriangulo.btnVerificarPitagoras.addActionListener(this);
        this.frmTriangulo.btnCalcularAreaPerimetro.addActionListener(this);
        this.frmTriangulo.btnLimpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmTriangulo.btnCalcularHipotenusa) {
            calcularHipotenusa();
        }
        if (e.getSource() == frmTriangulo.btnVerificarPitagoras) {
            verificarPitagoras();
        }
        if (e.getSource() == frmTriangulo.btnCalcularAreaPerimetro) {
            calcularAreaYPerimetro();
        }
        if (e.getSource() == frmTriangulo.btnLimpiar) {
            limpiar();
        }
    }

    private double parsearDouble(String texto) {
        return Double.parseDouble(texto.trim().replace(",", "."));
    }

    private boolean validarCatetos() {
        String c1 = frmTriangulo.txtCateto1.getText().trim();
        String c2 = frmTriangulo.txtCateto2.getText().trim();

        if (c1.isEmpty() || c2.isEmpty()) {
            JOptionPane.showMessageDialog(frmTriangulo,
                "Debe ingresar los valores de Cateto 1 y Cateto 2.",
                "Campos vacios", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            double v1 = parsearDouble(c1);
            double v2 = parsearDouble(c2);
            if (v1 <= 0 || v2 <= 0) {
                JOptionPane.showMessageDialog(frmTriangulo,
                    "Los catetos deben ser numeros mayores a cero.",
                    "Valor invalido", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frmTriangulo,
                "Ingrese solo numeros validos en los catetos.",
                "Formato invalido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void calcularHipotenusa() {
        if (!validarCatetos()) return;

        double c1 = parsearDouble(frmTriangulo.txtCateto1.getText());
        double c2 = parsearDouble(frmTriangulo.txtCateto2.getText());

        modelo.setCateto1(c1);
        modelo.setCateto2(c2);
        double hip = modelo.calcularHipotenusa();

        frmTriangulo.txtHipotenusa.setText(String.format("%.4f", hip));
        frmTriangulo.lblResultadoHipotenusa.setText(
            String.format("Hipotenusa: %.4f", hip));
        frmTriangulo.lblResultadoVerificacion.setText("Verificacion Pitagoras: \u2014");
        frmTriangulo.lblResultadoArea.setText("Area: \u2014");
        frmTriangulo.lblResultadoPerimetro.setText("Perimetro: \u2014");
    }

    private void verificarPitagoras() {
        if (!validarCatetos()) return;

        if (frmTriangulo.txtHipotenusa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frmTriangulo,
                "Primero calcule la hipotenusa.",
                "Hipotenusa requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double c1 = parsearDouble(frmTriangulo.txtCateto1.getText());
        double c2 = parsearDouble(frmTriangulo.txtCateto2.getText());
        double hip = parsearDouble(frmTriangulo.txtHipotenusa.getText());

        modelo.setCateto1(c1);
        modelo.setCateto2(c2);
        modelo.setHipotenusa(hip);

        boolean cumple = modelo.verificarTeoremaPitagoras();
        String resultado = cumple
            ? "SI cumple el Teorema de Pitagoras"
            : "NO cumple el Teorema de Pitagoras";

        frmTriangulo.lblResultadoVerificacion.setText("Verificacion: " + resultado);
    }

    private void calcularAreaYPerimetro() {
        if (!validarCatetos()) return;

        if (frmTriangulo.txtHipotenusa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frmTriangulo,
                "Primero calcule la hipotenusa.",
                "Hipotenusa requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double c1 = parsearDouble(frmTriangulo.txtCateto1.getText());
        double c2 = parsearDouble(frmTriangulo.txtCateto2.getText());
        double hip = parsearDouble(frmTriangulo.txtHipotenusa.getText());

        modelo.setCateto1(c1);
        modelo.setCateto2(c2);
        modelo.setHipotenusa(hip);

        double area = modelo.calcularArea();
        double perimetro = modelo.calcularPerimetro();

        frmTriangulo.lblResultadoArea.setText(
            String.format("Area: %.4f u\u00b2", area));
        frmTriangulo.lblResultadoPerimetro.setText(
            String.format("Perimetro: %.4f u", perimetro));
    }

    private void limpiar() {
        frmTriangulo.txtCateto1.setText("");
        frmTriangulo.txtCateto2.setText("");
        frmTriangulo.txtHipotenusa.setText("");
        frmTriangulo.lblResultadoHipotenusa.setText("Hipotenusa: \u2014");
        frmTriangulo.lblResultadoVerificacion.setText("Verificacion Pitagoras: \u2014");
        frmTriangulo.lblResultadoArea.setText("Area: \u2014");
        frmTriangulo.lblResultadoPerimetro.setText("Perimetro: \u2014");
    }
}
