package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaJuego {

    JFrame frame = new JFrame();
    private char tipo;


    public VentanaJuego(char tipo) {
        frame.setSize(600, 400);
        JLabel lblResultado = new JLabel();

        frame.setLayout(new GridLayout(6, 1, 10, 10));

        this.tipo = tipo;

    }



}
