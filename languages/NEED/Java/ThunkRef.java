public class ThunkRef extends Ref {

    public Exp exp;
    public Env env;
    public Val val;

    public ThunkRef(Exp exp, Env env) {
        this.exp = exp;
        this.env = env;
        this.val = null; // memoized
    }

    // implements call-by-need:
    // evaluate the expression, if needed, and memoize the result
    public Val deRef() {
        if (val == null)
            val = exp.eval(env);
        return val;
    }

    public Val setRef(Val v) {
        throw new PLCCException("cannot modify a read-only expression");
    }

    public String toString() {
        return "thunk";
    }

}