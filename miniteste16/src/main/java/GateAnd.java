public class GateAnd extends LogicGate {
    public GateAnd(LogicVariable output, LogicVariable x1, LogicVariable x2) throws ColisionException {
        super(output, x1, x2);
        this.symbol = "AND";
        if(output.getCalculatedBy() != null)
            throw new ColisionException();
        output.setCalculatedBy(this);
        output.setValue(x1.getValue() && x2.getValue());
    }

    @Override
    public String getFormula() {
        return "AND("+ inputs[0].getFormula() + "," + inputs[1].getFormula()+ ")";
    }

    @Override
    public boolean getValue(){
        return ( inputs[0].getValue() && inputs[1].getValue());
    }
}
