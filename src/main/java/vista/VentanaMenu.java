package vista;

import controladores.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    private final JFrame frame = new JFrame("Menu - Black Cat");
    private SessionController session;

    public VentanaMenu(String usuario, SessionController session){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        JLabel lblHola = new JLabel("Bienvenido " + usuario + ".");
        JButton btnRuleta = new JButton("Ruleta");
        JButton btnHistorial = new JButton("Historial");
        JButton btnVolver = new JButton("Volver");

        frame.setLayout(new GridLayout(4, 1, 10, 10));

        this.session = session;

        frame.add(lblHola);
        frame.add(btnRuleta);
        frame.add(btnHistorial);
        frame.add(btnVolver);
        btnRuleta.addActionListener(e ->jugarRuleta() );
        btnHistorial.addActionListener(e -> historial());
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


    public void historial(){
        if (session.getUsuario().getResultados() == null){
            JFrame error = new JFrame("Error");
            JLabel err = new JLabel("Historial vacio");
            error.add(err);
            error.setSize(600, 400);
            error.setVisible(true);
        }else {

            frame.setVisible(false);
            VentanaHistorial ventana = new VentanaHistorial(session);
            ventana.mostrarVentana();
        }
    }

    public void jugarRuleta(){
        frame.setVisible(false);
        VentanaRuleta ruleta = new VentanaRuleta(session);
        ruleta.mostrarRuleta();
    }
}

