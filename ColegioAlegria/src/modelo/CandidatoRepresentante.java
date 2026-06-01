package modelo;

public class CandidatoRepresentante extends Candidato {
    private Formula formula;

    public CandidatoRepresentante() {}

    public CandidatoRepresentante(Formula formula, String nombre, String apellido,
    int grado, String curso, String lema, String numTarjeton) {
        super(nombre, apellido, grado, curso, lema, numTarjeton);
        this.formula = formula;
    }

    public Formula getFormula()          { return formula; }
    public void    setFormula(Formula f) { this.formula = f; }

    @Override
    public String toString() {
        return getNombre() + " " + getGrado() + getCurso() + " - " + formula.getNombre();
    }
}
