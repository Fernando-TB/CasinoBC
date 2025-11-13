package vista;

import controladores.SessionController;
import modelo.Ruleta;
import modelo.Usuario;


import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {

    JFrame frame = new JFrame();
    private SessionController session;
    JLabel lblResultado = new JLabel();
    JLabel lblSaldo = new JLabel();
    JTextField txtApuesta = new JTextField();

    public VentanaRuleta(SessionController session){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        JButton btnRojo = new JButton("Rojo");
        JButton btnNegro = new JButton("Negro");
        JButton btnPar = new JButton("Par");
        JButton btnImpar = new JButton("Impar");
        JButton btnVolver = new JButton("Volver");

        frame.setLayout(new GridLayout(8, 1, 10, 10));

        frame.add(btnRojo);
        frame.add(btnNegro);
        frame.add(btnPar);
        frame.add(btnImpar);
        frame.add(txtApuesta);
        frame.add(lblResultado);
        frame.add(lblSaldo);
        lblSaldo.setText(" saldo: " + session.getUsuario().getGananciaTotal());
        frame.add(btnVolver);

        this.session = session;

        btnRojo.addActionListener(e -> jugarR());
        btnNegro.addActionListener(e -> jugarN());
        btnPar.addActionListener(e -> jugarP());
        btnImpar.addActionListener(e -> jugarI());
        btnVolver.addActionListener(e -> volver());
    }


    public void volver(){
        frame.setVisible(false);
        VentanaMenu ventana = new VentanaMenu(this.session.getUsuario().getNombre(),this.session);
        ventana.mostrarMenu();
    }

    public void jugarR(){
        Ruleta ruleta = new Ruleta();
        int apuesta = Integer.parseInt(txtApuesta.getText());
        String resultado = ruleta.jugar(session.getUsuario(),'R',apuesta);
        lblResultado.setText(resultado);
        lblSaldo.setText("saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void jugarN(){
        Ruleta ruleta = new Ruleta();
        int apuesta = Integer.parseInt(txtApuesta.getText());
        String resultado = ruleta.jugar(session.getUsuario(),'N',apuesta);
        lblResultado.setText(resultado);
        lblSaldo.setText("saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void jugarP(){
        Ruleta ruleta = new Ruleta();
        int apuesta = Integer.parseInt(txtApuesta.getText());
        String resultado = ruleta.jugar(session.getUsuario(),'P',apuesta);
        lblResultado.setText(resultado);
        lblSaldo.setText("saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void jugarI(){
        Ruleta ruleta = new Ruleta();
        int apuesta = Integer.parseInt(txtApuesta.getText());
        String resultado = ruleta.jugar(session.getUsuario(),'I',apuesta);
        lblResultado.setText(resultado);
        lblSaldo.setText("saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void mostrarRuleta(){
        frame.setVisible(true);
    }
}
