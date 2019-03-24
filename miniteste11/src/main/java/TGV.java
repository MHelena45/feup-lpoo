public class TGV extends Comboio{
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