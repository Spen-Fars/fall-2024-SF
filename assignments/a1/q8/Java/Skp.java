//Skp:top//
//Skp:import//
import java.util.*;

// <rule>:Skp ::= <SKIP>
public class Skp extends Rule /*Skp:class*/ {

    public static final String $className = "Skp";
    public static final String $ruleString =
        "<rule>:Skp ::= <SKIP>";

    public Token skip;

    public Skp(Token skip) {
//Skp:init//
        this.skip = skip;
    }

    public static Skp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<rule>:Skp", scn$.lno);
        Token skip = scn$.match(Token.Match.SKIP, trace$);
        return new Skp(skip);
    }

//Skp//
}
