public class Circulo extends Figura {
    private int raio;
    private Ponto centro;

    Circulo(Ponto centro, int raio) throws IllegalArgumentException {
        super(Math.PI * raio * raio);
        perimetro = (2 * Math.PI * raio);
        this.raio = raio;
        this.centro = centro;
        if(raio <= 0)
            throw new IllegalArgumentException();
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public Ponto getCentro() {
        return centro;
    }

    public void setCentro(Ponto centro) {
        this.centro = centro;
    }

}
