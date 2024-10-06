//Lon:top//
//Lon:import//
import java.util.*;

// <lon> ::= LPAREN <NUM> <nums> RPAREN
public class Lon extends _Start /*Lon:class*/ {

    public static final String $className = "Lon";
    public static final String $ruleString =
        "<lon> ::= LPAREN <NUM> <nums> RPAREN";

    public Token num;
    public Nums nums;

    public Lon(Token num, Nums nums) {
//Lon:init//
        this.num = num;
        this.nums = nums;
    }

    public static Lon parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<lon>", scn$.lno);
        scn$.match(Token.Match.LPAREN, trace$);
        Token num = scn$.match(Token.Match.NUM, trace$);
        Nums nums = Nums.parse(scn$, trace$);
        scn$.match(Token.Match.RPAREN, trace$);
        return new Lon(num, nums);
    }

    public void $run() {
        int m = min();
        System.out.println("" + m);
    }
    
    public int min() {
        int minSoFar = Integer.parseInt(num.toString());
        return nums.min(minSoFar); // Get the overall minimum.
    }
    
    // public String toString(Token tostr) {
    //     return tostr.toString();
    // }

//Lon//
}
