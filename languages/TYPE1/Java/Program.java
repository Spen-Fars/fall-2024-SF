//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case DEFINE:
            return Define.parse(scn$,trace$);
        case DECLARE:
            return Declare.parse(scn$,trace$);
        case SET:
        case ADD1OP:
        case LEP:
        case LET:
        case GEP:
        case ANDOP:
        case GTP:
        case SUB1OP:
        case NEP:
        case SUBOP:
        case FALSE:
        case DOT:
        case OROP:
        case TRUE:
        case LETREC:
        case ZEROP:
        case LTP:
        case DIVOP:
        case MULOP:
        case EQP:
        case VAR:
        case NOTOP:
        case IF:
        case LIT:
        case ADDOP:
        case LBRACE:
        case PROC:
            return Eval.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Program cannot begin with " + t$.errString()
            );
        }
    }

    public static Env env = Env.initEnv(); // top-level value environment
    public static TypeEnv tenv = TypeEnv.initTypeEnv(); // top-level type env

//Program//
}
