import java.util.*;

public abstract class Val {

    public static Val [] toArray(List<Val> valList) {
        int n = valList.size();
        return valList.toArray(new Val[n]);
    }

    public boolean isTrue() {
        throw new PLCCException("boolean expression expected");
    }

    public IntVal intVal() {
        throw new PLCCException(this + ": not an Int");
    }

    public BoolVal boolVal() {
        throw new PLCCException(this + ": not a Bool");
    }

    public Val apply(List<Ref> refList) {
        throw new PLCCException("cannot apply "+this);
    }

}