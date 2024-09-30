#TreeNode:top#
#TreeNode:import#

# <tree>:TreeNode ::= LPAREN <TAG> <tree>:leftNode <tree>:rightNode RPAREN
class TreeNode(Tree): #TreeNode:class#

    className = "TreeNode"
    ruleString = "<tree>:TreeNode ::= LPAREN <TAG> <tree>:leftNode <tree>:rightNode RPAREN"
    tag = None
    leftNode = None
    rightNode = None

    def __init__(tag, leftNode, rightNode):
        #TreeNode:init#
        self.tag = tag
        self.leftNode = leftNode
        self.rightNode = rightNode

#TreeNode#
