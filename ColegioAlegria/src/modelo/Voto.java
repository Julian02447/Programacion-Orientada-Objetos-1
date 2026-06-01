package modelo;

import java.util.HashMap;
import java.util.Map;

public class Voto {
    private HashMap<String, Integer> votosP;
    private HashMap<String, Integer> votosR;
    private int votosNulos    = 0;
    private int votosEnBlanco = 0;

    public Voto() {
        votosP = new HashMap<>();
        votosR = new HashMap<>();
    }

    public void votarP(String nombre) {
        votosP.merge(nombre, 1, Integer::sum);
    }

    public void votarR(String nombre) {
        votosR.merge(nombre, 1, Integer::sum);
    }

    public void registrarNulo()    { votosNulos++; }
    public void registrarEnBlanco() { votosEnBlanco++; }

    public int getPoblacionElectoral() {
        int totalP = votosP.values().stream().mapToInt(Integer::intValue).sum();
        int totalR = votosR.values().stream().mapToInt(Integer::intValue).sum();
        return totalP + totalR + votosNulos + votosEnBlanco;
    }

    public int getVotosNulos()    { return votosNulos; }
    public int getVotosEnBlanco() { return votosEnBlanco; }

    public void reiniciar() {
        votosP.replaceAll((k, v) -> 0);
        votosR.replaceAll((k, v) -> 0);
        votosNulos    = 0;
        votosEnBlanco = 0;
    }

    public HashMap<String, Integer> getVotosP() { return votosP; }
    public HashMap<String, Integer> getVotosR() { return votosR; }
}
