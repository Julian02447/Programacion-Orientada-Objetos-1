package Modelo;

public class Casa extends ObjetoInteractivo {
    private int numero;
    private String propietario;

    public Casa() {
    }

    public Casa(int numero, String propietario) {
        super("Casa #" + numero, "Vivienda de " + propietario + " en la vecindad.");
        this.numero = numero;
        this.propietario = propietario;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getPropietario() { return propietario; }
    public void setPropietario(String propietario) { this.propietario = propietario; }

    @Override
    public String usar() {
        return entrar();
    }

    public String entrar() {
        return propietario + " entra a la Casa #" + numero + ".";
    }

    @Override
    public String toString() {
        return "Casa #" + numero + " — " + propietario;
    }
}
