package modelo;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private final int MAX_HISTORIAL = 100;
    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int historialSize = 0;
    private int gananciaTotal;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;

    }

    // Verifica si las credenciales coinciden
    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    public String getNombre() {
        return this.nombre;
    }
    public int[] getHistorialNumeros(){
        return this.historialNumeros;
    }
    public int[] getHistorialApuestas(){
        return this.historialApuestas;
    }
    public boolean[] getHistorialAciertos(){
        return this.historialAciertos;
    }
    public int getHistorialSize(){
        return this.historialSize;
    }
    public int getGananciaTotal(){
        return this.gananciaTotal;
    }
    public void setHistorialSize(int size){
        this.historialSize = size;
    }
    public void setGananciaTotal(int ganancia){
        this.gananciaTotal = ganancia;
    }

}

