//Blah:top//
//Blah:import//
import java.util.*;

public abstract class Blah /*Blah:class*/ {

    public static final String $className = "Blah";
    public static Blah parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case THIS:
            return Goo.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Blah cannot begin with " + t$.errString()
            );
        }
    }

//Blah//
}
