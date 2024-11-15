//Exp:top//
//Exp:import//
import java.util.*;

public abstract class Exp /*Exp:class*/ {

    public static final String $className = "Exp";
    public static Exp parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case FALSE:
            return FalseExp.parse(scn$,trace$);
        case SET:
            return SetExp.parse(scn$,trace$);
        case LBRACE:
            return SeqExp.parse(scn$,trace$);
        case TRUE:
            return TrueExp.parse(scn$,trace$);
        case LIT:
            return LitExp.parse(scn$,trace$);
        case IF:
            return IfExp.parse(scn$,trace$);
        case DOT:
            return AppExp.parse(scn$,trace$);
        case LETREC:
            return LetrecExp.parse(scn$,trace$);
        case PROC:
            return ProcExp.parse(scn$,trace$);
        case ADD1OP:
        case LEP:
        case GEP:
        case MULOP:
        case GTP:
        case ANDOP:
        case NEP:
        case OROP:
        case LTP:
        case ADDOP:
        case NOTOP:
        case DIVOP:
        case EQP:
        case SUBOP:
        case SUB1OP:
        case ZEROP:
            return PrimappExp.parse(scn$,trace$);
        case LET:
            return LetExp.parse(scn$,trace$);
        case VAR:
            return VarExp.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Exp cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Val eval(Env env);
    public abstract Type evalType(TypeEnv tenv);

//Exp//
}
