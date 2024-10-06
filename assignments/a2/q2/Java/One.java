//One:top//
//One:import//
import java.util.*;

// <bit>:One ::= ONE
public class One extends Bit /*One:class*/ {

    public static final String $className = "One";
    public static final String $ruleString =
        "<bit>:One ::= ONE";



    public One() {
//One:init//

    }

    public static One parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<bit>:One", scn$.lno);
        scn$.match(Token.Match.ONE, trace$);
        return new One();
    }

    public int eval() {
        return 1;
    }

//One//
}
