//Null:top//
//Null:import//
import java.util.*;

// <rule>:Null ::= 
public class Null extends Rule /*Null:class*/ {

    public static final String $className = "Null";
    public static final String $ruleString =
        "<rule>:Null ::= ";



    public Null() {
//Null:init//

    }

    public static Null parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<rule>:Null", scn$.lno);
        return new Null();
    }

    public String toString() {
        return "";
    }

//Null//
}
