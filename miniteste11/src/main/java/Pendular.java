public class Pendular extends Comboio {
    public Pendular(String alfa_pendular) {
        super(alfa_pendular);
        this.servicoABordo = new ServicoSemEnjoos();
    }
}
