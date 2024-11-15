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
        case TRUE:
            return TrueExp.parse(scn$,trace$);
        case VAR:
            return VarExp.parse(scn$,trace$);
        case SET:
            return SetExp.parse(scn$,trace$);
        case LET:
            return LetExp.parse(scn$,trace$);
        case FALSE:
            return FalseExp.parse(scn$,trace$);
        case ADD1OP:
        case LTP:
        case ZEROP:
        case DIVOP:
        case LEP:
        case MULOP:
        case NOTOP:
        case EQP:
        case GEP:
        case ADDOP:
        case SUB1OP:
        case GTP:
        case NEP:
        case ANDOP:
        case SUBOP:
        case OROP:
            return PrimappExp.parse(scn$,trace$);
        case LIT:
            return LitExp.parse(scn$,trace$);
        case LETREC:
            return LetrecExp.parse(scn$,trace$);
        case LBRACE:
            return SeqExp.parse(scn$,trace$);
        case IF:
            return IfExp.parse(scn$,trace$);
        case DOT:
            return AppExp.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Exp cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Val eval(Env env);
    
    public Ref evalRef(Env env) {
        return new ValRef(eval(env));
    }
    
    public abstract Type evalType(TypeEnv tenv);

//Exp//
}
