//LEPrim:top//
//LEPrim:import//
import java.util.*;

// <prim>:LEPrim ::= LEP
public class LEPrim extends Prim /*LEPrim:class*/ {

    public static final String $className = "LEPrim";
    public static final String $ruleString =
        "<prim>:LEPrim ::= LEP";



    public LEPrim() {
//LEPrim:init//

    }

    public static LEPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:LEPrim", scn$.lno);
        scn$.match(Token.Match.LEP, trace$);
        return new LEPrim();
    }

    public String toString() {
        return "<=?";
    }
    
    public Val apply(Val [] va) {
    	if (va.length != 2)
    	throw new PLCCException("two arguments expected");
        int i0 = va[0].intVal().val;
        int i1 = va[1].intVal().val;
        return new BoolVal(i0 <= i1);
    }

//LEPrim//
}
