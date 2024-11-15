//Define:top//
//Define:import//
import java.util.*;

// <program>:Define ::= DEFINE <VAR> EQUALS <exp>
public class Define extends Program /*Define:class*/ {

    public static final String $className = "Define";
    public static final String $ruleString =
        "<program>:Define ::= DEFINE <VAR> EQUALS <exp>";

    public Token var;
    public Exp exp;

    public Define(Token var, Exp exp) {
//Define:init//
        this.var = var;
        this.exp = exp;
    }

    public static Define parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<program>:Define", scn$.lno);
        scn$.match(Token.Match.DEFINE, trace$);
        Token var = scn$.match(Token.Match.VAR, trace$);
        scn$.match(Token.Match.EQUALS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Define(var, exp);
    }

    // calling $run() triggers a modification
    // of the top-level type and value environments
    public void $run() {
        Env env = Program.env;       // top-level environment
        TypeEnv tenv = Program.tenv; // top-level type environment
        Type rhsExpType; // RHS expression type
        Val  rhsExpVal; // RHS expression value
        Type lhsVarType; // LHS variable declared type
        Val  lhsVarVal; // LHS variable's current value
        String sym = var.toString(); // the LHS symbol
        try {
            // look up the LHS variable in the top-level type environment
            lhsVarType = tenv.applyTypeEnv(sym);
        } catch (PLCCException e) {
            // no type binding -- must be a new variable definition
            rhsExpType = exp.evalType(tenv);
            tenv.add(new TypeBinding(sym, rhsExpType));        // type binding
            rhsExpVal = exp.eval(env);
            env.add(new Binding(sym, new ValRef(rhsExpVal))); // value binding
            System.out.println(sym + ":" + rhsExpType);
            return;
        }
        // the variable has a declared type, lhsVarType -- see if it needs a def'n
        try {
            // look up the value of variable in the top-level environment
            lhsVarVal = env.applyEnv(sym);
        } catch (PLCCException e) {
            // the variable has a declared type, but no value bound to it
            rhsExpType = exp.evalType(tenv);
            // the declared and defined types must be the same
            Type.checkEquals(lhsVarType, rhsExpType);
            // get the expression value
            rhsExpVal = exp.eval(env);
            // and bind it to the variable
            env.add(new Binding(sym, new ValRef(rhsExpVal)));
            System.out.println(sym + ":" + rhsExpType);
            return;
        }
        // the variable has a value, too -- can't redefine it!
        throw new PLCCException(sym + ": duplicate variable definition");
    }

//Define//
}
