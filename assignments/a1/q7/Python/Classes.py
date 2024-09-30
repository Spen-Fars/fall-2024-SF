#Classes:top#
#Classes:import#

# <classes> ::= <CSIT>c1 <CSIT>c2 <CSIT>c3
class Classes(_Start): #Classes:class#

    className = "Classes"
    ruleString = "<classes> ::= <CSIT>c1 <CSIT>c2 <CSIT>c3"
    c1 = None
    c2 = None
    c3 = None

    def __init__(c1, c2, c3):
        #Classes:init#
        self.c1 = c1
        self.c2 = c2
        self.c3 = c3

#Classes#
