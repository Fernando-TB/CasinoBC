package launcher;

import vista.VentanaLogin;

public class CasinoV2 {
    public static void main(String[] args) {
        menu();
    }
    public static void  menu() {
        VentanaLogin ventana = new VentanaLogin();
        ventana.mostrarVentana();
    }
}
