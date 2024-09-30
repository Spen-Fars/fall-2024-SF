#Lexspec:top#
#Lexspec:import#

# <lexspec> ::= <rule> <NAME> <QUOTE>
class Lexspec(_Start): #Lexspec:class#

    className = "Lexspec"
    ruleString = "<lexspec> ::= <rule> <NAME> <QUOTE>"
    rule = None
    name = None
    quote = None

    def __init__(rule, name, quote):
        #Lexspec:init#
        self.rule = rule
        self.name = name
        self.quote = quote

#Lexspec#
