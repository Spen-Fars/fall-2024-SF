#Lon:top#
#Lon:import#

# <lon> ::= LPAREN <NUM> <nums> RPAREN
class Lon(_Start): #Lon:class#

    className = "Lon"
    ruleString = "<lon> ::= LPAREN <NUM> <nums> RPAREN"
    num = None
    nums = None

    def __init__(num, nums):
        #Lon:init#
        self.num = num
        self.nums = nums

#Lon#
