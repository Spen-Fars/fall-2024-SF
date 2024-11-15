//ErrorPrim:top//
//ErrorPrim:import//
import java.util.*;

// <prim>:ErrorPrim ::= ERROR
public class ErrorPrim extends Prim /*ErrorPrim:class*/ {

    public static final String $className = "ErrorPrim";
    public static final String $ruleString =
        "<prim>:ErrorPrim ::= ERROR";



    public ErrorPrim() {
//ErrorPrim:init//

    }

    public static ErrorPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ErrorPrim", scn$.lno);
        scn$.match(Token.Match.ERROR, trace$);
        return new ErrorPrim();
    }

    public String toString() {
    	return "error";
    }
    
    public Val apply(Val [] va) {
    	throw new PLCCException("user-defined error");
    }

//ErrorPrim//
}
