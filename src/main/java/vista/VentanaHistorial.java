package vista;

import controladores.SessionController;
import modelo.Resultado;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial {

    private final JFrame frame = new JFrame("Menu - Black Cat");
    private SessionController session;

    public VentanaHistorial(SessionController session){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(3, 1, 5, 5));

        this.session = session;

        JLabel lblhistorial = new JLabel("Historial",0);
        JButton btnVolver = new JButton("Volver");

        JPanel panel = resultados();

        JScrollPane scrlresultados = new JScrollPane(panel);

        frame.add(lblhistorial);
        frame.add(scrlresultados);
        frame.add(btnVolver);

        btnVolver.addActionListener(e -> volver());

    }

    public JPanel resultados(){

        JPanel resultados = new JPanel();
        resultados.setLayout(new GridLayout(0,4));
        JLabel lbltipo = new JLabel("Tipo");
        JLabel lblacierto = new JLabel("Acierto");
        JLabel lblapuesta = new JLabel("Apuesta");
        JLabel lblganancia = new JLabel("Ganancia");
        resultados.add(lbltipo);
        resultados.add(lblacierto);
        resultados.add(lblapuesta);
        resultados.add(lblganancia);

        for(Resultado resultado : this.session.getUsuario().getResultados()){
            JLabel tipo = new JLabel(resultado.getTipo());
            JLabel acierto = new JLabel(resultado.getAcierto());
            JLabel apuesta = new JLabel(resultado.getApuesta());
            JLabel ganancia = new JLabel(resultado.getGanancia());
            resultados.add(tipo);
            resultados.add(acierto);
            resultados.add(apuesta);
            resultados.add(ganancia);
        }

        return resultados;

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
