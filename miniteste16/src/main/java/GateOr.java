public class GateOr extends LogicGate{
    GateOr(LogicVariable output, LogicVariable input, LogicVariable input1) throws ColisionException{
        super(output,input,input1);
        this.symbol = "OR";
        if(output.getCalculatedBy() != null)
            throw new ColisionException();
        output.setCalculatedBy(this);
        output.setValue(input.getValue() && input.getValue());
    }

    @Override
    public String getFormula() {
        return "OR("+ inputs[0].getFormula() + "," + inputs[1].getFormula()+ ")";
    }
    @Override
    public boolean getValue(){
        return ( inputs[0].getValue() || inputs[1].getValue());
    }
}
