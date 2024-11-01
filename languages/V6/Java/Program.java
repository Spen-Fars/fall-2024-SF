//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case VAR:
        case ZEROP:
        case IF:
        case LBRACE:
        case ADD1OP:
        case MULOP:
        case DOT:
        case DIVOP:
        case ADDOP:
        case SUBOP:
        case PROC:
        case LET:
        case SUB1OP:
        case LIT:
        case LETREC:
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
