package Modelo;

public class TrianguloRectangulo extends FiguraGeometrica {
    private double cateto1;
    private double cateto2;
    private double hipotenusa;

    public TrianguloRectangulo() {
        super("Triangulo Rectangulo");
    }

    public TrianguloRectangulo(double cateto1, double cateto2) {
        super("Triangulo Rectangulo");
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
        this.hipotenusa = calcularHipotenusa();
    }

    public double getCateto1() { return cateto1; }
    public void setCateto1(double cateto1) { this.cateto1 = cateto1; }

    public double getCateto2() { return cateto2; }
    public void setCateto2(double cateto2) { this.cateto2 = cateto2; }

    public double getHipotenusa() { return hipotenusa; }
    public void setHipotenusa(double hipotenusa) { this.hipotenusa = hipotenusa; }

    // R1: Calcular hipotenusa a partir de los catetos
    public double calcularHipotenusa() {
        hipotenusa = Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
        return hipotenusa;
    }

    // R2: Verificar Teorema de Pitagoras con los tres lados
    public boolean verificarTeoremaPitagoras() {
        return Math.abs((hipotenusa * hipotenusa) - (cateto1 * cateto1 + cateto2 * cateto2)) < 0.0001;
    }

    // R3: Calcular area (base * altura / 2, donde los catetos son base y altura)
    @Override
    public double calcularArea() {
        return (cateto1 * cateto2) / 2.0;
    }

    // R3: Calcular perimetro (cateto1 + cateto2 + hipotenusa)
    @Override
    public double calcularPerimetro() {
        return cateto1 + cateto2 + hipotenusa;
    }
}
