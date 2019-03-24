import java.util.ArrayList;

public class CombinatorialCircuit {
    private LogicVariable variableByName;
    private ArrayList<LogicVariable> logicVariables = new ArrayList<>();
    public boolean addVariable(LogicVariable a) {
        for(LogicVariable logicVariable : logicVariables){
            if(logicVariable.equals(a)){
                return false;
            }
        }
        logicVariables.add(a);
        return true;

    }

    public LogicVariable getVariableByName(String x1) {
        for(LogicVariable logicVariable : logicVariables){
            if(logicVariable.getName().equals(x1)){
                return logicVariable;
            }
        }
        return null;
    }
}
