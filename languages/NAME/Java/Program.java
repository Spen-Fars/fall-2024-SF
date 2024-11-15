//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case ZEROP:
        case SUB1OP:
        case SUBOP:
        case ADDOP:
        case LET:
        case LBRACE:
        case LETREC:
        case PROC:
        case DOT:
        case IF:
        case ADD1OP:
        case VAR:
        case MULOP:
        case SET:
        case LIT:
        case DIVOP:
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
