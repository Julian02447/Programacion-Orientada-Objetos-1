package modelo;

public class Reserva {

    private Propietario propietario;
    private Mascota mascota;
    private Cuidador cuidador;
    private Fecha fecha;
    private int duracionHoras;
    private Servicio servicio;

    public Reserva(Propietario propietario,Mascota mascota,Cuidador cuidador,Fecha fecha,int duracionHoras,
    Servicio servicio) {
        this.propietario = propietario;
        this.mascota = mascota;
        this.cuidador = cuidador;
        this.fecha = fecha;
        this.duracionHoras = duracionHoras;
        this.servicio = servicio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {

        return "Reserva{" +
                "propietario=" + propietario.getNombre() +
                ", mascota=" + mascota.getNombre() +
                ", cuidador=" + cuidador.getNombre() +
                ", fecha=" + fecha +
                ", duracionHoras=" + duracionHoras +
                ", servicio=" + servicio +
                '}';
    }
}