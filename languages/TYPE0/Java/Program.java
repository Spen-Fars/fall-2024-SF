//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case EQP:
        case LBRACE:
        case LTP:
        case MULOP:
        case VAR:
        case SUBOP:
        case ADD1OP:
        case GEP:
        case SET:
        case LEP:
        case ZEROP:
        case IF:
        case LIT:
        case DIVOP:
        case NEP:
        case LET:
        case TRUE:
        case LETREC:
        case FALSE:
        case SUB1OP:
        case DOT:
        case GTP:
        case ADDOP:
        case PROC:
            return Eval.parse(scn$,trace$);
        case DEFINE:
            return Define.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Program cannot begin with " + t$.errString()
            );
        }
    }

    public static Env env = Env.initEnv(); // the initial environment

//Program//
}
