#TreeNode:top#
#TreeNode:import#

# <tree>:TreeNode ::= LP <tree>:leftNode <tree>:rightNode RP
class TreeNode(Tree): #TreeNode:class#

    className = "TreeNode"
    ruleString = "<tree>:TreeNode ::= LP <tree>:leftNode <tree>:rightNode RP"
    leftNode = None
    rightNode = None

    def __init__(leftNode, rightNode):
        #TreeNode:init#
        self.leftNode = leftNode
        self.rightNode = rightNode

#TreeNode#
