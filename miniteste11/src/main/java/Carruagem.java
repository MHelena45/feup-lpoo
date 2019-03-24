public class Carruagem extends Comboio{
    private int numLugares;
    protected ServicoABordo servicoABordo;

    public Carruagem(int lugares) {
        super("");
        this.numLugares = lugares;
    }
    public Carruagem(String nome) {
        super(nome);

    }

    public int getNumLugares() {
        return numLugares;
    }

    public void setNumLugares(int numLugares) {
        this.numLugares = numLugares;
    }

    public boolean equals(Object obj){
        return (numLugares == ((Carruagem)obj).getNumLugares());
    }

    public static class TGV extends Comboio {
        public TGV(String nome) {
            super(nome);
            this.servicoABordo = new ServicoPrioritario();
        }
        @Override
        public String toString(){
            return "Carruagem.TGV " + getNome() + ", "+ getNumLugares() +" carruagem, "+ getNumLugares() + " lugar, "
                    + getNumPassageiros() + " passageiros";
        }
    }
}
