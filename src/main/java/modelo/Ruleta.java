package modelo;

import java.util.Random;

public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static final int CERO = 0;
    private static Random rng = new Random();
    private static int[] numerosRojos =
            {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

    public static int girarRuleta() {
        return rng.nextInt(37);
    }

    public static boolean evaluarResultado(int numero, char tipo) {
        return switch (tipo) {
            case 'R' -> esRojo(numero);
            case 'N' -> !esRojo(numero);
            case 'P' -> numero % 2 == 0;
            case 'I' -> numero % 2 == 1;
            default -> false;

        };
    }

    private static boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (n == rojo) return true;
        }
        return false;
    }

    public String jugar(Usuario usuario,char tipo){
        int numero = girarRuleta();
        boolean resultado = evaluarResultado(numero,tipo);
        this.registrarResultado(usuario,numero,5,resultado);

        if (resultado){
            return "acierto";
        }else {
            return "fallo";
        }
    }

    public void registrarResultado(Usuario usuario, int numero, int apuesta, boolean acierto) {
        if (usuario.getHistorialSize() < MAX_HISTORIAL) {
            int size = usuario.getHistorialSize();
            usuario.getHistorialNumeros()[size] = numero;
            usuario.getHistorialApuestas()[size] = apuesta;
            usuario.getHistorialAciertos()[size] = acierto;
            usuario.setHistorialSize(size + 1);

            if (acierto) {
                usuario.setGananciaTotal(usuario.getGananciaTotal() + (apuesta * 2));
            } else {
                usuario.setGananciaTotal(usuario.getGananciaTotal() - apuesta);
            }
        }
    }
}