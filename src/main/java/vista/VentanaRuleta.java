package vista;

import controladores.SessionController;
import modelo.Ruleta;
import modelo.Usuario;
import vista.VentanaJuego;

import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {

    JFrame frame = new JFrame();
    private SessionController session;
    JLabel lblResultado = new JLabel();

    public VentanaRuleta(SessionController session){
        frame.setSize(600, 400);
        JButton btnRojo = new JButton("Rojo");
        JButton btnNegro = new JButton("Negro");
        JButton btnPar = new JButton("Par");
        JButton btnImpar = new JButton("Impar");


        frame.setLayout(new GridLayout(6, 1, 10, 10));

        frame.add(btnRojo);
        frame.add(btnNegro);
        frame.add(btnPar);
        frame.add(btnImpar);
        frame.add(lblResultado);

        Ruleta ruleta = new Ruleta();
        this.session = session;

        btnRojo.addActionListener(e -> jugarR() );
        btnNegro.addActionListener(e -> jugarN() );
        btnPar.addActionListener(e -> jugarP() );
        btnImpar.addActionListener(e -> jugarI());
    }

    public void jugarR(){
        Ruleta ruleta = new Ruleta();
        String resultado = ruleta.jugar(session.getUsuario(),'R');
        lblResultado.setText(resultado + " saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void jugarN(){
        Ruleta ruleta = new Ruleta();
        String resultado = ruleta.jugar(session.getUsuario(),'N');
        lblResultado.setText(resultado + " saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void jugarP(){
        Ruleta ruleta = new Ruleta();
        String resultado = ruleta.jugar(session.getUsuario(),'P');
        lblResultado.setText(resultado + " saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void jugarI(){
        Ruleta ruleta = new Ruleta();
        String resultado = ruleta.jugar(session.getUsuario(),'I');
        lblResultado.setText(resultado + " saldo: " + session.getUsuario().getGananciaTotal());
    }

    public void mostrarRuleta(){
        frame.setVisible(true);
    }
}
