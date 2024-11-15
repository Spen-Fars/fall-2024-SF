//Proc:top//
//Proc:import//
import java.util.*;

// <proc> ::= PROC LPAREN <formals> RPAREN COLON <typeExp> <exp>
public class Proc /*Proc:class*/ {

    public static final String $className = "Proc";
    public static final String $ruleString =
        "<proc> ::= PROC LPAREN <formals> RPAREN COLON <typeExp> <exp>";

    public Formals formals;
    public TypeExp typeExp;
    public Exp exp;

    public Proc(Formals formals, TypeExp typeExp, Exp exp) {
//Proc:init//
        this.formals = formals;
        this.typeExp = typeExp;
        this.exp = exp;
    }

    public static Proc parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<proc>", scn$.lno);
        scn$.match(Token.Match.PROC, trace$);
        scn$.match(Token.Match.LPAREN, trace$);
        Formals formals = Formals.parse(scn$, trace$);
        scn$.match(Token.Match.RPAREN, trace$);
        scn$.match(Token.Match.COLON, trace$);
        TypeExp typeExp = TypeExp.parse(scn$, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Proc(formals, typeExp, exp);
    }

    public Val makeClosure(Env env) {
        return new ProcVal(formals, exp, env);
    }

//Proc//
}
