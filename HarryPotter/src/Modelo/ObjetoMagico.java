package Modelo;

public class ObjetoMagico {

    private String nombre;
    private TipoObjeto tipo;
    private String efecto;
    private int bonusMagia; 

    public ObjetoMagico() {}

    public ObjetoMagico(String nombre, TipoObjeto tipo, String efecto, int bonusMagia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.efecto = efecto;
        this.bonusMagia = bonusMagia;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoObjeto getTipo() { return tipo; }
    public void setTipo(TipoObjeto tipo) { this.tipo = tipo; }

    public String getEfecto() { return efecto; }
    public void setEfecto(String efecto) { this.efecto = efecto; }

    public int getBonusMagia() { return bonusMagia; }
    public void setBonusMagia(int bonusMagia) { this.bonusMagia = bonusMagia; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }
}
