package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int gananciaTotal;
    private List<Resultado> resultados = new ArrayList<>();
    private int victorias = 0;

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

    public void agregarResultado(Resultado resultado){
        this.resultados.add(resultado);
    }

    public List<Resultado> getResultados() {
        return this.resultados;
    }

    public int getGananciaTotal(){
        return this.gananciaTotal;
    }
    public void setGananciaTotal(int ganancia){
        this.gananciaTotal = ganancia;
    }


    public void addVictoria(){
        this.victorias += 1;
    }

    public int getVictorias(){
        return this.victorias;
    }

}

