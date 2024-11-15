import java.util.*;

public abstract class TypeEnv {

    public static TypeEnv initTypeEnv() {
        // an environment with an empty local environment
        return new TypeEnvNode(new TypeBindings(), new TypeEnvNull());
    }

    public Type applyTypeEnv(String sym) {
        throw new PLCCException("Type error", "no type binding for " + sym);
    }

    public void add(TypeBinding b) {
        throw new PLCCException("Type error", "no type bindings to add to");
    }

    public TypeEnv extendTypeEnv(TypeBindings bindings) {
        return new TypeEnvNode(bindings, this);
    }

    public abstract String toString(int n);

}