//TreeNode:top//
//TreeNode:import//
import java.util.*;

// <tree>:TreeNode ::= LPAREN <TAG> <tree>:leftNode <tree>:rightNode RPAREN
public class TreeNode extends Tree /*TreeNode:class*/ {

    public static final String $className = "TreeNode";
    public static final String $ruleString =
        "<tree>:TreeNode ::= LPAREN <TAG> <tree>:leftNode <tree>:rightNode RPAREN";

    public Token tag;
    public Tree leftNode;
    public Tree rightNode;

    public TreeNode(Token tag, Tree leftNode, Tree rightNode) {
//TreeNode:init//
        this.tag = tag;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public static TreeNode parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<tree>:TreeNode", scn$.lno);
        scn$.match(Token.Match.LPAREN, trace$);
        Token tag = scn$.match(Token.Match.TAG, trace$);
        Tree leftNode = Tree.parse(scn$, trace$);
        Tree rightNode = Tree.parse(scn$, trace$);
        scn$.match(Token.Match.RPAREN, trace$);
        return new TreeNode(tag, leftNode, rightNode);
    }

    public String toString() {
        return "(" + tag + " " + leftNode + " " + rightNode + ")";
    }

//TreeNode//
}
