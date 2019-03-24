public class Countable extends Figura {
    protected int count;
    public Countable(Figura[] figuras) {
        super(0);
        double soma = 0;
        for(Figura fig: figuras){
            count++;
            soma += fig.getArea();
        }
        setArea(soma);
    }


    public int count() {
        return count;
    }
}
