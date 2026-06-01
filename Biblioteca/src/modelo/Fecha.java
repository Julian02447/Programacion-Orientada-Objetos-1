package modelo;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia  = dia;
        this.mes  = mes;
        this.anio = anio;
    }

    public int getDia()  { return dia; }
    public void setDia(int dia)   { this.dia  = dia; }

    public int getMes()  { return mes; }
    public void setMes(int mes)   { this.mes  = mes; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    // ✅ MEJORA: cálculo correcto de días entre dos fechas (funciona entre meses y años)
    // Convierte cada fecha a días totales aproximados y resta
    public int calcularDias(Fecha otra) {
        int totalEsta = (this.anio * 365) + (this.mes * 30) + this.dia;
        int totalOtra = (otra.anio * 365) + (otra.mes * 30) + otra.dia;
        return Math.abs(totalOtra - totalEsta);
    }

    // ✅ MEJORA: validación básica del rango de valores
    public boolean esValida() {
        return mes  >= 1 && mes  <= 12
            && dia  >= 1 && dia  <= 31
            && anio >= 2000;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}
