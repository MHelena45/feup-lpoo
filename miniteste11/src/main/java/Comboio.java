import java.util.ArrayList;

public class Comboio {
    private String nome;
    private int numLugares, numCarruagens, numPassageiros;
    public ArrayList<Carruagem> carruagems = new ArrayList<>();
    protected ServicoABordo servicoABordo;

    Comboio(String nome){
        this.nome = nome;
        this.servicoABordo = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public int getNumCarruagens() {
        return numCarruagens;
    }

    public void setNumCarruagens(int numCarruagens) {
        this.numCarruagens = numCarruagens;
    }

    public void addCarruagem(Carruagem a1) {
        numLugares += a1.getNumLugares();
        numCarruagens++;
        carruagems.add(a1);
    }

    public Carruagem getCarruagemByOrder(int i) {
       return carruagems.get(i);
    }

    public void removeAllCarruagens(int i) {
        for(int j = 0;  j < carruagems.size(); j++){
            if(carruagems.get(j).getNumLugares() == i){
                numLugares -= carruagems.get(j).getNumLugares();
                numCarruagens--;
                carruagems.remove(j);
            }
        }
    }


    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public int getLugaresLivres() {
        return (numLugares - numPassageiros);
    }

    public void addPassageiros(int i) throws PassengerCapacityExceeded{
        if(i > getLugaresLivres() )
            throw new PassengerCapacityExceeded();
        numPassageiros += i;
    }

    public void removePassageiros(int i) {
        numPassageiros--;
    }
    public void removePassageiros() {
        numPassageiros = 0;
    }

    @Override
    public String toString(){
        return "Comboio " + nome +", "+ numCarruagens + " carruagens, " + numLugares + " lugares, "+
                numPassageiros +" passageiros";
    }

    public boolean equals(Object obj){
        if(this.carruagems.size() > ((Comboio)obj).carruagems.size() ||  this.carruagems.size() < ((Comboio)obj).carruagems.size())
            return false;
        for(int i = 0; i < this.carruagems.size();i ++){
            if(!(this.carruagems.get(i).equals(((Comboio)obj).carruagems.get(i)))){
                return false;
            }
        }
        return true;
    }


   public String getDescricaoServico() {
        return servicoABordo.getDescricaoServico();
    }



    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }
}
