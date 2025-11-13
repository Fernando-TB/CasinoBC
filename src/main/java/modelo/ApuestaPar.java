package modelo;

public class ApuestaPar extends ApuestaBase {

    public ApuestaPar() {
        super(0);
    }

    @Override
    public boolean acierta(int numero, char color) {
        return numero % 2 == 0;
    }
}
