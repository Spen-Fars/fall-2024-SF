#Balanced:top#
#Balanced:import#

# <balanced> ::= <pnths> AT
class Balanced(_Start): #Balanced:class#

    className = "Balanced"
    ruleString = "<balanced> ::= <pnths> AT"
    pnths = None

    def __init__(pnths):
        #Balanced:init#
        self.pnths = pnths

#Balanced#
