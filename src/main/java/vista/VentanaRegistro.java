package vista;

import javax.swing.*;
import java.awt.*;

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
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblPass);
        frame.add(txtPass);
        frame.add(new JPanel());
        frame.add(btnRegistrarse);
        frame.add(new JPanel());
    }

    public void mostrarVentana(){
        frame.setVisible(true);
    }
}
