//Bit:top//
//Bit:import//
import java.util.*;

public abstract class Bit /*Bit:class*/ {

    public static final String $className = "Bit";
    public static Bit parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case ZERO:
            return Zero.parse(scn$,trace$);
        case ONE:
            return One.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Bit cannot begin with " + t$.errString()
            );
        }
    }

    public abstract int eval();

//Bit//
}
