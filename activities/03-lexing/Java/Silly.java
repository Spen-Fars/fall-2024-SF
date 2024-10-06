//Silly:top//
//Silly:import//
import java.util.*;

// <silly> ::= VAR
public class Silly extends _Start /*Silly:class*/ {

    public static final String $className = "Silly";
    public static final String $ruleString =
        "<silly> ::= VAR";



    public Silly() {
//Silly:init//

    }

    public static Silly parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<silly>", scn$.lno);
        scn$.match(Token.Match.VAR, trace$);
        return new Silly();
    }

//Silly//
}
