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

    public Usuario(String username, String password, String nombre,int victorias,int gananciaTotal, List<Resultado> resultados ) {
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

    public String toString() {
        // Guardamos la lista de resultados como una cadena compacta
        StringBuilder sb = new StringBuilder();
        if (resultados != null && !resultados.isEmpty()) {
            for (Resultado r : resultados) {
                sb.append(r.toText()).append("|"); // separador entre resultados
            }
            sb.setLength(sb.length() - 1); // eliminar último "|"
        } else {
            sb.append("sin_resultados");
        }

        return username + ";" + password + ";" + nombre + ";" + victorias + ";" + gananciaTotal + ";" + sb;
    }

    public static Usuario desdeTexto(String linea) {
        String[] partes = linea.split(";");
        if (partes.length < 6) return null;

        String username = partes[0];
        String password = partes[1];
        String nombre = partes[2];
        int victorias = Integer.parseInt(partes[3]);
        int gananciaTotal = Integer.parseInt(partes[4]);

        List<Resultado> resultados = Resultado.desdeTextoLista(partes[5]);
        return new Usuario(username, password, nombre, victorias, gananciaTotal, resultados);
    }
}

