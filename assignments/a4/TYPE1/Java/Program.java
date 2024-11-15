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
        case ADD1OP:
        case LEP:
        case TRUE:
        case PROC:
        case GTP:
        case ANDOP:
        case NEP:
        case DOT:
        case ADDOP:
        case EQP:
        case SUBOP:
        case LTP:
        case MULOP:
        case SUB1OP:
        case IF:
        case LETREC:
        case LET:
        case GEP:
        case FALSE:
        case OROP:
        case NOTOP:
        case VAR:
        case DIVOP:
        case LIT:
        case ZEROP:
        case SET:
        case LBRACE:
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
