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

        frame.setLayout(new GridLayout(2, 1, 10, 10));

        this.session = session;

        frame.add(lblHola);
        frame.add(btnRuleta);
        btnRuleta.addActionListener(e ->jugarRuleta() );

    }

    public void mostrarMenu(){
        frame.setVisible(true);
    }

    public void jugarRuleta(){
        frame.setVisible(false);
        VentanaRuleta ruleta = new VentanaRuleta(session);
        ruleta.mostrarRuleta();
    }
}

