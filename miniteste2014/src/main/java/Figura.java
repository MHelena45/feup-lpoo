public abstract class Figura { ;
    protected double area, perimetro;
    Figura(double area){
        this.area= area;
    }

    public double getArea(){
        return area;
    }

    public void setArea(double area){
        this.area = area;
    }
    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
}
