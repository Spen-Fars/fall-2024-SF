//Lexspec:top//
//Lexspec:import//
import java.util.*;

// <lexspec> ::= <rule> <NAME> <QUOTE>
public class Lexspec extends _Start /*Lexspec:class*/ {

    public static final String $className = "Lexspec";
    public static final String $ruleString =
        "<lexspec> ::= <rule> <NAME> <QUOTE>";

    public Rule rule;
    public Token name;
    public Token quote;

    public Lexspec(Rule rule, Token name, Token quote) {
//Lexspec:init//
        this.rule = rule;
        this.name = name;
        this.quote = quote;
    }

    public static Lexspec parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<lexspec>", scn$.lno);
        Rule rule = Rule.parse(scn$, trace$);
        Token name = scn$.match(Token.Match.NAME, trace$);
        Token quote = scn$.match(Token.Match.QUOTE, trace$);
        return new Lexspec(rule, name, quote);
    }

//Lexspec//
}
