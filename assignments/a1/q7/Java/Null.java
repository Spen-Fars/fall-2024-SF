//Null:top//
//Null:import//
import java.util.*;

// <pnths>:Null ::= 
public class Null extends Pnths /*Null:class*/ {

    public static final String $className = "Null";
    public static final String $ruleString =
        "<pnths>:Null ::= ";



    public Null() {
//Null:init//

    }

    public static Null parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<pnths>:Null", scn$.lno);
        return new Null();
    }

//Null//
}
