//Formals:top//
//Formals:import//
import java.util.*;

// <formals> **= <VAR> COLON <typeExp> +COMMA
public class Formals /*Formals:class*/ {

    public static final String $className = "Formals";
    public static final String $ruleString =
        "<formals> **= <VAR> COLON <typeExp> +COMMA";

    public List<Token> varList;
    public List<TypeExp> typeExpList;

    public Formals(List<Token> varList, List<TypeExp> typeExpList) {
        // check for duplicates during parsing
        Env.checkDuplicates(varList, " in proc formals");
//Formals:init//
        this.varList = varList;
        this.typeExpList = typeExpList;
    }

    public static Formals parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<formals>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<TypeExp> typeExpList = new ArrayList<TypeExp>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case VAR:
            while(true) {
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.COLON, trace$);
                typeExpList.add(TypeExp.parse(scn$, trace$));
                t$ = scn$.cur();
                match$ = t$.match;
                if (match$ != Token.Match.COMMA)
                    break; // not a separator, so we're done
                scn$.match(match$, trace$);
            }
        } // end of switch
        return new Formals(varList, typeExpList);

    }

//Formals//
}
