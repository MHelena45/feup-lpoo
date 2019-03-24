public abstract class LogicGate {
    private LogicVariable output;
    protected LogicVariable[] inputs;
    protected String symbol;
    LogicGate(LogicVariable output, LogicVariable input, LogicVariable input1){
        this.output = output;
        this.inputs= new LogicVariable[]{input, input1};
    }
    LogicGate(LogicVariable output, LogicVariable input){
        this.output = output;
        this.inputs= new LogicVariable[]{input};

    }

    public LogicVariable getOutput() {
        return output;
    }

    public void setOutput(LogicVariable output) {
        this.output = output;
    }

    public LogicVariable[] getInputs() {
        return inputs.clone();
    }

    public void setInputs(LogicVariable[] inputs) {
        this.inputs = inputs;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public abstract String getFormula();

    public abstract boolean getValue();
}
