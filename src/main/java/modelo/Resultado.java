package modelo;

import java.util.ArrayList;
import java.util.List;


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

    public String toText() {
        // Separador interno: coma
        return tipo + "," + acierto + "," + apuesta + "," + ganancia;
    }

    public static Resultado desdeTexto(String texto) {
        String[] partes = texto.split(",");
        if (partes.length != 4) return null;
        return new Resultado(
                partes[0],
                Boolean.parseBoolean(partes[1]),
                Integer.parseInt(partes[2]),
                Integer.parseInt(partes[3])
        );
    }

    public static List<Resultado> desdeTextoLista(String texto) {
        List<Resultado> lista = new ArrayList<>();
        if (texto.equals("sin_resultados")) return lista;

        String[] items = texto.split("\\|");
        for (String item : items) {
            Resultado r = desdeTexto(item);
            if (r != null) lista.add(r);
        }
        return lista;
    }

}
