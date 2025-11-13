package modelo;

import java.util.Random;

public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    private static Random rng = new Random();
    private static int[] numerosRojos =
            {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

    public static int girarRuleta() {
        return rng.nextInt(37);
    }

    private static char esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (n == rojo) return 'R';
        }
        return 'N';
    }

    public String jugar(Usuario usuario, ApuestaBase apuesta){
        int numero = girarRuleta();
        boolean resultado = apuesta.acierta(numero,esRojo(numero));
        this.registrarResultado(usuario,numero,apuesta.getMonto(),resultado,apuesta.getTipo());

        if (resultado){
            return "acierto";
        }else {
            return "fallo";
        }
    }

    public void registrarResultado(Usuario usuario, int numero, int apuesta, boolean acierto,char tipo) {

            if (acierto) {
                usuario.setGananciaTotal(usuario.getGananciaTotal() + (apuesta * 2));
                Resultado result = new Resultado(Character.toString(tipo), true,apuesta,apuesta*2);
                usuario.agregarResultado(result);
                usuario.addVictoria();
            } else {
                usuario.setGananciaTotal(usuario.getGananciaTotal() - apuesta);
                Resultado result = new Resultado(Character.toString(tipo), false,apuesta,-apuesta);
                usuario.agregarResultado(result);
            }
        }
    }