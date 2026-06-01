package Modelo;

public class Duelo {

    private Personaje jugador;  
    private Personaje oponente; 
    private int numRonda;

    public Duelo() {
        this.numRonda = 1;
    }

    public Duelo(Personaje jugador, Personaje oponente) {
        this(); 
        this.jugador = jugador;
        this.oponente = oponente;
    }

    public Personaje getJugador() { return jugador; }
    public void setJugador(Personaje jugador) { this.jugador = jugador; }

    public Personaje getOponente() { return oponente; }
    public void setOponente(Personaje oponente) { this.oponente = oponente; }

    public int getNumRonda() { return numRonda; }

    public String atacar(Hechizo hechizo) {
        int danio = hechizo.getPoder() + (jugador.getNivelMagia() / 2);
        oponente.recibirDanio(danio);
        return jugador.getNombre() + " lanza '" + hechizo.getNombre()
                + "' causando " + danio + " de daño a " + oponente.getNombre() + ".";
    }

    public String contraatacar() {
        int danio = oponente.getNivelMagia() / 3;
        jugador.recibirDanio(danio);
        return oponente.getNombre() + " contraataca causando "
                + danio + " de daño a " + jugador.getNombre() + ".";
    }

    public boolean haTerminado() {
        return !jugador.estaVivo() || !oponente.estaVivo();
    }

    public boolean ganoDuelo() {
        return !oponente.estaVivo() && jugador.estaVivo();
    }

    public void siguienteRonda() {
        numRonda++;
    }
}
