package modelo;

public class Resultado {
    private boolean acierto;
    private int apuesta;
    private int ganancia;

    public Resultado(boolean acierto, int apuesta, int ganancia){
        this.acierto = acierto;
        this.apuesta = apuesta;
        this.ganancia = ganancia;
    }

    public boolean getAcierto(){
        return this.acierto;
    }
    public int getApuesta(){
        return this.apuesta;
    }
    public int getGanancia(){
        return this.ganancia;
    }
}
