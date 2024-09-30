//Node:top//
//Node:import//
import java.util.*;

// <pnths>:Node ::= LP <pnths>left RP <pnths>right
public class Node extends Pnths /*Node:class*/ {

    public static final String $className = "Node";
    public static final String $ruleString =
        "<pnths>:Node ::= LP <pnths>left RP <pnths>right";

    public Pnths left;
    public Pnths right;

    public Node(Pnths left, Pnths right) {
//Node:init//
        this.left = left;
        this.right = right;
    }

    public static Node parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<pnths>:Node", scn$.lno);
        scn$.match(Token.Match.LP, trace$);
        Pnths left = Pnths.parse(scn$, trace$);
        scn$.match(Token.Match.RP, trace$);
        Pnths right = Pnths.parse(scn$, trace$);
        return new Node(left, right);
    }

//Node//
}
