package vista;

import controladores.SessionController;
import modelo.Resultado;

import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {

    private final JFrame frame = new JFrame("Menu - Black Cat");
    private SessionController session;

    public VentanaEstadisticas(SessionController session){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(5, 1, 5, 5));

        this.session = session;

        int jugadas = this.session.getUsuario().getResultados().size();

        JLabel partidas = new JLabel("Total de partidas: " + jugadas);
        JLabel victorias = new JLabel("Total de victorias: " + this.session.getUsuario().getVictorias());

        double pvictorias = (double) this.session.getUsuario().getVictorias() /jugadas;

        double porcentaje = Math.round(pvictorias * 100.0);

        JLabel percvictorias = new JLabel("Porcentaje de victorias: " + porcentaje + "%");

        JButton btnVolver = new JButton("Volver");

        frame.add(partidas);
        frame.add(victorias);
        frame.add(percvictorias);
        frame.add(btnVolver);

        btnVolver.addActionListener(e -> volver());

    }

    public void volver(){
        frame.setVisible(false);
        VentanaMenu ventana = new VentanaMenu(this.session.getUsuario().getNombre(),this.session);
        ventana.mostrarMenu();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

}
