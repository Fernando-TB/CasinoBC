package modelo;

public class ApuestaImpar extends ApuestaBase {

    public ApuestaImpar() {
        super(0);
    }

    @Override
    public boolean acierta(int numero, char color) {
        return numero % 2 == 1;
    }
}
