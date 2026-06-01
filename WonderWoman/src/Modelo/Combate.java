package Modelo;

public class Combate {
    private WonderWoman heroina;
    private Enemigo enemigo;
    private int numRonda;

    public Combate() {
        this.numRonda = 1;
    }

    public Combate(WonderWoman heroina, Enemigo enemigo) {
        this(); 
        this.heroina = heroina;
        this.enemigo = enemigo;
    }

    public WonderWoman getHeroina() {
        return heroina;
    }

    public void setHeroina(WonderWoman heroina) {
        this.heroina = heroina;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public int getNumRonda() {
        return numRonda;
    }

    public String atacar() {
        int danio = heroina.getAtaque();
        enemigo.recibirDanio(danio);
        return heroina.getNombre() + " ataca a " + enemigo.getNombre()
                + " causando " + danio + " de daño.";
    }

    public String contraatacar() {
        int danio = enemigo.getAtaque();
        heroina.recibirDanio(danio);
        return enemigo.getNombre() + " contraataca causando " + danio
                + " de daño a " + heroina.getNombre() + ".";
    }

    public boolean haTerminado() {
        return !heroina.estaViva() || !enemigo.estaVivo();
    }

    public boolean ganoCombate() {
        return !enemigo.estaVivo() && heroina.estaViva();
    }

    public void siguienteRonda() {
        numRonda++;
    }
}
