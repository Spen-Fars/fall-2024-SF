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
        case LIT:
        case DIVOP:
        case IF:
        case ADD1OP:
        case PROC:
        case SUBOP:
        case VAR:
        case LBRACE:
        case DOT:
        case LET:
        case LETREC:
        case SUB1OP:
        case ADDOP:
        case SET:
        case ZEROP:
        case MULOP:
            return Eval.parse(scn$,trace$);
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
