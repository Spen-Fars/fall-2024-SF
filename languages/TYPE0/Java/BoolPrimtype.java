//BoolPrimtype:top//
//BoolPrimtype:import//
import java.util.*;

// <primType>:BoolPrimtype ::= BOOL
public class BoolPrimtype extends PrimType /*BoolPrimtype:class*/ {

    public static final String $className = "BoolPrimtype";
    public static final String $ruleString =
        "<primType>:BoolPrimtype ::= BOOL";



    public BoolPrimtype() {
//BoolPrimtype:init//

    }

    public static BoolPrimtype parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<primType>:BoolPrimtype", scn$.lno);
        scn$.match(Token.Match.BOOL, trace$);
        return new BoolPrimtype();
    }

//BoolPrimtype//
}
