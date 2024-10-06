#Start:top#
#Start:import#

# <start> ::= <bits> NL
class Start(_Start): #Start:class#

    className = "Start"
    ruleString = "<start> ::= <bits> NL"
    bits = None

    def __init__(bits):
        #Start:init#
        self.bits = bits

#Start#
