package vista;

import controladores.SessionController;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VentanaRegistro {
    private final JFrame frame = new JFrame("Registro - Black Cat");
    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblPass = new JLabel("Contraseña:");
    private final JPasswordField txtPass = new JPasswordField();
    private final JButton btnRegistrarse = new JButton("Registrarse");


    public VentanaRegistro(){
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));


        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(new JPanel());
        frame.add(btnRegistrarse);
        frame.add(new JPanel());

        btnRegistrarse.addActionListener(e -> registrar());
    }

    public void registrar(){

        String nombre = txtNombre.getText();
        String user = txtUsuario.getText();
        String contra = Arrays.toString(txtPass.getPassword());

        frame.setVisible(false);
        Usuario usuario = new Usuario(user,contra,nombre);
        controladores.SessionController session = new SessionController(usuario);
        VentanaMenu menu = new VentanaMenu(nombre,session);
        menu.mostrarMenu();

    }



    public void mostrarVentana(){
        frame.setVisible(true);
    }
}
