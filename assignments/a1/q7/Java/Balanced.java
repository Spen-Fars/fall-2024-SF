//Balanced:top//
//Balanced:import//
import java.util.*;

// <balanced> ::= <pnths> AT
public class Balanced extends _Start /*Balanced:class*/ {

    public static final String $className = "Balanced";
    public static final String $ruleString =
        "<balanced> ::= <pnths> AT";

    public Pnths pnths;

    public Balanced(Pnths pnths) {
//Balanced:init//
        this.pnths = pnths;
    }

    public static Balanced parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<balanced>", scn$.lno);
        Pnths pnths = Pnths.parse(scn$, trace$);
        scn$.match(Token.Match.AT, trace$);
        return new Balanced(pnths);
    }

//Balanced//
}
