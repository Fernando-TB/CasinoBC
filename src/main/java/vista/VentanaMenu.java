package vista;

import controladores.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    private final JFrame frame = new JFrame("Menu - Black Cat");
    private SessionController session;

    public VentanaMenu(String usuario, SessionController session){
        frame.setSize(600, 400);
        JLabel lblHola = new JLabel("Bienvenido " + usuario + ".");
        JButton btnRuleta = new JButton("Ruleta");
        JButton btnVolver = new JButton("Volver");

        frame.setLayout(new GridLayout(3, 1, 10, 10));

        this.session = session;

        frame.add(lblHola);
        frame.add(btnRuleta);
        frame.add(btnVolver);
        btnRuleta.addActionListener(e ->jugarRuleta() );
        btnVolver.addActionListener(e -> volver());


    }

    public void mostrarMenu(){
        frame.setVisible(true);
    }

    public void volver(){
        frame.setVisible(false);
        VentanaLogin ventana = new VentanaLogin();
        ventana.mostrarVentana();
    }

    public void jugarRuleta(){
        frame.setVisible(false);
        VentanaRuleta ruleta = new VentanaRuleta(session);
        ruleta.mostrarRuleta();
    }
}

