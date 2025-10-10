package vista;

import controladores.SessionController;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la ventana de Login del Casino Black Cat.
 * Permite ingresar credenciales para acceder al sistema.
 */
public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    private static final List<Usuario> USUARIOS = new ArrayList<>();
    // --- UI ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistrarse = new JButton("Registrarse");

    private SessionController session;
    /**
     * Constructor que inicializa la ventana de login.
     * Configura el tamaño, los componentes y los eventos.
     */
    public VentanaLogin() {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(new JPanel());
        frame.add(btnIngresar);
        frame.add(new JPanel());
        frame.add(btnRegistrarse);
        frame.add(new JPanel());

        btnIngresar.addActionListener(e -> login());
        btnRegistrarse.addActionListener(e -> abrirRegistro());


        USUARIOS.add(new Usuario("ftgrim","mish","Fernando"));

// TODO: inicializar usuarios hardcodeados
// TODO: inicializar y configurar la ventana
    }

    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
    public void mostrarVentana() {
        frame.setVisible(true);
// TODO: mostrar ventana
    }
    /**
     * Maneja el evento de login al presionar el botón.
     * Debe validar credenciales y abrir la siguiente ventana o mostrar error.
     */
    private void login() {
        String user = txtUsuario.getText();
        String pass = new String(txtClave.getPassword());

        String nombre = validarCredenciales(user, pass);

        if (nombre != null){
            frame.setVisible(false);
            Usuario usuario = usuarioIniciado(user,pass);
            this.session = new SessionController(usuario);
            VentanaMenu menu = new VentanaMenu(nombre,session);
            menu.mostrarMenu();
        }else {
            JFrame error = new JFrame("Error");
            JLabel err = new JLabel("Error, credenciales incorrectas");
            error.add(err);
            error.setSize(600, 400);
            error.setVisible(true);
        }

// TODO: implementar lógica de login
    }
    /**
     * Valida las credenciales del usuario contra el arreglo hardcoded.
     *
     * @param u nombre de usuario ingresado
     * @param p clave ingresada
     * @return el nombre del usuario si es válido, o cadena vacía si no coincide
     */
    private String validarCredenciales(String u, String p) {

        for (Usuario usuario : USUARIOS){
            if(usuario.validarCredenciales(u,p)){
                return usuario.getNombre();
            }
        }
        return null;
// TODO: recorrer arreglo y validar credenciales
    }

    private Usuario usuarioIniciado(String u, String p) {

        for (Usuario usuario : USUARIOS) {
            if (usuario.validarCredenciales(u, p)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Abre la ventana de registro para crear un nuevo usuario.
     * Debe cerrar la ventana actual e invocar a VentanaRegistro.
     */
    void abrirRegistro() {
        frame.setVisible(false);
        VentanaRegistro registro = new VentanaRegistro();
        registro.mostrarVentana();

// TODO: abrir ventana de registro y cerrar login
    }
}
