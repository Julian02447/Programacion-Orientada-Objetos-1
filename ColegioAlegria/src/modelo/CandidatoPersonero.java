package modelo;

public class CandidatoPersonero extends Candidato {
    private Mascota mascota;

    public CandidatoPersonero() {}

    public CandidatoPersonero(Mascota mascota, String nombre, String apellido,
    int grado, String curso, String lema, String numTarjeton) {
        super(nombre, apellido, grado, curso, lema, numTarjeton);
        this.mascota = mascota;
    }

    public Mascota getMascota()          { return mascota; }
    public void    setMascota(Mascota m) { this.mascota = m; }

    @Override
    public String toString() {
        return getNombre() + " - " + mascota.getNombre();
    }
}
