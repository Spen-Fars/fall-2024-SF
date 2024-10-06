#Goo:top#
#Goo:import#

# <blah>:Goo ::= THIS <VAR> IS <silly>
class Goo(Blah): #Goo:class#

    className = "Goo"
    ruleString = "<blah>:Goo ::= THIS <VAR> IS <silly>"
    var = None
    silly = None

    def __init__(var, silly):
        #Goo:init#
        self.var = var
        self.silly = silly

#Goo#
