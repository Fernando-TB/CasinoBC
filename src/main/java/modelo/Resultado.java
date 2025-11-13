package modelo;

public class Resultado {
    private String tipo;
    private boolean acierto;
    private int apuesta;
    private int ganancia;

    public Resultado(String tipo,boolean acierto, int apuesta, int ganancia){
        this.tipo = tipo;
        this.acierto = acierto;
        this.apuesta = apuesta;
        this.ganancia = ganancia;
    }

    public String getTipo() {
        return this.tipo;
    }
    public String getAcierto(){
        if(this.acierto){
            return "acierto";
        }else {
            return "fallo";
        }
    }
    public String getApuesta(){
        return Integer.toString(this.apuesta);
    }
    public String getGanancia(){
        return Integer.toString(this.ganancia);
    }
}
