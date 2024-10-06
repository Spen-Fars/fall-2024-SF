//Goo:top//
//Goo:import//
import java.util.*;

// <blah>:Goo ::= THIS <VAR> IS <silly>
public class Goo extends Blah /*Goo:class*/ {

    public static final String $className = "Goo";
    public static final String $ruleString =
        "<blah>:Goo ::= THIS <VAR> IS <silly>";

    public Token var;
    public Silly silly;

    public Goo(Token var, Silly silly) {
//Goo:init//
        this.var = var;
        this.silly = silly;
    }

    public static Goo parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<blah>:Goo", scn$.lno);
        scn$.match(Token.Match.THIS, trace$);
        Token var = scn$.match(Token.Match.VAR, trace$);
        scn$.match(Token.Match.IS, trace$);
        Silly silly = Silly.parse(scn$, trace$);
        return new Goo(var, silly);
    }

//Goo//
}
