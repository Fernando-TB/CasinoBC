package modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUsuarios {
    private static final String ARCHIVO = "usuarios.txt";
    private List<Usuario> usuarios;

    public ArchivoUsuarios() {
        usuarios = new ArrayList<>();
        cargar();
    }

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
        guardar();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    private void guardar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Usuario u : usuarios) {
                bw.write(u.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargar() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario u = Usuario.desdeTexto(linea);
                if (u != null) usuarios.add(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
