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

    // notice that calling $run() triggers a modification
    // of the initial environment
    public void $run() {
        String id = var.toString();
        Env env = Program.env;
        Val val = exp.eval(env);
        Binding b = env.lookup(id);
        Ref ref = new ValRef(val);
        if (b != null)
            b.ref = ref;
        else
            env.add(new Binding(id,ref));
        // System.out.println(id);
    }

//Define//
}
