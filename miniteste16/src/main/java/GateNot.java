public class GateNot extends LogicGate {
    public GateNot(LogicVariable output, LogicVariable input) throws ColisionException,CycleException {
        super(output, input);
        this.symbol = "NOT";
        if(input.getCalculatedBy().getInputs()[0] == output || input.getCalculatedBy().getInputs()[1] == output)
            throw new CycleException();

        if(output.getCalculatedBy() != null)
            throw new ColisionException();
        output.setCalculatedBy(this);

        output.setValue(!input.getValue());
    }

    @Override
    public String getFormula() {
        return "NOT(" + inputs[0].getFormula() + ")";
    }
    @Override
    public boolean getValue(){
        return ( !inputs[0].getValue());
    }
}
