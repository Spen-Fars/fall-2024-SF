#Lon:top#
#Lon:import#

# <lon> ::= LP <nums> RP
class Lon(_Start): #Lon:class#

    className = "Lon"
    ruleString = "<lon> ::= LP <nums> RP"
    nums = None

    def __init__(nums):
        #Lon:init#
        self.nums = nums

#Lon#
