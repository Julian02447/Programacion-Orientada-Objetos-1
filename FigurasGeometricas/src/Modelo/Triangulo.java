package Modelo;

public class Triangulo extends FiguraGeometrica {
    protected double lado1;
    protected double lado2;
    protected double lado3;

    public Triangulo() {
        super("Triangulo");
    }

    public Triangulo(double lado1, double lado2, double lado3) {
        super("Triangulo");
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() { return lado1; }
    public void setLado1(double lado1) { this.lado1 = lado1; }

    public double getLado2() { return lado2; }
    public void setLado2(double lado2) { this.lado2 = lado2; }

    public double getLado3() { return lado3; }
    public void setLado3(double lado3) { this.lado3 = lado3; }

    public boolean esRectangulo() {
        double max = Math.max(lado1, Math.max(lado2, lado3));
        double a, b;
        if (max == lado1) { a = lado2; b = lado3; }
        else if (max == lado2) { a = lado1; b = lado3; }
        else { a = lado1; b = lado2; }
        return Math.abs((max * max) - (a * a + b * b)) < 0.0001;
    }

    @Override
    public double calcularArea() {
        // Formula de Heron
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}
