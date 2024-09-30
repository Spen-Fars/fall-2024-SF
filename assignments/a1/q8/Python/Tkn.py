#Tkn:top#
#Tkn:import#

# <rule>:Tkn ::= <TOKEN>
class Tkn(Rule): #Tkn:class#

    className = "Tkn"
    ruleString = "<rule>:Tkn ::= <TOKEN>"
    token = None

    def __init__(token):
        #Tkn:init#
        self.token = token

#Tkn#
