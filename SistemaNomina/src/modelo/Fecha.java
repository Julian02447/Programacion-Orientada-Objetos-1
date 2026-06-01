package modelo;

public class Fecha {

    private int dia;
    private int mes;
    private int anios;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int anios) {
        this.dia = dia;
        this.mes = mes;
        this.anios = anios;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anios;
    }
}