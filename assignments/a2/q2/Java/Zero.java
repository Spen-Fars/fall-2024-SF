//Zero:top//
//Zero:import//
import java.util.*;

// <bit>:Zero ::= ZERO
public class Zero extends Bit /*Zero:class*/ {

    public static final String $className = "Zero";
    public static final String $ruleString =
        "<bit>:Zero ::= ZERO";



    public Zero() {
//Zero:init//

    }

    public static Zero parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<bit>:Zero", scn$.lno);
        scn$.match(Token.Match.ZERO, trace$);
        return new Zero();
    }

    public int eval() {
        return 0;
    }

//Zero//
}
