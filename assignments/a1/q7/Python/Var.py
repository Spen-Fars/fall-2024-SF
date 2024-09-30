#Var:top#
#Var:import#

# <var> ::= AT <LP>
class Var(): #Var:class#

    className = "Var"
    ruleString = "<var> ::= AT <LP>"
    lp = None

    def __init__(lp):
        #Var:init#
        self.lp = lp

#Var#
