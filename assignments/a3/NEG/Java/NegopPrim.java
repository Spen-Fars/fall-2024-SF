//NegopPrim:top//
//NegopPrim:import//
import java.util.*;

// <prim>:NegopPrim ::= NEGOP
public class NegopPrim extends Prim /*NegopPrim:class*/ {

    public static final String $className = "NegopPrim";
    public static final String $ruleString =
        "<prim>:NegopPrim ::= NEGOP";



    public NegopPrim() {
//NegopPrim:init//

    }

    public static NegopPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:NegopPrim", scn$.lno);
        scn$.match(Token.Match.NEGOP, trace$);
        return new NegopPrim();
    }

    public String toString() {
    		return "neg";
    }
    
    public Val apply(Val [] va) {
    		if (va.length != 1)
    			throw new PLCCException("one argument expected");
    		int i0 = va[0].intVal().val;
    		return new IntVal(i0 * -1);
    }

//NegopPrim//
}
