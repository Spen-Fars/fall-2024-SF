//NEPrim:top//
//NEPrim:import//
import java.util.*;

// <prim>:NEPrim ::= NEP
public class NEPrim extends Prim /*NEPrim:class*/ {

    public static final String $className = "NEPrim";
    public static final String $ruleString =
        "<prim>:NEPrim ::= NEP";



    public NEPrim() {
//NEPrim:init//

    }

    public static NEPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:NEPrim", scn$.lno);
        scn$.match(Token.Match.NEP, trace$);
        return new NEPrim();
    }

    public String toString() {
        return "<>?";
    }
    
    public Val apply(Val [] va) {
    	if (va.length != 2)
    	throw new PLCCException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new BoolVal(i0 != i1);
    }

//NEPrim//
}
