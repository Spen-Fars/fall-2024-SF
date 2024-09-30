#ParStart:top#
#ParStart:import#

# <paren>:ParStart ::= LP <paren>
class ParStart(Paren): #ParStart:class#

    className = "ParStart"
    ruleString = "<paren>:ParStart ::= LP <paren>"
    paren = None

    def __init__(paren):
        #ParStart:init#
        self.paren = paren

#ParStart#
