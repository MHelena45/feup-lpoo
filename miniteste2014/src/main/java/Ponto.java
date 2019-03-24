public class Ponto extends Figura implements Comparable{
    private int X, Y;
    Ponto(int X, int Y){
        super(X*Y);
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public String toString(){
        return "("+ X + ", " + Y + ")";
    }
    public boolean equals(Object obj){
        return(X == ((Ponto)obj).getX() && Y ==  ((Ponto)obj).getY());
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o))
            return 0;
        return 1;
    }
}
