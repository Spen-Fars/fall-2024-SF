#TreeParen:top#
#TreeParen:import#

# <tree>:TreeParen ::= <NUM>
class TreeParen(Tree): #TreeParen:class#

    className = "TreeParen"
    ruleString = "<tree>:TreeParen ::= <NUM>"
    num = None

    def __init__(num):
        #TreeParen:init#
        self.num = num

#TreeParen#
