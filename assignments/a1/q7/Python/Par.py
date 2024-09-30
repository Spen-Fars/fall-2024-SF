#Par:top#
#Par:import#

# <paren>:Par ::= LP <paren>right RP
class Par(Paren): #Par:class#

    className = "Par"
    ruleString = "<paren>:Par ::= LP <paren>right RP"
    right = None

    def __init__(right):
        #Par:init#
        self.right = right

#Par#
