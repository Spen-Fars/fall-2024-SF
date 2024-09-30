//Pnths:top//
//Pnths:import//
import java.util.*;

public abstract class Pnths /*Pnths:class*/ {

    public static final String $className = "Pnths";
    public static Pnths parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case LP:
            return Node.parse(scn$,trace$);
        case RP:
        case AT:
            return Null.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Pnths cannot begin with " + t$.errString()
            );
        }
    }

//Pnths//
}
