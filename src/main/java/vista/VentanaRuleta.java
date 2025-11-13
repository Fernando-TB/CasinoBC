package vista;

import controladores.SessionController;
import modelo.*;


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

        ApuestaRojo r = new ApuestaRojo();
        ApuestaNegro n = new ApuestaNegro();
        ApuestaPar p = new ApuestaPar();
        ApuestaImpar i = new ApuestaImpar();

        btnRojo.addActionListener(e -> jugar(r));
        btnNegro.addActionListener(e -> jugar(n));
        btnPar.addActionListener(e -> jugar(p));
        btnImpar.addActionListener(e -> jugar(i));
        btnVolver.addActionListener(e -> volver());
    }


    public void volver(){
        frame.setVisible(false);
        VentanaMenu ventana = new VentanaMenu(this.session.getUsuario().getNombre(),this.session);
        ventana.mostrarMenu();
    }

    public void jugar(ApuestaBase apuesta){
        Ruleta ruleta = new Ruleta();
        int monto = Integer.parseInt(txtApuesta.getText());
        apuesta.setMonto(monto);
        String resultado = ruleta.jugar(session.getUsuario(),apuesta);
        lblResultado.setText(resultado);
        lblSaldo.setText("saldo: " + session.getUsuario().getGananciaTotal());

        ArchivoUsuarios arch = new ArchivoUsuarios();

        arch.agregarUsuario(session.getUsuario());

    }


    public void mostrarRuleta(){
        frame.setVisible(true);
    }
}
