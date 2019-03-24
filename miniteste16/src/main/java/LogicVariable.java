public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calculatedBy;

    LogicVariable(String name, boolean value){
        super();
        this.name = name;
        this.value = value;
    }
    LogicVariable(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        if(calculatedBy == null )
           return value;
        return calculatedBy.getValue();
    }

    public void setValue(boolean value) {
        this.value = value;
    }
    public boolean equals(Object obj){
        return (name.equals(((LogicVariable)obj).getName()));
    }

    public String getFormula() {
        if(calculatedBy == null)
            return name;
        return calculatedBy.getFormula();
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
    }
}
