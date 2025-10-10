package vista;

import controladores.SessionController;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

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
    }

    private String validarCredenciales(String u, String p) {

        for (Usuario usuario : USUARIOS){
            if(usuario.validarCredenciales(u,p)){
                return usuario.getNombre();
            }
        }
        return null;
    }

    private Usuario usuarioIniciado(String u, String p) {

        for (Usuario usuario : USUARIOS) {
            if (usuario.validarCredenciales(u, p)) {
                return usuario;
            }
        }
        return null;
    }

    void abrirRegistro() {
        frame.setVisible(false);
        VentanaRegistro registro = new VentanaRegistro();
        registro.mostrarVentana();

    }
}
