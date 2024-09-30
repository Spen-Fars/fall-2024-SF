#Skp:top#
#Skp:import#

# <rule>:Skp ::= <SKIP>
class Skp(Rule): #Skp:class#

    className = "Skp"
    ruleString = "<rule>:Skp ::= <SKIP>"
    skip = None

    def __init__(skip):
        #Skp:init#
        self.skip = skip

#Skp#
