//Exp:top//
//Exp:import//
import java.util.*;

public abstract class Exp /*Exp:class*/ {

    public static final String $className = "Exp";
    public static Exp parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case PROC:
            return ProcExp.parse(scn$,trace$);
        case IF:
            return IfExp.parse(scn$,trace$);
        case MULOP:
        case SUB1OP:
        case SUBOP:
        case ADD1OP:
        case ZEROP:
        case DIVOP:
        case ADDOP:
            return PrimappExp.parse(scn$,trace$);
        case DOT:
            return AppExp.parse(scn$,trace$);
        case SET:
            return SetExp.parse(scn$,trace$);
        case VAR:
            return VarExp.parse(scn$,trace$);
        case LETREC:
            return LetrecExp.parse(scn$,trace$);
        case LIT:
            return LitExp.parse(scn$,trace$);
        case LET:
            return LetExp.parse(scn$,trace$);
        case LBRACE:
            return SeqExp.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Exp cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Val eval(Env env);

//Exp//
}