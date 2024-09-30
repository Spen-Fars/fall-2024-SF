//Tkn:top//
//Tkn:import//
import java.util.*;

// <rule>:Tkn ::= <TOKEN>
public class Tkn extends Rule /*Tkn:class*/ {

    public static final String $className = "Tkn";
    public static final String $ruleString =
        "<rule>:Tkn ::= <TOKEN>";

    public Token token;

    public Tkn(Token token) {
//Tkn:init//
        this.token = token;
    }

    public static Tkn parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<rule>:Tkn", scn$.lno);
        Token token = scn$.match(Token.Match.TOKEN, trace$);
        return new Tkn(token);
    }

//Tkn//
}
