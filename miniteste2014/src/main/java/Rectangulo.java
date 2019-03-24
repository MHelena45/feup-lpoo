public class Rectangulo extends Figura {

    public Rectangulo(int x1, int y1, int x2, int y2) {
        super((x2 - x1) * (y2-y1));
        perimetro = 2 * (x2 - x1) + 2*(y2-y1);
    }



}
