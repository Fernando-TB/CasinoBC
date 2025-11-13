package modelo;

public class ApuestaRojo extends ApuestaBase{


    public ApuestaRojo() {
        super(0);
    }

    @Override
    public boolean acierta(int numero, char color) {
        return color == 'R';
    }
}
