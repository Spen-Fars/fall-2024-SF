#ParOp:top#
#ParOp:import#

# <paren>:ParOp ::= LP <paren> RP
class ParOp(Paren): #ParOp:class#

    className = "ParOp"
    ruleString = "<paren>:ParOp ::= LP <paren> RP"
    paren = None

    def __init__(paren):
        #ParOp:init#
        self.paren = paren

#ParOp#
