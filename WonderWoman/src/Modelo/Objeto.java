package Modelo;

public class Objeto {
    private String nombre;
    private TipoObjeto tipo;
    private String efecto;
    private int bonusAtaque;

    public Objeto() {
    }

    public Objeto(String nombre, TipoObjeto tipo, String efecto, int bonusAtaque) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.efecto = efecto;
        this.bonusAtaque = bonusAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoObjeto getTipo() {
        return tipo;
    }

    public void setTipo(TipoObjeto tipo) {
        this.tipo = tipo;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }
}
