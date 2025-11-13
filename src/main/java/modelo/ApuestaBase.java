package modelo;

public abstract class ApuestaBase {

    private int monto = 0;

    public ApuestaBase(int monto){
        this.monto = monto;
    }

    public int getMonto() {
        return this.monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public abstract boolean acierta(int numero, char color);
}
