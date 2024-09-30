#Node:top#
#Node:import#

# <pnths>:Node ::= LP <pnths>left RP <pnths>right
class Node(Pnths): #Node:class#

    className = "Node"
    ruleString = "<pnths>:Node ::= LP <pnths>left RP <pnths>right"
    left = None
    right = None

    def __init__(left, right):
        #Node:init#
        self.left = left
        self.right = right

#Node#
