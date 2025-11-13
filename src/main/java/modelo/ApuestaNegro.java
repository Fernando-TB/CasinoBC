package modelo;

public class ApuestaNegro extends ApuestaBase{

    public ApuestaNegro() {
        super(0);
    }

    @Override
    public boolean acierta(int numero, char color) {
        return color == 'N';
    }

    public char getTipo(){
        return 'N';
    }
}
